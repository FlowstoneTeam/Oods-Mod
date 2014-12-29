package oodmod.block.trees;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oodmod.main.MainClass;

public class LogClass extends BlockLog {
	public static final String[] logs = new String[] {"Orange"};

	public LogClass() {
		setCreativeTab(MainClass.OodModTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
	    IBlockState state = this.getDefaultState();

	    int axis = meta % 4;

        switch (axis) {
            case 0:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 1:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 2:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

	    return state;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    return ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)).ordinal();
	}

	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { LOG_AXIS });
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1);
    }

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < logs.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

}
