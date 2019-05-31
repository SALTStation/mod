package com.SaltStation.Main.Capabilities.FatigueCapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class FatigueStorage implements Capability.IStorage<IFatigue> {

    @Override
    public NBTBase writeNBT(Capability<IFatigue> capability, IFatigue instance, EnumFacing side) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setDouble("fatigue", instance.getFatigue());
        tag.setDouble("fatigue_limit", instance.getLimit());
        tag.setDouble("fatigue_regen", instance.getRegen());

        System.out.println("written to NBT(Fatigue): "+instance.getFatigue());

        return tag;
    }

    @Override
    public void readNBT(Capability<IFatigue> capability, IFatigue instance, EnumFacing side, NBTBase nbt) {

        NBTTagCompound tag = (NBTTagCompound) nbt;
        instance.setFatigue(tag.getDouble("fatigue"));
        instance.setLimit(tag.getDouble("fatigue_limit"));
        instance.setRegen(tag.getDouble("fatigue_regen"));

        System.out.println("read from NBT(Fatigue): "+instance.getFatigue());

    }
}
