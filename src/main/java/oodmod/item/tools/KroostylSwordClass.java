package oodmod.item.tools;

import net.minecraft.item.ItemSword;
import oodmod.main.MainClass;

public class KroostylSwordClass extends ItemSword {

	public KroostylSwordClass(ToolMaterial material) {
		super(material);

		setCreativeTab(MainClass.OodModTab);
	}
}