package oodmod.block.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
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
	    this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));
	    this.setCreativeTab(MainClass.OodModTab);
    }

	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    
	    int i = 0;

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
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

	@Override
	public boolean isOpaqueCube() {
		return !fancyGraphics;
	}

	@Override
	public boolean isVisuallyOpaque() {
	    return false;
	}

    @Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1))); 
	}

    // Enum for leave types, not needed at the moment
	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}
	
}
