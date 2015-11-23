package oodmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import oodmod.block.BlockClass;
import oodmod.block.trees.SaplingClass;

public class OrangeTreeGenerationClass extends WorldGenAbstractTree
{
  private final int minTreeHeight;
  private final int randomTreeHeight;
  
  private final IBlockState metaWood;
  private final IBlockState metaLeaves;

  public OrangeTreeGenerationClass(IBlockState metaWood, IBlockState metaLeaves)
  {
    this(metaWood, metaLeaves, false, 4, 3, false);
  }

  public OrangeTreeGenerationClass(IBlockState metaWood, IBlockState metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
  {
    super(doBlockNotify);
    
    this.minTreeHeight = minTreeHeight;
    this.randomTreeHeight = randomTreeHeight;
    this.metaWood = metaWood;
    this.metaLeaves = metaLeaves;
  }

  @Override
  public boolean generate(World worldIn, Random rand, BlockPos pos) {
	  int par3 = pos.getX();
	  int par4 = pos.getY();
	  int par5 = pos.getZ();
 
    int l = rand.nextInt(3) + this.minTreeHeight;
    boolean flag = true;

    if ((par4 >= 1) && (par4 + l + 1 <= 256))
    {
      for (int i1 = par4; i1 <= par4 + 1 + l; i1++)
      {
        byte b0 = 1;

        if (i1 == par4)
        {
          b0 = 0;
        }

        if (i1 >= par4 + 1 + l - 2)
        {
          b0 = 2;
        }

        for (int j1 = par3 - b0; (j1 <= par3 + b0) && (flag); j1++)
        {
          for (int k1 = par5 - b0; (k1 <= par5 + b0) && (flag); k1++)
          {
            if ((i1 >= 0) && (i1 < 256))
            {
            	BlockPos pos1 = new BlockPos(j1,i1,k1);
            	if (!isReplaceable(worldIn,pos1))
              {
                flag = false;
              }
            }
            else
            {
              flag = false;
            }
          }
        }
      }

      if (!flag)
      {
        return false;
      }

      Block block2 = worldIn.getBlockState(pos.down()).getBlock();

      boolean isSoil = block2.canSustainPlant(worldIn, pos, EnumFacing.UP, (SaplingClass)BlockClass.Sapling);
      if ((isSoil) && (par4 < 256 - l - 1))
      {
        block2.onPlantGrow(worldIn, pos.down(), pos);
        byte b0 = 3;
        byte b1 = 0;

        for (int k1 = par4 - b0 + l; k1 <= par4 + l; k1++)
        {
          int i3 = k1 - (par4 + l);
          int l1 = b1 + 1 - i3 / 2;

          for (int i2 = par3 - l1; i2 <= par3 + l1; i2++)
          {
            int j2 = i2 - par3;

            for (int k2 = par5 - l1; k2 <= par5 + l1; k2++)
            {
              int l2 = k2 - par5;

              if ((Math.abs(j2) != l1) || (Math.abs(l2) != l1) || ((rand.nextInt(2) != 0) && (i3 != 0)))
              {
            	  BlockPos pos1 = new BlockPos(i2, k1, k2);
            	  Block block1 = worldIn.getBlockState(pos1).getBlock();

                if ((block1.isAir(worldIn, pos1)) || (block1.isLeaves(worldIn, pos1)))
                {
                  setBlockAndNotifyAdequately(worldIn, pos1, this.metaLeaves);
                  
                }
              }
            }
          }
        }

        int k1;
		for (k1 = 0; k1 < l; k1++)
        {
			BlockPos upPos = pos.up(k1);
          Block block = worldIn.getBlockState(upPos).getBlock();

          if ((block.isAir(worldIn,upPos)) || (block.isLeaves(worldIn,upPos)))
          {
              setBlockAndNotifyAdequately(worldIn, upPos, this.metaWood);

          }
        }

        return true;
      }

      return false;
    }

    return false;
  }
}