package com.SaltStation.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {

    public ModTab(){
        super("DarkSun");
    }

    @Override
    public ItemStack getTabIconItem() {

        ItemStack icon = new ItemStack(ModItems.ONYX_SHARD);
        return icon;
    }
}
