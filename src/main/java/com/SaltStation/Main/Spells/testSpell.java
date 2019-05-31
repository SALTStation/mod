package com.SaltStation.Main.Spells;

import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueProvider;
import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import com.SaltStation.Main.handlers.partikel.CustomEnumParticleTypes;
import com.SaltStation.Main.handlers.partikel.ParticleSpawner;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;

public class testSpell extends Spell{

    @Override
    public void duringCast(ItemStack stack, EntityLivingBase player, int count){
        Random rand = new Random();
        for(int i=0;i<20;i++) {
            double x = (double) player.posX + (rand.nextGaussian());
            double y = (double) player.posY + (rand.nextGaussian());
            double z = (double) player.posZ + (rand.nextGaussian());
            player.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0D, 0.0D, 0.0D);
        }
        player.getEntityWorld().playSound(player.posX,player.posY,player.posZ, SoundEvents.ENTITY_ITEM_BREAK,SoundCategory.PLAYERS,1,rand.nextInt(2),false);
        player.stopActiveHand();

    }
    @Override
    public void afterCast(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft,int useDurration){

        EntityPlayer player = (EntityPlayer)entityLiving;
        IFatigue fatigue = player.getCapability(FatigueProvider.FATIGUE_CAPABILITY, null);
        System.out.println(fatigue.getFatigue());
        double f = ((useDurration-timeLeft)/20)*(1-(fatigue.getFatigue()/10));

    }
}
