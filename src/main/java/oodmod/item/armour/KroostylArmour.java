package oodmod.item.armour;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import oodmod.item.ItemClass;
import oodmod.main.MainClass;

public class KroostylArmour extends ItemArmor {

	public KroostylArmour(ArmorMaterial material, int ID, int placement) {
		super(material, ID, placement);
			
		setCreativeTab(MainClass.OodModTab);
			
		if (placement == 0) {
			setTextureName(MainClass.MODID + ":KroostylHelmet");
		}
		else if (placement == 1) {
			setTextureName(MainClass.MODID + ":KroostylChestplate");
		}
		else if (placement == 2) {
			setTextureName(MainClass.MODID + ":KroostylLeggings");
		}
		else if (placement == 3) {
			setTextureName(MainClass.MODID + ":KroostylBoots");
		}
			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ItemClass.KroostylHelmet || stack.getItem() == ItemClass.KroostylChestplate || stack.getItem() == ItemClass.KroostylBoots) {
			return MainClass.MODID + ":textures/models/armor/KroostylArmour_1.png";
		}
		if (stack.getItem() == ItemClass.KroostylLeggings) {
			return MainClass.MODID + ":textures/models/armor/KroostylArmour_2.png";
		}
		else {
			return null;
		}
	}

}