package com.SaltStation.Main.handlers.events;

import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueProvider;
import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.IKnowledge;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.KnowledgeProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KnowledgePlayerHandeler {

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event){
        EntityPlayer player = event.getEntityPlayer();
        IKnowledge knowledge = player.getCapability(KnowledgeProvider.KNOWLEDGE_CAPABILITY, null);
        IKnowledge oldKnowledge = event.getOriginal().getCapability(KnowledgeProvider.KNOWLEDGE_CAPABILITY, null);

        knowledge.setSpell(oldKnowledge.getSpell());
        knowledge.setKnowledge("guro",oldKnowledge.getKnowledge("guro"));
    }
}
