package oodmod.creativetabs;

import oodmod.item.ItemClass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OodModTab extends CreativeTabs {

	public OodModTab(int arg0, String arg1) {
		super(arg0, arg1);
	}

	@Override
	public Item getTabIconItem() {
		return ItemClass.BoiledBroccoli;
	}
}
