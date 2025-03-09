package com.blocklegend001.expore.world;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> EXP_ORE_PLACED_KEY = registerKey("exp_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_EXP_ORE_PLACED_KEY = registerKey("nether_exp_ore_placed");
    public static final RegistryKey<PlacedFeature> END_EXP_ORE_PLACED_KEY = registerKey("end_exp_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, EXP_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.EXP_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(80))));

        register(context, NETHER_EXP_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_EXP_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(125))));

        register(context, END_EXP_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_EXP_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(255))));
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ExpOre.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
