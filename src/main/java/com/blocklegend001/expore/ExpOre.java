package com.blocklegend001.expore;

import com.blocklegend001.expore.blocks.ModBlocks;
import com.blocklegend001.expore.items.ModCreativeModTabs;
import com.blocklegend001.expore.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExpOre.MODID)
public class ExpOre {

    public static final String MODID = "expore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExpOre(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();
        ExpOreConfig.loadConfig();
        ModItems.register(modBusGroup);
        ModBlocks.register(modBusGroup);
        ModCreativeModTabs.register(modBusGroup);
        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("ExpOre Loaded");
    }
}