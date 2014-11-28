package oodmod.achievements;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import oodmod.item.ItemClass;
import oodmod.main.MainClass;

public class KroostylMineEventClass {
	
	@SubscribeEvent
	public void whenKroostylMined(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ItemClass.Kroostyl))){
			e.player.addStat(MainClass.achievementKroostyl, 1);
		}
	}

}
