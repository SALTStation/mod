package com.SaltStation.Main.handlers.partikel;

import com.SaltStation.Main.partikel.CustomFire;
import com.SaltStation.Main.partikel.ParticlePetal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;


public class ParticleSpawner
{
    private static Minecraft mc = Minecraft.getMinecraft();

    public static Particle spawnParticle(CustomEnumParticleTypes type, double X, double Y, double Z, double par8, double par10, double par12)
    {
        if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null)
        {
            int var14 = mc.gameSettings.particleSetting;

            if (var14 == 1 && mc.world.rand.nextInt(3) == 0)
            {
                var14 = 2;
            }

            double var15 = mc.getRenderViewEntity().posX - X;
            double var17 = mc.getRenderViewEntity().posY - Y;
            double var19 = mc.getRenderViewEntity().posZ - Z;
            Particle var21 = null;
            double var22 = 16.0D;

            if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22)
            {
                return null;
            }
            else if (var14 > 1)
            {
                return null;
            }
            else
            {
                if (type == CustomEnumParticleTypes.FLOWER)
                {
                    var21 = new ParticlePetal(mc.world, X, Y, Z, par8, par10, par12);
                }
                else if(type == CustomEnumParticleTypes.DARK_EMBER){

                    var21 = new CustomFire(mc.world, X, Y, Z, par8, par10, par12);
                }

                mc.effectRenderer.addEffect(var21);
                return var21;
            }
        }
        return null;
    }
}