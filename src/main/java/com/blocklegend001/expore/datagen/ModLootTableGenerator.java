package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDropWithSilkTouch(ModBlocks.EXP_ORE);
        addDropWithSilkTouch(ModBlocks.DEEPSLATE_EXP_ORE);
        addDropWithSilkTouch(ModBlocks.NETHER_EXP_ORE);
        addDropWithSilkTouch(ModBlocks.END_EXP_ORE);
    }
}
