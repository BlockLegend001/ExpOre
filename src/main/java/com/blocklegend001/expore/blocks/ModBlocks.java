package com.blocklegend001.expore.blocks;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.ExpOreConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block EXP_ORE = registerBlock("exp_ore",
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.expOreMinExperience, ExpOreConfig.expOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final Block DEEPSLATE_EXP_ORE = registerBlock("deepslate_exp_ore",
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.deepslateExpOreMinExperience, ExpOreConfig.deepslateExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final Block NETHER_EXP_ORE = registerBlock("nether_exp_ore",
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.netherExpOreMinExperience, ExpOreConfig.netherExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final Block END_EXP_ORE = registerBlock("end_exp_ore",
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.endExpOreMinExperience, ExpOreConfig.endExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        ExpOre.LOGGER.info("Registering ModBlocks for " + ExpOre.MOD_ID);
    }
}