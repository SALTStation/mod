package com.SaltStation.Main.items;

import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueProvider;
import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.KnowledgeProvider;
import com.SaltStation.Main.Spells.Spell;
import com.SaltStation.Main.Spells.SpellManager;
import com.SaltStation.Main.handlers.partikel.CustomEnumParticleTypes;
import com.SaltStation.Main.handlers.partikel.ParticleSpawner;
import com.SaltStation.Main.misc.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static com.SaltStation.Main.Main.INSTANCE;

public class Catalyst extends ItemBase {

    Spell spell;


    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player){

    }




    public Catalyst(String name) {
        super(name);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 10000000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        ItemStack stack = player.getHeldItem(hand);

                if(player.isSneaking()){
                    player.openGui(INSTANCE,1,world,(int)player.posX,(int)player.posY,(int)player.posZ);

                }
                else{

                    //spell = new SpellManager().manageSpells(player.getCapability(KnowledgeProvider.KNOWLEDGE_CAPABILITY,null).getSpell());
                    spell = new SpellManager().manageSpells("bett");
                    player.setActiveHand(hand);
                    return ActionResult.newResult(EnumActionResult.SUCCESS, stack);

                }




        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }


    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count)
    {


        spell.duringCast(stack,player,count);




    }


    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft){

        if(entityLiving instanceof EntityPlayer){


            spell.afterCast(stack,worldIn,entityLiving,timeLeft,this.getMaxItemUseDuration(stack));



        }
    }



    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, @Nullable World worldIn, List< String > tooltip, ITooltipFlag
            flagIn)
    {
        tooltip.add("Used to fucus ones intent");
    }



}
