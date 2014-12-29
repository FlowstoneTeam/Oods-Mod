package oodmod.item.tools;

import net.minecraft.item.ItemHoe;
import oodmod.main.MainClass;

public class KroostylHoeClass extends ItemHoe {

	public KroostylHoeClass(ToolMaterial material) {
		super(material);
		
		setCreativeTab(MainClass.OodModTab);
	}
}