package com.blocklegend001.expore.world.feature;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EXP_ORE_KEY = registerKey("overworld_exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EXP_ORE_KEY = registerKey("nether_exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_EXP_ORE_KEY = registerKey("end_exp_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.EXP_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_EXP_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_EXP_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_EXP_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_EXP_ORE.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, OVERWORLD_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_EXP_ORES.get(), 9));
        register(context, NETHER_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_EXP_ORES.get(), 9));
        register(context, END_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(END_EXP_ORES.get(), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey (String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ExpOre.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>void register
            (BootstapContext < ConfiguredFeature < ?, ?>>context,
             ResourceKey < ConfiguredFeature < ?, ?>>key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

