package oodmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
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
  
  private final Block wood;
  private final Block leaves;
  
  private final int metaWood;
  private final int metaLeaves;

  public OrangeTreeGenerationClass(Block wood, Block leaves, int metaWood, int metaLeaves)
  {
    this(wood, leaves, metaWood, metaLeaves, false, 4, 3, false);
  }

  public OrangeTreeGenerationClass(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
  {
    super(doBlockNotify);
    
    this.wood = wood;
    this.leaves = leaves;
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
              //Block block = worldIn.getBlock(j1, i1, k1);
            	Block block = worldIn.getBlockState(pos1).getBlock();
              //if (!isReplaceable(worldIn, j1, i1, k1))
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
      

      //Block block2 = worldIn.getBlock(par3, par4 - 1, par5);
      Block block2 = worldIn.getBlockState(pos.down()).getBlock();

      //boolean isSoil = block2.canSustainPlant(worldIn, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)BlockClass.Sapling);
      boolean isSoil = block2.canSustainPlant(worldIn, pos, EnumFacing.UP, (SaplingClass)BlockClass.Sapling);
      if ((isSoil) && (par4 < 256 - l - 1))
      {
        //block2.onPlantGrow(worldIn, par3, par4 - 1, par5, par3, par4, par5);
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
                //Block block1 = worldIn.getBlock(i2, k1, k2);
            	  Block block1 = worldIn.getBlockState(pos1).getBlock();

                //if ((block1.isAir(worldIn, i2, k1, k2)) || (block1.isLeaves(worldIn, i2, k1, k2)))
                if ((block1.isAir(worldIn, pos1)) || (block1.isLeaves(worldIn, pos1)))
                {
                  //setBlockAndNotifyAdequately(worldIn, i2, k1, k2, BlockClass.Leaves, this.metaLeaves);
                  func_175905_a(worldIn, pos1, this.leaves, this.metaLeaves);
                  
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

          //if ((block.isAir(par1World, par3, par4 + k1, par5)) || (block.isLeaves(par1World, par3, par4 + k1, par5)))
          if ((block.isAir(worldIn,upPos)) || (block.isLeaves(worldIn,upPos)))
          {
            //setBlockAndNotifyAdequately(worldIn, par3, par4 + k1, par5, BlockClass.Log, this.metaWood);
            func_175905_a(worldIn, upPos, this.wood, this.metaWood);

          }
        }

        return true;
      }

      return false;
    }

    return false;
  }

}