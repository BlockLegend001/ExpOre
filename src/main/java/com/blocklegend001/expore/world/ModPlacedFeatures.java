package com.blocklegend001.expore.world;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> EXP_ORE_PLACED_KEY = registerKey("exp_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_EXP_ORE_PLACED_KEY = registerKey("nether_exp_ore_placed");
    public static final ResourceKey<PlacedFeature> END_EXP_ORE_PLACED_KEY = registerKey("end_exp_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, EXP_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXP_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(80))));

        register(context, NETHER_EXP_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_EXP_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(125))));

        register(context, END_EXP_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_EXP_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(255))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}