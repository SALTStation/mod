package com.SaltStation.Main.items;

import com.SaltStation.Main.Main;
import com.SaltStation.Main.ModItems;
import com.SaltStation.Main.misc.DarkDamage;
import com.SaltStation.Main.misc.WorldSaver;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlackSunTalisman extends ItemBase {






    public BlackSunTalisman(String name) {
        super(name);
        setMaxStackSize(1);

        ModItems.ITEMS.add(this);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt == null) {
                nbt = new NBTTagCompound();
            }
            if (!nbt.hasKey("max")) {
                nbt.setInteger("max", 100);
            }
            if(!nbt.hasKey("now")){
                nbt.setInteger("now", 1);
            }

            stack.setTagCompound(nbt);



        if(nbt.getInteger("now")>99){
            return super.onItemRightClick(world, player, hand);
        }
        else if (!player.capabilities.isCreativeMode) {
            player.hurtResistantTime = 0;
            player.attackEntityFrom(DamageSource.MAGIC, 0.001F);
            player.setHealth(Math.max(player.getHealth() - 2, 0.0001f));
            if (player.getHealth() <= 0.001f) {
                player.onDeath(DarkDamage.INSTANCE);
                player.setHealth(0);
            }
            if(nbt.getInteger("now")<99) {
                for(int i=50;i>0;i--) {
                    Random rand = new Random();
                    double X = (double) player.posX + (rand.nextGaussian()/2);
                    double Y = (double) player.posY + (rand.nextGaussian()/2);
                    double Z = (double) player.posZ + (rand.nextGaussian()/2);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, X, Y, Z, 0.0D, 0.0D, 0.0D);
                }
                nbt.setInteger("now", nbt.getInteger("now") + 1);


                return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
            }
            else{
                for(int i=80;i>0;i--) {
                    Random rand = new Random();
                    double X = (double) player.posX + (rand.nextGaussian());
                    double Y = (double) player.posY + (rand.nextGaussian());
                    double Z = (double) player.posZ + (rand.nextGaussian());
                    world.spawnParticle(EnumParticleTypes.FLAME, X, Y, Z, 0.0D, 0.0D, 0.0D);
                }

                stack.shrink(1);
                return new ActionResult<>(EnumActionResult.SUCCESS,new ItemStack(ModItems.ONYX_SHARD));



            }

        }
        else{
            nbt.setInteger("now",100);
            for(int i=80;i>0;i--) {
                Random rand = new Random();
                double X = (double) player.posX + (rand.nextGaussian());
                double Y = (double) player.posY + (rand.nextGaussian());
                double Z = (double) player.posZ + (rand.nextGaussian());
                world.spawnParticle(EnumParticleTypes.FLAME, X, Y, Z, 0.0D, 0.0D, 0.0D);
            }

            stack.shrink(1);
            return new ActionResult<>(EnumActionResult.SUCCESS,new ItemStack(ModItems.BLACKSUN_TALISMAN_CHARGED));


        }
    }




        @Override
        @SideOnly(Side.CLIENT)
        public void addInformation (ItemStack stack, @Nullable World worldIn, List < String > tooltip, ITooltipFlag
        flagIn)
        {
            tooltip.add("You can sacrefice your own energy to feed the Black Sun");
        }



}
