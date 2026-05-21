package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContextSource;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLootTables extends LootTableProvider {

        private final List<SubProviderEntry> tables = List.of(new SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK));

    public ModLootTables(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
        {
            super(output, Set.of(), VanillaLootTableProvider.create(output, registries).getTables(), registries);
        }

        @Override
        public List<SubProviderEntry> getTables()
        {
            return this.tables;
        }

        @Override
        protected void validate(WritableRegistry<LootTable> tables, ValidationContextSource validationContext, ProblemReporter.Collector problems) {
        super.validate(tables, validationContext, problems);
    }

        private static class ModBlockLootSubProvider extends BlockLootSubProvider
        {
            protected ModBlockLootSubProvider(HolderLookup.Provider provider)
            {
                super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
            }

            @Override
            protected void generate() {
                dropWhenSilkTouch(ModBlocks.EXP_ORE.get());
                dropWhenSilkTouch(ModBlocks.DEEPSLATE_EXP_ORE.get());
                dropWhenSilkTouch(ModBlocks.NETHER_EXP_ORE.get());
                dropWhenSilkTouch(ModBlocks.END_EXP_ORE.get());
            }

            @Override
            protected Iterable<Block> getKnownBlocks() {
                return ModBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
            }
        }
    }