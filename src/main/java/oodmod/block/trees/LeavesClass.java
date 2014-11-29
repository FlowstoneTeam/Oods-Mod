package oodmod.block.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oodmod.block.BlockClass;
import oodmod.main.MainClass;

public class LeavesClass extends BlockLeaves {

	public static final String[][] leaftypes = new String[][] {{"OrangeLeaves", "OrangeLeavesOpaque"}};
	public static final String[] leaves = new String[] {"Orange"};
	
	public LeavesClass() {
	    this.setCreativeTab(MainClass.OodModTab);
    }
	
	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] {field_176236_b, field_176237_a});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState().withProperty(field_176237_a, Boolean.valueOf((meta & 4) == 0)).withProperty(field_176236_b, Boolean.valueOf((meta & 8) > 0));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
	    
	    int i = 0;

        if (!((Boolean)state.getValue(field_176237_a)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(field_176236_b)).booleanValue())
        {
            i |= 8;
        }

        return i;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockClass.Sapling);
    }

	@Override
	public int getDamageValue(World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		return iblockstate.getBlock().getMetaFromState(iblockstate) & 0x3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		  
		  for (int i = 0; i < leaves.length; i++) {
				list.add(new ItemStack(item, 1, i));
		  }
	  }

	// TODO: Remove after transferring logic
	/*@Override
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister) {
	    for (int i = 0; i < leaftypes.length; i++) {
	      this.field_150129_M[i] = new IIcon[leaftypes[i].length];

	      for (int j = 0; j < leaftypes[i].length; j++)
	        this.field_150129_M[i][j] = iconRegister.registerIcon(MainClass.MODID + ":" + leaftypes[i][j]);
	    }

		setCreativeTab(MainClass.OodModTab);
	    
	  }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return leaves;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}*/
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		// TODO Auto-generated method stub
		return super.shouldSideBeRendered(worldIn, pos, side);
	}

    @Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return new java.util.ArrayList<ItemStack>(java.util.Arrays.asList(new ItemStack(this, 1))); 
	}

    // Enum for leave types, not needed at the moment
	@Override
	public EnumType func_176233_b(int p_176233_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
