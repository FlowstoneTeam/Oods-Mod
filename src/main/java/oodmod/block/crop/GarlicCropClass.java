package oodmod.block.crop;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import oodmod.item.ItemClass;

public class GarlicCropClass extends BlockCrops {

	@Override
	public int quantityDropped (Random random) {
		return 1;
	}

	@Override
	protected Item getSeed() {
		return ItemClass.GarlicSeeds;
	}

	protected Item getCrop() {
		return ItemClass.Garlic;
	}

}
