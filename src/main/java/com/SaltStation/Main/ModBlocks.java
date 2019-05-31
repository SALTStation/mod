package com.SaltStation.Main;

import com.SaltStation.Main.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block ONYX_ORE_BLOCK = new OnyxOre("onyx_ore_block",Material.ROCK);
    public static final Block FIRE_BOWL_BLOCK = new FireBowl("fire_bowl_block",Material.ROCK);
    public static final Block AER_ORE_BLOCK = new AerOre("aer_ore_block",Material.ROCK);
    public static final Block AITHER_ORE_BLOCK = new AitherOre("aither_ore_block",Material.ROCK);
    public static final Block GE_ORE_BLOCK = new GeOre("ge_ore_block",Material.ROCK);
    public static final Block PYR_ORE_BLOCK = new PyrOre("pyr_ore_block",Material.ROCK);
    public static final Block HYDOR_ORE_BLOCK = new HydorOre("hydor_ore_block",Material.ROCK);
}
