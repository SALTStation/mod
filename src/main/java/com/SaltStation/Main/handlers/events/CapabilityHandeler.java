package com.SaltStation.Main.handlers.events;

import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueProvider;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.KnowledgeProvider;
import com.SaltStation.Main.misc.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandeler {
    public static final ResourceLocation FATIGUE_CAPABILITY = new ResourceLocation(Reference.MOD_ID,"fatigue");
    public static final ResourceLocation KNOWLEDGE_CAPABILITY = new ResourceLocation(Reference.MOD_ID,"knowledge");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(FATIGUE_CAPABILITY, new FatigueProvider());
        event.addCapability(KNOWLEDGE_CAPABILITY, new KnowledgeProvider());


    }
}
