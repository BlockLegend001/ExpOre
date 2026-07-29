package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId)
    {
        super(packOutput, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.EXP_ORE.getKey(),
                        ModBlocks.END_EXP_ORE.getKey(),
                        ModBlocks.NETHER_EXP_ORE.getKey(),
                        ModBlocks.DEEPSLATE_EXP_ORE.getKey());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EXP_ORE.getKey(),
                        ModBlocks.END_EXP_ORE.getKey(),
                        ModBlocks.NETHER_EXP_ORE.getKey(),
                        ModBlocks.DEEPSLATE_EXP_ORE.getKey());

        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.EXP_ORE.getKey(),
                        ModBlocks.END_EXP_ORE.getKey(),
                        ModBlocks.NETHER_EXP_ORE.getKey(),
                        ModBlocks.DEEPSLATE_EXP_ORE.getKey());
    }
}