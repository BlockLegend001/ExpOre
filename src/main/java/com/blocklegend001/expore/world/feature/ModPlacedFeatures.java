package com.blocklegend001.expore.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> EXP_ORE_PLACED = PlacedFeatures.register("exp_ore_placed",
            ModConfiguredFeatures.EXP_ORE, modifiersWithCount(12,
                    HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> NETHER_EXP_ORE_PLACED = PlacedFeatures.register("nether_exp_ore_placed",
            ModConfiguredFeatures.NETHER_EXP_ORE, modifiersWithCount(12,
                    HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(125))));

    public static final RegistryEntry<PlacedFeature> END_EXP_ORE_PLACED = PlacedFeatures.register("end_exp_ore_placed",
            ModConfiguredFeatures.END_EXP_ORE, modifiersWithCount(12,
                    HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(255))));

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}

