package oodmod.block.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SaplingBlockClass extends ItemBlock {

	public static final String[] saplings = new String[] {"Orange"};
	
	public SaplingBlockClass(Block block) {
		super(block);
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= saplings.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + saplings[i];
		
	}
	
	@Override
	public int getMetadata (int meta) {
		return meta;
	}

}