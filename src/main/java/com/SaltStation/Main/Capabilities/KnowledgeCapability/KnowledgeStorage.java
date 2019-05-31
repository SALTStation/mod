package com.SaltStation.Main.Capabilities.KnowledgeCapability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class KnowledgeStorage implements Capability.IStorage<IKnowledge> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IKnowledge> capability, IKnowledge instance, EnumFacing side) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("current_spell", instance.getSpell());
        tag.setBoolean("guro", instance.getKnowledge("guro"));

        System.out.println("written to NBT(Fatigue): "+instance.getKnowledge("guro"));


        return tag;
    }

    @Override
    public void readNBT(Capability<IKnowledge> capability, IKnowledge instance, EnumFacing side, NBTBase nbt) {

        NBTTagCompound tag = (NBTTagCompound) nbt;
        instance.setSpell(tag.getString("current_spell"));
        instance.setKnowledge("guro",tag.getBoolean("guro"));

        System.out.println("read from NBT(Fatigue): "+instance.getKnowledge("guro"));


    }
}
