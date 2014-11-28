package oodmod.block.trees;

import java.util.List;

import net.minecraft.block.BlockLog;
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
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < logs.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
		
	}
	
	// TODO: Remove after transferring logic
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		
		for (int i = 0; i < this.field_150167_a.length; i++) {
			this.field_150167_a[i] = iconRegister.registerIcon(MainClass.MODID + ":" + logs[i] + "Log");
			this.field_150166_b[i] = iconRegister.registerIcon(MainClass.MODID + ":" + logs[i] + "Log" + "Top");
			
		}
		
		
		
	}*/
	
}
