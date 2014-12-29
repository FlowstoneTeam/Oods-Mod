package oodmod.block.trees;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oodmod.main.MainClass;

public class PlankClass extends Block
{
  public static final String[] planks = {"Orange"};

  public PlankClass() {
    super(Material.wood);

    setCreativeTab(MainClass.OodModTab);
    setHardness(2.0F);
    setResistance(5.0F);
    setStepSound(soundTypeWood);
	setHarvestLevel("axe", 0);

  }
  @Override
  public int damageDropped(IBlockState state) {
    return 0;
  }

  @Override
  @SideOnly(Side.CLIENT)
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
	  for (int i = 0; i < planks.length; i++) {
		  list.add(new ItemStack(item, 1, i));
	  }
  }
}