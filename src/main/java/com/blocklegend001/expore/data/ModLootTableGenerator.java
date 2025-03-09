package com.blocklegend001.expore.data;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.EXP_ORE);
        addDrop(ModBlocks.DEEPSLATE_EXP_ORE);
        addDrop(ModBlocks.NETHER_EXP_ORE);
        addDrop(ModBlocks.END_EXP_ORE);
    }
}
