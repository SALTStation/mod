package com.SaltStation.Main.Capabilities.KnowledgeCapability;

import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import com.sun.glass.ui.View;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class KnowledgeProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IKnowledge.class)
    public static final Capability<IKnowledge> KNOWLEDGE_CAPABILITY = null;

    private IKnowledge instance = KNOWLEDGE_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == KNOWLEDGE_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == KNOWLEDGE_CAPABILITY ? KNOWLEDGE_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return KNOWLEDGE_CAPABILITY.getStorage().writeNBT(KNOWLEDGE_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        KNOWLEDGE_CAPABILITY.getStorage().readNBT(KNOWLEDGE_CAPABILITY, this.instance,null,nbt);

    }
}
