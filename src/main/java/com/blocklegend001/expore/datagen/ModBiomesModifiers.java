package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.world.feature.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomesModifiers {
    protected static ResourceKey<BiomeModifier> ADD_EXP_ORE = createKey("add_exp_ore");
    protected static ResourceKey<BiomeModifier> ADD_END_EXP_ORE = createKey("add_end_exp_ore");
    protected static ResourceKey<BiomeModifier> ADD_NETHER_EXP_ORE = createKey("add_nether_exp_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                ADD_EXP_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXP_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_END_EXP_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_EXP_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_NETHER_EXP_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_NETHER),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_EXP_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, name));
    }
}
