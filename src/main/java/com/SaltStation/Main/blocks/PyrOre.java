package com.SaltStation.Main.blocks;

import com.SaltStation.Main.Main;
import com.SaltStation.Main.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class PyrOre extends BlockBase {
    public PyrOre(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(Main.CREATIVE_TAB);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand= new Random();
        drops.add(new ItemStack(ModItems.IMPERFECT_PYR_CRYSTAL,rand.nextInt(3)+1+fortune,this.damageDropped(state)));
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return 10;
    }
}
