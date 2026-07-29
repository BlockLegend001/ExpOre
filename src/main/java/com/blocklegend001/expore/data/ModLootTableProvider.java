package com.blocklegend001.expore.data;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropWhenSilkTouch(ModBlocks.EXP_ORE);
        dropWhenSilkTouch(ModBlocks.DEEPSLATE_EXP_ORE);
        dropWhenSilkTouch(ModBlocks.NETHER_EXP_ORE);
        dropWhenSilkTouch(ModBlocks.END_EXP_ORE);
    }
}
