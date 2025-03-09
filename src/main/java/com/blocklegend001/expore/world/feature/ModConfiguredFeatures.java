package com.blocklegend001.expore.world.feature;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EXP_ORE_KEY = createKey("overworld_exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EXP_ORE_KEY = createKey("nether_exp_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_EXP_ORE_KEY = createKey("end_exp_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherRackReplacable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplacable = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldExpOre =
                List.of(OreConfiguration.target(stoneReplacable, ModBlocks.EXP_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepSlateReplacable, ModBlocks.DEEPSLATE_EXP_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> netherExpOre =
                List.of(OreConfiguration.target(netherRackReplacable, ModBlocks.NETHER_EXP_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endExpOre =
                List.of(OreConfiguration.target(endStoneReplacable, ModBlocks.END_EXP_ORE.get().defaultBlockState()));

        register(context, NETHER_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(netherExpOre, 7));
        register(context, END_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(endExpOre, 7));
        register(context, OVERWORLD_EXP_ORE_KEY, Feature.ORE, new OreConfiguration(overworldExpOre, 7));

    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, name));
    }

    private static  <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}

