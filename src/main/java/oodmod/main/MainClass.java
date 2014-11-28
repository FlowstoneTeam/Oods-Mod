package oodmod.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import oodmod.achievements.KroostylCraftEventClass;
import oodmod.achievements.KroostylMineEventClass;
import oodmod.block.BlockClass;
import oodmod.creativetabs.OodModTab;
import oodmod.item.ItemClass;
import oodmod.worldgen.OreGenerationClass;


@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
public class MainClass {
	
	@SidedProxy(clientSide = "oodmod.main.ClientProxy", serverSide = "oodmod.main.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(MainClass.MODID)
    public static MainClass modInstance;
	
		//Mod Info
		public static final String MODID = "oodmod";
		public static final String NAME = "Ood's Mod";
		public static final String VERSION = "${version}";
		
		//Achievements
		public static Achievement achievementKroostyl;
		public static Achievement achievementKroostylPick;
		
		//Creative Tabs
		public static CreativeTabs OodModTab = new OodModTab(CreativeTabs.getNextID(), "OodModTab");
		
		//Generation
		public static OreGenerationClass KroostylWorldGen = new OreGenerationClass();
		
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
	
		BlockClass.blockRegistry();
		ItemClass.itemRegistry();
    	CraftingClass.craftingManager();
		
	}
		
	@EventHandler
	public void Init(FMLInitializationEvent Event){
		
		// Register Models
		proxy.registerModels();
		
		//Achievements
		achievementKroostyl = new Achievement("achievement.MineKroostyl", "MineKroostyl", 0, 0, BlockClass.KroostylOre, AchievementList.diamonds).func_180788_c();
		achievementKroostylPick = new Achievement("achievement.KroostylPick", "KroostylPick", 2, 1, ItemClass.KroostylPickaxe, achievementKroostyl).func_180788_c();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Ood's Mod", new Achievement[]{achievementKroostyl, achievementKroostylPick}));
		
		FMLCommonHandler.instance().bus().register(new KroostylMineEventClass());
		FMLCommonHandler.instance().bus().register(new KroostylCraftEventClass());
		
		//World Generation
		GameRegistry.registerWorldGenerator(KroostylWorldGen, 1);
		
		//Ore Registration
		OreDictionary.registerOre("oreKroostyl", new ItemStack(BlockClass.KroostylOre));
		OreDictionary.registerOre("gemKroostyl", new ItemStack(ItemClass.Kroostyl));
		
		//Seed Dropping
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.BroccoliSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.OnionSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.BeetrootSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.CauliflowerSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.LeekSeeds), 1);
		MinecraftForge.addGrassSeed(new ItemStack(ItemClass.GarlicSeeds), 1);
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
}