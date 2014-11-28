package oodmod.block.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class PlankBlockClass extends ItemBlock {

	public static final String[] planks = new String[] {"Orange"};
	
	public PlankBlockClass(Block block) {
		super(block);
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= planks.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + planks[i];
		
	}
	
	@Override
	public int getMetadata (int meta) {
		return meta;
	}

}
