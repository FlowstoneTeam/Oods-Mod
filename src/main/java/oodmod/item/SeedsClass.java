package oodmod.item;

import oodmod.main.MainClass;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class SeedsClass extends ItemSeeds {

	public SeedsClass(Block A, Block B) {
		super(A, B);

		setCreativeTab(MainClass.OodModTab);
	}

}
