package com.blocklegend001.expore;

import com.blocklegend001.expore.blocks.ModBlocks;
import com.blocklegend001.expore.items.ModCreativeModTabs;
import com.blocklegend001.expore.items.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ExpOre.MODID)
public class ExpOre
{
    public static final String MODID = "expore";

    public ExpOre(IEventBus modEventBus)
    {
        ExpOreConfig.loadConfig();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
    }
}