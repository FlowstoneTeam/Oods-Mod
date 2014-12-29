package oodmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import oodmod.main.MainClass;

public class KroostylStairsClass extends BlockStairs {

	
	public KroostylStairsClass(Block block) {
		super(block.getDefaultState());

		setCreativeTab(MainClass.OodModTab);
		setHardness(8.0F);
		setResistance(10.0F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 3);
	}

}