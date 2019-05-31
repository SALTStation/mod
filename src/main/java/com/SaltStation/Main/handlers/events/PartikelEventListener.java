package com.SaltStation.Main.handlers.events;

import com.SaltStation.Main.partikel.CustomFire;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PartikelEventListener {

    @SubscribeEvent
    public void registerSprite(TextureStitchEvent.Pre event){
        System.out.println("stitch event pre");
        CustomFire.test2 = event.getMap().registerSprite(new ResourceLocation("mod:particles/testopesto"));
    }
}
