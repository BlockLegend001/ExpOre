package com.blocklegend001.expore.data;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_EXP_ORE_KEY)
                .add(ModBlocks.EXP_ORE_KEY)
                .add(ModBlocks.NETHER_EXP_ORE_KEY)
                .add(ModBlocks.END_EXP_ORE_KEY);

        builder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_EXP_ORE_KEY)
                .add(ModBlocks.EXP_ORE_KEY)
                .add(ModBlocks.NETHER_EXP_ORE_KEY)
                .add(ModBlocks.END_EXP_ORE_KEY);

        builder(ConventionalBlockTags.ORES)
                .add(ModBlocks.DEEPSLATE_EXP_ORE_KEY)
                .add(ModBlocks.EXP_ORE_KEY)
                .add(ModBlocks.NETHER_EXP_ORE_KEY)
                .add(ModBlocks.END_EXP_ORE_KEY);
    }
}