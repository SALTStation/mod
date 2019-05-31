package com.SaltStation.Main.misc;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;

public class WorldSaver extends WorldSavedData {
    private static final String DATA_NAME = Reference.MOD_ID + "_ExampleData";
    public WorldSaver(String name) {
        super(DATA_NAME);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return null;
    }
}
