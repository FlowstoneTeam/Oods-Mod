package oodmod.item.food;

import net.minecraft.item.ItemFood;
import oodmod.main.MainClass;

public class FruitClass extends ItemFood {

	public FruitClass(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);

		setCreativeTab(MainClass.OodModTab);
	}
}
