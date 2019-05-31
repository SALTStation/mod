package com.SaltStation.Main.blocks;

import com.SaltStation.Main.Main;
import com.SaltStation.Main.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class OnyxOre extends BlockBase {
    public OnyxOre(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
        //setLightLevel();
        //setLightOpacity();
        //setBlockUnbreakable();
        setCreativeTab(Main.CREATIVE_TAB);


    }

    /**
     * @Override public Item getItemDropped(IBlockState state, Random rant, int fortune){
     * return ModItems.ONYX_SHARD;
     * }
     * @Override public int quantityDropped(Random rand){
     * return rand.nextInt(6)+1;
     * }
     **/
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        Random rand = new Random();
        Random rand2 = new Random();
        int glueck = rand2.nextInt(100) + 1;

        drops.add(new ItemStack(ModItems.ONYX_SHARD, rand.nextInt(3) + 2 + fortune, this.damageDropped(state)));

        if (glueck > 50) {
            drops.add(new ItemStack(ModItems.ONYX_CHUNK, rand.nextInt(3) + 1 + fortune, this.damageDropped(state)));
        }
        if (glueck + (fortune * 3) > 90) {
            drops.add(new ItemStack(ModItems.ONYX_CLUSTER, rand.nextInt(3) + 1, this.damageDropped(state)));
        }


    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return 10;
    }
}