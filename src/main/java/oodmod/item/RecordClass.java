package oodmod.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oodmod.main.MainClass;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class RecordClass extends ItemRecord
{
	private static final Map<String,RecordClass> records = new HashMap<String,RecordClass>();

	public final String recordName;

	public RecordClass(String recordName)
	{
		super(recordName);
		
		this.recordName = recordName;
		this.maxStackSize = 1;
		
		this.setCreativeTab(MainClass.OodModTab);
		
		records.put(recordName, this);
	}

	/*@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(MainClass.MODID + ":Record" + recordName);
	}*/

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == Blocks.jukebox && !((Boolean)iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue())
        {
            if (worldIn.isRemote)
            {
                return true;
            }
            else
            {
                ((BlockJukebox)Blocks.jukebox).insertRecord(worldIn, pos, iblockstate, stack);
                worldIn.playAuxSFXAtEntity((EntityPlayer)null, 1005, pos, Item.getIdFromItem(this));
                --stack.stackSize;
                return true;
            }
        }
        else
        {
            return false;
        }
    }


	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(this.getRecordNameLocal());
	}

	@Override
	public String getRecordNameLocal()
	{
		return StatCollector.translateToLocal(this.getUnlocalizedName() + ".desc");
	}

	@Override
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return EnumRarity.RARE;
	}

	public static RecordClass getRecord(String par0Str)
	{
		return (RecordClass)records.get(par0Str);
	}
	
    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(MainClass.MODID + ":" + name);
    }
}