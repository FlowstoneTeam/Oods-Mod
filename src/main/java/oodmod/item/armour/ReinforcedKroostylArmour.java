package oodmod.item.armour;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import oodmod.item.ItemClass;
import oodmod.main.MainClass;

public class ReinforcedKroostylArmour extends ItemArmor {

	public ReinforcedKroostylArmour(ArmorMaterial material, int ID, int placement) {
		super(material, ID, placement);

		setCreativeTab(MainClass.OodModTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ItemClass.ReinforcedKroostylHelmet || stack.getItem() == ItemClass.ReinforcedKroostylChestplate || stack.getItem() == ItemClass.ReinforcedKroostylBoots) {
			return MainClass.MODID + ":textures/models/armor/ReinforcedKroostylArmour_1.png";
		} else if (stack.getItem() == ItemClass.ReinforcedKroostylLeggings) {
			return MainClass.MODID + ":textures/models/armor/ReinforcedKroostylArmour_2.png";
		} else {
			return null;
		}
	}
}