package com.blocklegend001.expore.world.feature;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ExpOre.MODID);

    public static final RegistryObject<PlacedFeature> EXP_ORE_PLACED = PLACED_FEATURES.register("exp_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.EXP_ORE.getHolder().get(),
                    commonOrePlacement(12,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-63), VerticalAnchor.absolute(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_EXP_ORE_PLACED = PLACED_FEATURES.register("nether_exp_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_EXP_ORE.getHolder().get(),
                    commonOrePlacement(12,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(125)))));

    public static final RegistryObject<PlacedFeature> END_EXP_ORE_PLACED = PLACED_FEATURES.register("end_exp_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_EXP_ORE.getHolder().get(),
                    commonOrePlacement(12,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(255)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
