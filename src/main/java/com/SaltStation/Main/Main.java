package com.SaltStation.Main;


import com.SaltStation.Main.Capabilities.FatigueCapability.Fatigue;
import com.SaltStation.Main.Capabilities.FatigueCapability.FatigueStorage;
import com.SaltStation.Main.Capabilities.FatigueCapability.IFatigue;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.IKnowledge;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.Knowledge;
import com.SaltStation.Main.Capabilities.KnowledgeCapability.KnowledgeStorage;
import com.SaltStation.Main.handlers.GuiHandeler;
import com.SaltStation.Main.handlers.events.CapabilityHandeler;
import com.SaltStation.Main.handlers.events.FatiguePlayerHandeler;
import com.SaltStation.Main.handlers.events.KnowledgePlayerHandeler;
import com.SaltStation.Main.handlers.events.PartikelEventListener;
import com.SaltStation.Main.proxy.CommonProxy;
import com.SaltStation.Main.misc.Reference;
import com.SaltStation.Main.tileentitys.TileEntityBlackSun;
import com.SaltStation.Main.world.ModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    int GuiID =1;

    @Mod.Instance
    public static Main INSTANCE;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs CREATIVE_TAB = new ModTab();

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event){

        CapabilityManager.INSTANCE.register(IFatigue.class,new FatigueStorage(),()->new Fatigue());
        CapabilityManager.INSTANCE.register(IKnowledge.class,new KnowledgeStorage(),()->new Knowledge());
        MinecraftForge.EVENT_BUS.register(new PartikelEventListener());
        MinecraftForge.EVENT_BUS.register(new FatiguePlayerHandeler());
        MinecraftForge.EVENT_BUS.register(new KnowledgePlayerHandeler());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandeler());

        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE , new GuiHandeler());


        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){




        //Crafting


        GameRegistry.registerTileEntity(TileEntityBlackSun.class, Reference.MOD_ID+"TileEntityBlackSun");

    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event){

    }

}