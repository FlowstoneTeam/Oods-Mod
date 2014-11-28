package oodmod.block.trees;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import oodmod.block.BlockClass;
import oodmod.main.MainClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LeavesClass extends BlockLeaves {

	public static final String[][] leaftypes = new String[][] {{"OrangeLeaves", "OrangeLeavesOpaque"}};
	public static final String[] leaves = new String[] {"Orange"};
	
	@Override
	  public Item getItemDropped(int par1, Random random, int par2)
      {
        return Item.getItemFromBlock(BlockClass.Sapling);
      }

	@Override
	  public int damageDropped(int i)
	  {
		  return super.damageDropped(i) + 0;
	  }

	@Override
	  public int getDamageValue(World paramWorld, int paramInt1, int paramInt2, int paramInt3)
	  {
	    return paramWorld.getBlockMetadata(paramInt1, paramInt2, paramInt3) & 0x3;
	  }

	@Override
	  @SideOnly(Side.CLIENT)
	  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		  
		  for (int i = 0; i < leaves.length; i++) {
				list.add(new ItemStack(item, 1, i));
		  }
	  }

	@Override
	  @SideOnly(Side.CLIENT)
	  public void registerBlockIcons(IIconRegister iconRegister) {
	    for (int i = 0; i < leaftypes.length; i++) {
	      this.field_150129_M[i] = new IIcon[leaftypes[i].length];

	      for (int j = 0; j < leaftypes[i].length; j++)
	        this.field_150129_M[i][j] = iconRegister.registerIcon(MainClass.MODID + ":" + leaftypes[i][j]);
	    }

		setCreativeTab(MainClass.OodModTab);
	    
	  }
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
	}

	@Override
	public String[] func_150125_e() {
		return leaves;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
	}
	
}
