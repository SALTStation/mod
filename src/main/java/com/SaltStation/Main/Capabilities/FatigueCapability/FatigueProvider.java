package com.SaltStation.Main.Capabilities.FatigueCapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class FatigueProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IFatigue.class)
    public static final Capability<IFatigue> FATIGUE_CAPABILITY = null;

    private IFatigue instance = FATIGUE_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing){
        return capability == FATIGUE_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == FATIGUE_CAPABILITY ? FATIGUE_CAPABILITY.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT(){
        return FATIGUE_CAPABILITY.getStorage().writeNBT(FATIGUE_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        FATIGUE_CAPABILITY.getStorage().readNBT(FATIGUE_CAPABILITY, this.instance,null,nbt);
    }

}
