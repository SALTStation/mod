package com.SaltStation.Main.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class DarkDamage extends DamageSource {

    public static final DarkDamage INSTANCE = new DarkDamage();

    public DarkDamage() {
        super("darkdamage");

        setDamageBypassesArmor();
        setDamageIsAbsolute();
    }


}
