package oodmod.block.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;

public class LeavesBlockClass extends ItemBlock {

	public static final String[] leaves = new String[] {"Orange"};

	public LeavesBlockClass(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= leaves.length) {
			i = 0;
		}

		return super.getUnlocalizedName() + "." + leaves[i];
	}

	@Override
	public int getMetadata (int meta) {
		return meta;
	}

	@Override
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
	    return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
	}

}
