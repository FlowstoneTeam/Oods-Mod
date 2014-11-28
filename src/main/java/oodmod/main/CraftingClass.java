package oodmod.main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oodmod.block.BlockClass;
import oodmod.item.ItemClass;

public class CraftingClass {
	
	public static void craftingManager(){
		addCraftingRecipes();
		addSmeltingRecipes();
	}
	
	public static void addCraftingRecipes(){
		
		//Shaped Recipes
		
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedBroccoli, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Broccoli});
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedOnion, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Onion});				
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedBeetroot, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Beetroot});
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedCauliflower, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Cauliflower});
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedLeek, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Leek});
		GameRegistry.addRecipe(new ItemStack(BlockClass.CompressedGarlic, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Garlic});
				
		GameRegistry.addRecipe(new ItemStack(BlockClass.KroostylBlock, 1), new Object[] {"XXX", "XXX", "XXX", 'X', ItemClass.Kroostyl});
		GameRegistry.addRecipe(new ItemStack(BlockClass.KroostylBricks, 8), new Object[] {"YYY", "YXY", "YYY", 'X', ItemClass.Kroostyl, 'Y', Blocks.stonebrick});
		GameRegistry.addRecipe(new ItemStack(BlockClass.KroostylBricks, 64), new Object[] {"YYY", "YXY", "YYY", 'X', BlockClass.KroostylBlock, 'Y', Blocks.stonebrick});
		GameRegistry.addRecipe(new ItemStack(BlockClass.KroostylBrickStairs, 4), new Object[] {"  X", " XX", "XXX", 'X', BlockClass.KroostylBricks});
				
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylAxe, 1), new Object[] {"XX ", "XY ", " Y ", 'X', ItemClass.Kroostyl, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylPickaxe, 1), new Object[] {"XXX", " Y ", " Y ", 'X', ItemClass.Kroostyl, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylShovel, 1), new Object[] {" X ", " Y ", " Y ", 'X', ItemClass.Kroostyl, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylHoe, 1), new Object[] {"XX ", " Y ", " Y ", 'X', ItemClass.Kroostyl, 'Y', Items.stick});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylSword, 1), new Object[] {" X ", " X ", " Y ", 'X', ItemClass.Kroostyl, 'Y', Items.stick});
				
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylHelmet, 1), new Object[] {"XXX", "X X", 'X', ItemClass.Kroostyl});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylChestplate, 1), new Object[] {"X X", "XXX", "XXX", 'X', ItemClass.Kroostyl});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylLeggings, 1), new Object[] {"XXX", "X X", "X X", 'X', ItemClass.Kroostyl});
		GameRegistry.addRecipe(new ItemStack(ItemClass.KroostylBoots, 1), new Object[] {"X X", "X X", 'X', ItemClass.Kroostyl});
				
			
		//Shapeless Recipes
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Broccoli, 9), BlockClass.CompressedBroccoli);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.BroccoliSeeds, 1), ItemClass.Broccoli);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Onion, 9), BlockClass.CompressedOnion);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.OnionSeeds, 1), ItemClass.Onion);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Beetroot, 9), BlockClass.CompressedBeetroot);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.BeetrootSeeds, 1), ItemClass.Beetroot);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Cauliflower, 9), BlockClass.CompressedCauliflower);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.CauliflowerSeeds, 1), ItemClass.Cauliflower);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Leek, 9), BlockClass.CompressedLeek);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.LeekSeeds, 1), ItemClass.Leek);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Garlic, 9), BlockClass.CompressedGarlic);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.GarlicSeeds, 1), ItemClass.Garlic);
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.Kroostyl, 9), BlockClass.KroostylBlock);

		GameRegistry.addShapelessRecipe(new ItemStack(BlockClass.KroostylChiseledBricks, 1), BlockClass.KroostylBricks);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockClass.KroostylBricks, 1), BlockClass.KroostylChiseledBricks);
				
		GameRegistry.addShapelessRecipe(new ItemStack(BlockClass.Plank, 4, 0), new Object[] {new ItemStack(BlockClass.Log, 1, 0) });
				
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.ReinforcedKroostylHelmet, 1), ItemClass.KroostylHelmet, Items.nether_star);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.ReinforcedKroostylChestplate, 1), ItemClass.KroostylChestplate, Items.nether_star);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.ReinforcedKroostylLeggings, 1), ItemClass.KroostylLeggings, Items.nether_star);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClass.ReinforcedKroostylBoots, 1), ItemClass.KroostylBoots, Items.nether_star);
				
	}
	
	public static void addSmeltingRecipes(){
		
		GameRegistry.addSmelting(ItemClass.Broccoli, new ItemStack(ItemClass.BoiledBroccoli, 1), 0.00F);
		GameRegistry.addSmelting(BlockClass.KroostylOre, new ItemStack(ItemClass.Kroostyl, 1), 2.50F);
		
	}

}