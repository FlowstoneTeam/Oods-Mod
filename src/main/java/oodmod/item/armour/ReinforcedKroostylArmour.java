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
			
		// TODO: Remove after transferring logic
		/*if (placement == 0) {
			setTextureName(MainClass.MODID + ":ReinforcedKroostylHelmet");
		}
		else if (placement == 1) {
			setTextureName(MainClass.MODID + ":ReinforcedKroostylChestplate");
		}
		else if (placement == 2) {
			setTextureName(MainClass.MODID + ":ReinforcedKroostylLeggings");
		}
		else if (placement == 3) {
			setTextureName(MainClass.MODID + ":ReinforcedKroostylBoots");
		}*/
			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ItemClass.ReinforcedKroostylHelmet || stack.getItem() == ItemClass.ReinforcedKroostylChestplate || stack.getItem() == ItemClass.ReinforcedKroostylBoots) {
			return MainClass.MODID + ":textures/models/armor/ReinforcedKroostylArmour_1.png";
		}
		if (stack.getItem() == ItemClass.ReinforcedKroostylLeggings) {
			return MainClass.MODID + ":textures/models/armor/ReinforcedKroostylArmour_2.png";
		}
		else {
			return null;
		}
	}

}