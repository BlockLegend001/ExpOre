package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlocks.EXP_ORE.get(), createSilkTouchOnlyTable(ModBlocks.EXP_ORE.get()));
        add(ModBlocks.END_EXP_ORE.get(), createSilkTouchOnlyTable(ModBlocks.END_EXP_ORE.get()));
        add(ModBlocks.NETHER_EXP_ORE.get(), createSilkTouchOnlyTable(ModBlocks.NETHER_EXP_ORE.get()));
        add(ModBlocks.DEEPSLATE_EXP_ORE.get(), createSilkTouchOnlyTable(ModBlocks.DEEPSLATE_EXP_ORE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(ExpOre.MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
