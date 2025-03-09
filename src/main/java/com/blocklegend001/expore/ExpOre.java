package com.blocklegend001.expore;

import com.blocklegend001.expore.blocks.ModBlocks;
import com.blocklegend001.expore.item.ModItemGroup;
import com.blocklegend001.expore.item.ModItems;
import com.blocklegend001.expore.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpOre implements ModInitializer {
    public static final String MOD_ID = "expore";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroup();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModWorldGeneration.generateModWorldGen();
    }
}
