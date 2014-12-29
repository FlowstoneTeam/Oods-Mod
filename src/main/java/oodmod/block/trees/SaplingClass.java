package oodmod.block.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oodmod.block.BlockClass;
import oodmod.main.MainClass;
import oodmod.worldgen.OrangeTreeGenerationClass;

public class SaplingClass extends BlockBush implements IGrowable {

	  public static final String[] saplings = {"Orange"};
	  public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 // private static final IIcon[] iconLength = new IIcon[saplings.length];

	  public SaplingClass()
	  {
	    this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, 0));
	    float f = 0.4F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	    setCreativeTab(MainClass.OodModTab);
		setStepSound(soundTypeGrass);
	  }

	  @Override
	  public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(worldIn, pos, state, rand);
			}
		}
	  }

	  // TODO: Remove after transferring logic
	  /*@Override
	  @SideOnly(Side.CLIENT)
	  public IIcon getIcon(int side, int meta)
	  {
	    meta &= 7;
	    return iconLength[MathHelper.clamp_int(meta, 0, 5)];
	  }*/

	 /* @Override
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
	  }*/

	  //@Override
	//public void func_149878_d(World world, int x, int y, int z, Random random)
	  public void grow(World world, BlockPos pos, IBlockState state, Random random)
	  {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, pos)) return;
	    Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
	    int i1 = 0;
	    int j1 = 0;
	    boolean flag = false;

	    
	    object = new OrangeTreeGenerationClass(BlockClass.Log, BlockClass.Leaves, 0, 0, false, 4, 6, false);
	   
	    
	    IBlockState airState = Blocks.air.getDefaultState();

	    if (flag)
	    {
	      world.setBlockState(pos.add(i1, 0, j1), airState, 4);
	      world.setBlockState(pos.add(i1 + 1, 0, j1), airState, 4);
	      world.setBlockState(pos.add(i1, 0, j1 + 1), airState, 4);
	      world.setBlockState(pos.add(i1 + 1, 0, j1 + 1), airState, 4);
	    }
	    else
	    {
	      world.setBlockState(pos, airState, 4);
	    }

	    if (!((WorldGenerator)object).generate(world, random, pos.add(i1, 0, j1)))
	    {
	      if (flag)
	      {
	        world.setBlockState(pos.add( i1, 0, j1), state, 4);
	        world.setBlockState(pos.add( i1 + 1, 0, j1), state, 4);
	        world.setBlockState(pos.add( i1, 0, j1 + 1), state, 4);
	        world.setBlockState(pos.add( i1 + 1, 0, j1 + 1),state, 4);
	      }
	      else
	      {
	        world.setBlockState(pos, state, 4);
	      }
	    }
	  }

	  /*@Override
	  public boolean func_149880_a(World world, int x, int y, int z, int par1)
	  {
	    return (world.getBlock(x, y, z) == this) && ((world.getBlockMetadata(x, y, z) & 0x7) == par1);
	  }*/

	  @Override
	  public int damageDropped(IBlockState state) {
		return 0;
	  }

	  
	@Override
	  @SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		  
		  for (int i = 0; i < saplings.length; i++) {
				list.add(new ItemStack(item, 1, i));
		  }
	  }

	// TODO: Remove after transferring logic
	 /* @Override
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister)
	  {
	    for (int i = 0; i < iconLength.length; i++)
	    {
	      iconLength[i] = iconRegister.registerIcon(MainClass.MODID + ":" + saplings[i] + "Sapling");
	    }
	  }*/

	  /*@Override
	  public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
	  {
	    return true;
	  }*/

	 /* @Override
	  public boolean func_149852_a(World world, Random random, int x, int y, int z)
	  {
	    return world.rand.nextFloat() < 0.45D;
	  }*/

	  /*@Override
	  public void func_149853_b(World world, Random random, int x, int y, int z)
	  {
	    func_149879_c(world, x, y, z, random);
	  }*/
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(STAGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((Integer) state.getValue(STAGE)).intValue();
    }

	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] {STAGE});
	}

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.grow(worldIn, pos, state, rand);
    }

}
