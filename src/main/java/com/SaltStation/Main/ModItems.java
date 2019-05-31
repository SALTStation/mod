package com.SaltStation.Main;

import java.util.List;
import java.util.ArrayList;

import com.SaltStation.Main.items.BlackSunTalisman;
import com.SaltStation.Main.items.BlackSunTalismanCharged;
import com.SaltStation.Main.items.Catalyst;
import com.SaltStation.Main.items.ItemBase;
import net.minecraft.item.Item;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item ONYX_SHARD = new ItemBase("onyx_shard");
    public static final Item ONYX_CHUNK = new ItemBase("onyx_chunk");
    public static final Item ONYX_CLUSTER = new ItemBase("onyx_cluster");
    public static final Item BLACKSUN_TALISMAN = new BlackSunTalisman("blacksun_talisman");
    public static final Item BLACKSUN_TALISMAN_CHARGED = new BlackSunTalismanCharged("blacksun_talisman_charged");
    public static final Item IMPERFECT_AITHER_CRYSTAL = new ItemBase("imperfect_aither_crystal");
    public static final Item IMPERFECT_AER_CRYSTAL = new ItemBase("imperfect_aer_crystal");
    public static final Item IMPERFECT_PYR_CRYSTAL = new ItemBase("imperfect_pyr_crystal");
    public static final Item IMPERFECT_GE_CRYSTAL = new ItemBase("imperfect_ge_crystal");
    public static final Item IMPERFECT_HYDOR_CRYSTAL = new ItemBase("imperfect_hydor_crystal");
    public static final Item CATALYST = new Catalyst("catalyst");




}