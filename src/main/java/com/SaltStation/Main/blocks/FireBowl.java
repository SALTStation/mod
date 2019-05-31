package com.SaltStation.Main.blocks;

import com.SaltStation.Main.Main;
import com.SaltStation.Main.handlers.partikel.CustomEnumParticleTypes;
import com.SaltStation.Main.handlers.partikel.ParticleSpawner;
import com.SaltStation.Main.misc.Reference;
import com.SaltStation.Main.tileentitys.TileEntityBlackSun;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class FireBowl extends BlockBase implements ITileEntityProvider {

    public FireBowl(String name, Material material) {
        super(name, material);

        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 0);
        setLightOpacity(0);
        setCreativeTab(Main.CREATIVE_TAB);

    }
    @Deprecated
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Deprecated
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        double X = (double)pos.getX() + 0.5+(rand.nextGaussian()/6);
        double Y = (double)pos.getY() + 0.2D;
        double Z = (double)pos.getZ() + 0.5+(rand.nextGaussian()/6);


            //worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        ParticleSpawner.spawnParticle(CustomEnumParticleTypes.DARK_EMBER, X, Y, Z, 0.0D, 0.0D, 0.0D);

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return true;
    }
    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBlackSun();
    }



}
