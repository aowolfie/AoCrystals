package com.aowolfie.crystals.main;

import com.aowolfie.crystals.main.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = AoCrystals.MODID, name = AoCrystals.MODNAME, version = AoCrystals.VERSION)
public class AoCrystals {

    public static final String MODID = "aocrystals";
    public static final String MODNAME = "Crystals";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide="com.aowolfie.crystals.main.proxies.ClientProxy", serverSide="com.aowolfie.crystals.main.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Instance
    public static AoCrystals instance = new AoCrystals();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
}