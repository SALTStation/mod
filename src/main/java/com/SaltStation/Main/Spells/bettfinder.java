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
import net.minecraft.world.World;

import java.util.Random;

public class bettfinder extends Spell {

    public void duringCast(ItemStack stack, EntityLivingBase player, int count){

    }
    public void afterCast(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft, int useDurration){

        EntityPlayer player = (EntityPlayer)entityLiving;
        IFatigue fatigue = player.getCapability(FatigueProvider.FATIGUE_CAPABILITY, null);
        double f = ((useDurration-timeLeft)/10)*(1-(fatigue.getFatigue()/10));
        if(f>10){
            if(!worldIn.isRemote) {
                int xb = player.getBedLocation().getX();
                int yb = player.getBedLocation().getY();
                int zb = player.getBedLocation().getZ();
                double x = player.posX;
                double y = player.posY;
                double z = player.posZ+1;
                for (int i = 0; i < 100; i++) {

                    double xv= xb-x;
                    double yv= yb-y;
                    double zv= zb-z;

                    double xm = x + i * xv;
                    double ym = y + i * yv;
                    double zm = z + i * zv;
                    System.out.println("leel "+y+" laal "+yb+" lool "+ym);

                    ParticleSpawner.spawnParticle(CustomEnumParticleTypes.DARK_EMBER, xm, ym, zm,0.0, 0.0 ,0.0);

                }

            }

        }
        else{
            Random rand = new Random();
            for(int i=0;i<20;i++) {
                double x = (double) player.posX + (rand.nextGaussian());
                double y = (double) player.posY + (rand.nextGaussian());
                double z = (double) player.posZ + (rand.nextGaussian());
                player.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0D, 0.0D, 0.0D);
            }
            player.getEntityWorld().playSound(player.posX,player.posY,player.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS,1,rand.nextInt(2),false);

        }

    }
}
