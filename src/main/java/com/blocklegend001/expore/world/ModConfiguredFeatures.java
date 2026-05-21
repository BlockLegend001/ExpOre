package com.blocklegend001.expore.world;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> EXP_ORE_KEY = registerKey("exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EXP_ORE_KEY = registerKey("nether_exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_EXP_ORE_KEY = registerKey("end_exp_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldExpOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.EXP_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_EXP_ORE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherExpOres =
                List.of(OreConfiguration.target(netherrackReplaceables, ModBlocks.NETHER_EXP_ORE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endExpOres =
                List.of(OreConfiguration.target(endstoneReplaceables, ModBlocks.END_EXP_ORE.defaultBlockState()));

        register(context, EXP_ORE_KEY, Feature.ORE, new OreConfiguration(overworldExpOres, 7));
        register(context, NETHER_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(netherExpOres, 7));
        register(context, END_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(endExpOres, 7));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}