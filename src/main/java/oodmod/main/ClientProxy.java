package oodmod.main;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import oodmod.item.ItemClass;

public class ClientProxy extends CommonProxy {
	
	public static void renderStuff() {
		
	}
	
	@Override
	public void registerModels() {
		
		
		RenderItem renderItem = FMLClientHandler.instance().getClient().getRenderItem();
		ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();
		
		// Seeds
		itemModelMesher.register(ItemClass.BroccoliSeeds, 0, new ModelResourceLocation("oodmod:BroccoliSeeds", "inventory"));
		itemModelMesher.register(ItemClass.OnionSeeds, 0, new ModelResourceLocation("oodmod:OnionSeeds", "inventory"));
		itemModelMesher.register(ItemClass.BeetrootSeeds, 0, new ModelResourceLocation("oodmod:BeetrootSeeds", "inventory"));
		itemModelMesher.register(ItemClass.CauliflowerSeeds, 0, new ModelResourceLocation("oodmod:CauliflowerSeeds", "inventory"));
		itemModelMesher.register(ItemClass.LeekSeeds, 0, new ModelResourceLocation("oodmod:LeekSeeds", "inventory"));
		itemModelMesher.register(ItemClass.GarlicSeeds, 0, new ModelResourceLocation("oodmod:GarlicSeeds", "inventory"));

		//Veg
		itemModelMesher.register(ItemClass.Broccoli, 0, new ModelResourceLocation("oodmod:Broccoli", "inventory"));
		itemModelMesher.register(ItemClass.Onion, 0, new ModelResourceLocation("oodmod:Onion", "inventory"));
		itemModelMesher.register(ItemClass.Beetroot, 0, new ModelResourceLocation("oodmod:Beetroot", "inventory"));
		itemModelMesher.register(ItemClass.Cauliflower, 0, new ModelResourceLocation("oodmod:Cauliflower", "inventory"));
		itemModelMesher.register(ItemClass.Leek, 0, new ModelResourceLocation("oodmod:Leek", "inventory"));
		itemModelMesher.register(ItemClass.Garlic, 0, new ModelResourceLocation("oodmod:Garlic", "inventory"));

		itemModelMesher.register(ItemClass.BoiledBroccoli, 0, new ModelResourceLocation("oodmod:BoiledBroccoli", "inventory"));
		itemModelMesher.register(ItemClass.OrangeBroccoli, 0, new ModelResourceLocation("oodmod:OrangeBroccoli", "inventory"));

		//Fruit
		itemModelMesher.register(ItemClass.Orange, 0, new ModelResourceLocation("oodmod:Orange", "inventory"));
		itemModelMesher.register(ItemClass.Banana, 0, new ModelResourceLocation("oodmod:Banana", "inventory"));
		itemModelMesher.register(ItemClass.Mango, 0, new ModelResourceLocation("oodmod:Mango", "inventory"));

		//Ingots & Gems
		itemModelMesher.register(ItemClass.Kroostyl, 0, new ModelResourceLocation("oodmod:Kroostyl", "inventory"));

		//Tools
		itemModelMesher.register(ItemClass.KroostylShovel, 0, new ModelResourceLocation("oodmod:KroostylShovel", "inventory"));
		itemModelMesher.register(ItemClass.KroostylPickaxe, 0, new ModelResourceLocation("oodmod:KroostylPickaxe", "inventory"));
		itemModelMesher.register(ItemClass.KroostylAxe, 0, new ModelResourceLocation("oodmod:KroostylAxe", "inventory"));
		itemModelMesher.register(ItemClass.KroostylHoe, 0, new ModelResourceLocation("oodmod:KroostylHoe", "inventory"));
		itemModelMesher.register(ItemClass.KroostylSword, 0, new ModelResourceLocation("oodmod:KroostylSword", "inventory"));

		//Armour
		itemModelMesher.register(ItemClass.KroostylHelmet, 0, new ModelResourceLocation("oodmod:KroostylHelmet", "inventory"));
		itemModelMesher.register(ItemClass.KroostylChestplate, 0, new ModelResourceLocation("oodmod:KroostylChestplate", "inventory"));
		itemModelMesher.register(ItemClass.KroostylLeggings, 0, new ModelResourceLocation("oodmod:KroostylLeggings", "inventory"));
		itemModelMesher.register(ItemClass.KroostylBoots, 0, new ModelResourceLocation("oodmod:KroostylBoots", "inventory"));

		itemModelMesher.register(ItemClass.ReinforcedKroostylHelmet, 0, new ModelResourceLocation("oodmod:ReinforcedKroostylHelmet", "inventory"));
		itemModelMesher.register(ItemClass.ReinforcedKroostylChestplate, 0, new ModelResourceLocation("oodmod:ReinforcedKroostylChestplate", "inventory"));
		itemModelMesher.register(ItemClass.ReinforcedKroostylLeggings, 0, new ModelResourceLocation("oodmod:ReinforcedKroostylLeggings", "inventory"));
		itemModelMesher.register(ItemClass.ReinforcedKroostylBoots, 0, new ModelResourceLocation("oodmod:ReinforcedKroostylBoots", "inventory"));

		// Records
		itemModelMesher.register(ItemClass.RecordBangarang, 0, new ModelResourceLocation("oodmod:RecordBangarang", "inventory"));
		itemModelMesher.register(ItemClass.RecordCrispy, 0, new ModelResourceLocation("oodmod:RecordCrispy", "inventory"));
		itemModelMesher.register(ItemClass.RecordGetLucky, 0, new ModelResourceLocation("oodmod:RecordGetLucky", "inventory"));
		itemModelMesher.register(ItemClass.RecordImGonnaBe, 0, new ModelResourceLocation("oodmod:RecordImGonnaBe", "inventory"));
		itemModelMesher.register(ItemClass.RecordMamboNo5, 0, new ModelResourceLocation("oodmod:RecordMamboNo5", "inventory"));
		itemModelMesher.register(ItemClass.RecordSandstorm, 0, new ModelResourceLocation("oodmod:RecordSandstorm", "inventory"));
		itemModelMesher.register(ItemClass.RecordStayinAlive, 0, new ModelResourceLocation("oodmod:RecordStayinAlive", "inventory"));
		itemModelMesher.register(ItemClass.RecordTryItOut, 0, new ModelResourceLocation("oodmod:RecordTryItOut", "inventory"));
		itemModelMesher.register(ItemClass.RecordWatercolour, 0, new ModelResourceLocation("oodmod:RecordWatercolour", "inventory"));

	}
	

}
