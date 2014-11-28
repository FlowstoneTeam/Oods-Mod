package oodmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oodmod.block.crop.BeetrootCropClass;
import oodmod.block.crop.BroccoliCropClass;
import oodmod.block.crop.CauliflowerCropClass;
import oodmod.block.crop.GarlicCropClass;
import oodmod.block.crop.LeekCropClass;
import oodmod.block.crop.OnionCropClass;
import oodmod.block.trees.LeavesBlockClass;
import oodmod.block.trees.LeavesClass;
import oodmod.block.trees.LogBlockClass;
import oodmod.block.trees.LogClass;
import oodmod.block.trees.PlankBlockClass;
import oodmod.block.trees.PlankClass;
import oodmod.block.trees.SaplingBlockClass;
import oodmod.block.trees.SaplingClass;

public class BlockClass {
	
    public static void blockRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    
    	//Crops
  		public static Block BroccoliCrop;
  		public static Block OnionCrop;
  		public static Block BeetrootCrop;
  		public static Block CauliflowerCrop;
  		public static Block LeekCrop;
  		public static Block GarlicCrop;
  		
  		//Veg
  		public static Block CompressedBroccoli;
  		public static Block CompressedOnion;
  		public static Block CompressedBeetroot;
  		public static Block CompressedCauliflower;
  		public static Block CompressedLeek;
  		public static Block CompressedGarlic;
  		
  		//Ores
  		public static Block KroostylOre;
  		
  		//Decorative Blocks
  		public static Block KroostylBlock;
  		public static Block KroostylBricks;
  		public static Block KroostylChiseledBricks;
  		public static Block KroostylBrickStairs;

  		public static Block Plank;
  		
  		//Trees
  		public static Block Log;
  		public static Block Leaves;
  		public static Block Sapling;
    
  		
    public static void initBlocks(){
    	
    	//Crops
  		BroccoliCrop = new BroccoliCropClass().setUnlocalizedName("BroccoliCrop");
  		OnionCrop = new OnionCropClass().setUnlocalizedName("OnionCrop");
  		BeetrootCrop = new BeetrootCropClass().setUnlocalizedName("BeetrootCrop");
  		CauliflowerCrop = new CauliflowerCropClass().setUnlocalizedName("CauliflowerCrop");
  		LeekCrop = new LeekCropClass().setUnlocalizedName("LeekCrop");
  		GarlicCrop = new GarlicCropClass().setUnlocalizedName("GarlicCrop");
  		
  		//Veg
  		CompressedBroccoli = new CompressedVegClass().setUnlocalizedName("CompressedBroccoli");//.setBlockTextureName(MainClass.MODID + ":CompressedBroccoli");
  		CompressedOnion = new CompressedVegClass().setUnlocalizedName("CompressedOnion");//.setBlockTextureName(MainClass.MODID + ":CompressedOnion");
  		CompressedBeetroot = new CompressedVegClass().setUnlocalizedName("CompressedBeetroot");//.setBlockTextureName(MainClass.MODID + ":CompressedBeetroot");
  		CompressedCauliflower = new CompressedVegClass().setUnlocalizedName("CompressedCauliflower");//.setBlockTextureName(MainClass.MODID + ":CompressedCauliflower");
  		CompressedLeek = new CompressedVegClass().setUnlocalizedName("CompressedLeek");//.setBlockTextureName(MainClass.MODID + ":CompressedLeek");
  		CompressedGarlic = new CompressedVegClass().setUnlocalizedName("CompressedGarlic");//.setBlockTextureName(MainClass.MODID + ":CompressedGarlic");
  		
  		//Ores
  		KroostylOre = new KroostylOreClass(Material.rock).setUnlocalizedName("KroostylOre");
  		
  		//Decorative Blocks
  		KroostylBlock = new KroostylBlocksClass().setUnlocalizedName("KroostylBlock");//.setBlockTextureName(MainClass.MODID + ":KroostylBlock");
  		KroostylBricks = new KroostylBlocksClass().setUnlocalizedName("KroostylBricks");//.setBlockTextureName(MainClass.MODID + ":KroostylBricks");
  		KroostylChiseledBricks = new KroostylBlocksClass().setUnlocalizedName("KroostylChiseledBricks");//.setBlockTextureName(MainClass.MODID + ":KroostylChiseledBricks");
  		KroostylBrickStairs = new KroostylStairsClass(KroostylBricks, 0).setUnlocalizedName("KroostylBrickStairs");

  		Plank = new PlankClass().setUnlocalizedName("Plank");
  		
  		//Trees
  		Log = new LogClass().setUnlocalizedName("Log");
  		Leaves = new LeavesClass().setUnlocalizedName("Leaves");
  		Sapling = new SaplingClass().setUnlocalizedName("Sapling");
    	
    }
    
    
    public static void registerBlocks(){
    	
    	//Crops
    	GameRegistry.registerBlock(BroccoliCrop, "BroccoliCrop");
    	GameRegistry.registerBlock(OnionCrop, "OnionCrop");
    	GameRegistry.registerBlock(BeetrootCrop, "BeetrootCrop");
    	GameRegistry.registerBlock(CauliflowerCrop, "CauliflowerCrop");
    	GameRegistry.registerBlock(LeekCrop, "LeekCrop");
    	GameRegistry.registerBlock(GarlicCrop, "GarlicCrop");
    			
    	//Veg
    	GameRegistry.registerBlock(CompressedBroccoli, "CompressedBroccoli");
    	GameRegistry.registerBlock(CompressedOnion, "CompressedOnion");;
    	GameRegistry.registerBlock(CompressedBeetroot, "CompressedBeetroot");
    	GameRegistry.registerBlock(CompressedCauliflower, "CompressedCauliflower");
    	GameRegistry.registerBlock(CompressedLeek, "CompressedLeek");
    	GameRegistry.registerBlock(CompressedGarlic, "CompressedGarlic");
    			
    	//Ores
    	GameRegistry.registerBlock(KroostylOre, "KroostylOre");
    			
    	//Decorative Blocks
    	GameRegistry.registerBlock(KroostylBlock, "KroostylBlock");
    	GameRegistry.registerBlock(KroostylBricks, "KroostylBricks");
    	GameRegistry.registerBlock(KroostylChiseledBricks, "KroostylChiseledBricks");
    	GameRegistry.registerBlock(KroostylBrickStairs, "KroostylBrickStairs");

    	GameRegistry.registerBlock(Plank, PlankBlockClass.class, Plank.getUnlocalizedName().substring(5));
    			
    	//Trees
    	GameRegistry.registerBlock(Log, LogBlockClass.class, Log.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(Leaves, LeavesBlockClass.class, Leaves.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(Sapling, SaplingBlockClass.class, Sapling.getUnlocalizedName().substring(5));
    	
    }
    
}