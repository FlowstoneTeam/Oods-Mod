package oodmod.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oodmod.block.BlockClass;
import oodmod.block.trees.LeavesClass;

@SideOnly(Side.CLIENT)
public class ClientEventHandler {

    // Required for changing transparency for leaves.
    @SubscribeEvent
    public void dispatchRenderLast(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc == null || mc.gameSettings == null || BlockClass.Leaves == null) 
            return;
        
        ((LeavesClass)BlockClass.Leaves).setGraphicsLevel(mc.gameSettings.fancyGraphics);
    }
}
