package oodmod.block.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
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

public class LeavesClass extends BlockLeaves {

	public static final String[][] leaftypes = new String[][] {{"OrangeLeaves", "OrangeLeavesOpaque"}};
	public static final String[] leaves = new String[] {"Orange"};
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumType func_176233_b(int p_176233_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
