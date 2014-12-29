package oodmod.block;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import oodmod.item.ItemClass;
import oodmod.main.MainClass;

public class KroostylOreClass extends BlockOre {

	public KroostylOreClass(Material material) {
		super();
		
		setCreativeTab(MainClass.OodModTab);
		setHardness(8.0F);
		setResistance(5.0F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 3);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemClass.Kroostyl;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(1) + 1;
	}
	
	private Random rand = new Random();
	@Override
	public int getExpDrop(IBlockAccess world, net.minecraft.util.BlockPos pos, int fortune) {
		IBlockState state = world.getBlockState(pos);
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			return 4 + rand.nextInt(8);
		}
		return 0;
	}
		
}