package com.SaltStation.Main.handlers.events;

import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueProvider;
import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FatiguePlayerHandeler {

   @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent event)
    {
        EntityPlayer player = event.getEntityPlayer();
        IFatigue fatigue = player.getCapability(FatigueProvider.FATIGUE_CAPABILITY, null);
        fatigue.remove(5);
        System.out.println("fatigue: "+(fatigue.getFatigue()));



    }
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){
        EntityPlayer player = event.getEntityPlayer();
        IFatigue fatigue = player.getCapability(FatigueProvider.FATIGUE_CAPABILITY, null);
        IFatigue oldFatigue = event.getOriginal().getCapability(FatigueProvider.FATIGUE_CAPABILITY, null);

        fatigue.setFatigue(oldFatigue.getFatigue());
        fatigue.setLimit(oldFatigue.getLimit());
        fatigue.setRegen(oldFatigue.getRegen());
    }
}
