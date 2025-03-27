package com.blocklegend001.expore;

import com.blocklegend001.expore.blocks.ModBlocks;
import com.blocklegend001.expore.items.ModCreativeModTabs;
import com.blocklegend001.expore.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExpOre.MODID)
public class ExpOre {

    public static final String MODID = "expore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExpOre(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ExpOreConfig.loadConfig();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("ExpOre Loaded");
    }

}