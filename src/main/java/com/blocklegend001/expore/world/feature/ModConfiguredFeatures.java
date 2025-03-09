package com.blocklegend001.expore.world.feature;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_EXP_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.EXP_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_EXP_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> NETHER_EXP_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocks.NETHER_EXP_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> END_EXP_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.END_EXP_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> EXP_ORE =
            ConfiguredFeatures.register("exp_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_EXP_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_EXP_ORE =
            ConfiguredFeatures.register("nether_exp_ore", Feature.ORE, new OreFeatureConfig(NETHER_EXP_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_EXP_ORE =
            ConfiguredFeatures.register("end_exp_ore", Feature.ORE, new OreFeatureConfig(END_EXP_ORES, 9));

    public static void registerConfiguredFeatures() {
        ExpOre.LOGGER.debug("Registering the ModConfiguredFeatures for " + ExpOre.MOD_ID);
    }
}
