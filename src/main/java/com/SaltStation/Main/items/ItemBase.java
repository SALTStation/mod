package com.SaltStation.Main.items;

import com.SaltStation.Main.Main;
import com.SaltStation.Main.ModItems;
import com.SaltStation.Main.misc.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;




public class ItemBase extends Item implements IHasModel {


    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVE_TAB);

        ModItems.ITEMS.add(this);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(this,0,"inventory");

    }
}