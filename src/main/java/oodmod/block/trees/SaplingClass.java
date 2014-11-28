package oodmod.block.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import oodmod.block.BlockClass;
import oodmod.main.MainClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import oodmod.worldgen.*;

public class SaplingClass extends BlockSapling {

	  public static final String[] saplings = {"Orange"};
	  private static final IIcon[] iconLength = new IIcon[saplings.length];

	  public SaplingClass()
	  {
	    float f = 0.4F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	    setCreativeTab(MainClass.OodModTab);
		setStepSound(soundTypeGrass);
	  }

	  @Override
	  public void updateTick(World world, int x, int y, int z, Random random)
	  {
	    if (!world.isRemote)
	    {
	      super.updateTick(world, x, y, z, random);

	      if ((world.getBlockLightValue(x, y + 1, z) >= 9) && (random.nextInt(7) == 0))
	      {
	        func_149879_c(world, x, y, z, random);
	      }
	    }
	  }

	  @Override
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int side, int meta)
	  {
	    meta &= 7;
	    return iconLength[MathHelper.clamp_int(meta, 0, 5)];
	  }

	  @Override
	  public void func_149879_c(World world, int x, int y, int z, Random random)
	  {
	    int l = world.getBlockMetadata(x, y, z);

	    if ((l & 0x8) == 0)
	    {
	      world.setBlockMetadataWithNotify(x, y, z, l | 0x8, 4);
	    }
	    else
	    {
	      func_149878_d(world, x, y, z, random);
	    }
	  }

	  @Override
	  public void func_149878_d(World world, int x, int y, int z, Random random)
	  {
	    if (!TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
	    int l = world.getBlockMetadata(x, y, z) & 0x7;
	    Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
	    int i1 = 0;
	    int j1 = 0;
	    boolean flag = false;

	    switch (l)
	    {
	    case 0:
	    	object = new OrangeTreeGenerationClass(BlockClass.Log, BlockClass.Leaves, 0, 0, false, 4, 6, false);
	    	break;
	    case 1:
	    	break;
	    case 2:
	    	break;
	    case 3:
	    	break;
	    case 4:
	    	break;
	    case 5:
	    	break;
	    default:
	    	break;
	    }
	    
	    Block block = Blocks.air;

	    if (flag)
	    {
	      world.setBlock(x + i1, y, z + j1, block, 0, 4);
	      world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
	      world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
	      world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
	    }
	    else
	    {
	      world.setBlock(x, y, z, block, 0, 4);
	    }

	    if (!((WorldGenerator)object).generate(world, random, x + i1, y, z + j1))
	    {
	      if (flag)
	      {
	        world.setBlock(x + i1, y, z + j1, this, l, 4);
	        world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
	        world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
	        world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
	      }
	      else
	      {
	        world.setBlock(x, y, z, this, l, 4);
	      }
	    }
	  }

	  @Override
	  public boolean func_149880_a(World world, int x, int y, int z, int par1)
	  {
	    return (world.getBlock(x, y, z) == this) && ((world.getBlockMetadata(x, y, z) & 0x7) == par1);
	  }

	  @Override
	  public int damageDropped(int par1)
	  {
	    return MathHelper.clamp_int(par1 & 0x7, 0, 5);
	  }

	  @Override
	  @SideOnly(Side.CLIENT)
	  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		  
		  for (int i = 0; i < saplings.length; i++) {
				list.add(new ItemStack(item, 1, i));
		  }
	  }

	  @Override
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister)
	  {
	    for (int i = 0; i < iconLength.length; i++)
	    {
	      iconLength[i] = iconRegister.registerIcon(MainClass.MODID + ":" + saplings[i] + "Sapling");
	    }
	  }

	  @Override
	  public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
	  {
	    return true;
	  }

	  @Override
	  public boolean func_149852_a(World world, Random random, int x, int y, int z)
	  {
	    return world.rand.nextFloat() < 0.45D;
	  }

	  @Override
	  public void func_149853_b(World world, Random random, int x, int y, int z)
	  {
	    func_149879_c(world, x, y, z, random);
	  }
	
}
