package com.blocklegend001.expore.world;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> EXP_ORE_KEY = registerKey("exp_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EXP_ORE_KEY = registerKey("nether_exp_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_EXP_ORE_KEY = registerKey("end_exp_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldExpOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.EXP_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_EXP_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherExpOres =
                List.of(OreFeatureConfig.createTarget(netherrackReplaceables, ModBlocks.NETHER_EXP_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endExpOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.END_EXP_ORE.getDefaultState()));

        register(context, EXP_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldExpOres, 7));
        register(context, NETHER_EXP_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherExpOres, 7));
        register(context, END_EXP_ORE_KEY, Feature.ORE, new OreFeatureConfig(endExpOres, 7));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ExpOre.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
