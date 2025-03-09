package com.blocklegend001.expore.world.feature;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ExpOre.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.EXP_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_EXP_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, ModBlocks.NETHER_EXP_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_EXP_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXP_ORE = CONFIGURED_FEATURES.register("exp_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_EXP_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_EXP_ORE = CONFIGURED_FEATURES.register("nether_exp_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_EXP_ORES.get(), 9)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> END_EXP_ORE = CONFIGURED_FEATURES.register("end_exp_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_EXP_ORES.get(), 9)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
