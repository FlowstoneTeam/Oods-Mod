package oodmod.block;

import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
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
		setBlockTextureName(MainClass.MODID + ":KroostylOre");
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe", 3);
		
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return ItemClass.Kroostyl;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return rand.nextInt(1) + 1;
	}
	
	private Random rand = new Random();
	@Override
	public int getExpDrop(IBlockAccess par1, int par2, int par3) {
		if (this.getItemDropped(par2, rand, par3) != Item.getItemFromBlock(this))
		{
			return 4 + rand.nextInt(8);
		}
		return 0;
	}
		
}