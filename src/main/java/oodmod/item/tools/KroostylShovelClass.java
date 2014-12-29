package oodmod.item.tools;

import net.minecraft.item.ItemSpade;
import oodmod.main.MainClass;

public class KroostylShovelClass extends ItemSpade {

	public KroostylShovelClass(ToolMaterial material) {
		super(material);

		setCreativeTab(MainClass.OodModTab);
	}
}