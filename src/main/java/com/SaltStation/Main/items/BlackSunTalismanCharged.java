package com.SaltStation.Main.items;

import com.SaltStation.Main.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlackSunTalismanCharged extends ItemBase {
    public BlackSunTalismanCharged(String name) {
        super(name);

        setMaxStackSize(1);

        ModItems.ITEMS.add(this);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        for (int i = 5; i > 0; i--) {
            Random rand = new Random();
            double X = (double) player.posX + (rand.nextGaussian() / 2);
            double Y = (double) player.posY + 1+rand.nextGaussian()/2;
            double Z = (double) player.posZ + (rand.nextGaussian() / 2);
            world.spawnParticle(EnumParticleTypes.FLAME, X, Y, Z, 0.0D, 0.0D, 0.0D);

        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }



    @Override
    public boolean hasEffect(ItemStack stack)
    {

            return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, @Nullable World worldIn, List< String > tooltip, ITooltipFlag
            flagIn)
    {
        tooltip.add("Contains the relit ember of the Black Sun");
    }
}
