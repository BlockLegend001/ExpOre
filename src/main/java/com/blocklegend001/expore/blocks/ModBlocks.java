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

    public static final ResourceKey<Block> EXP_ORE_KEY = blockKey("exp_ore");
    public static final Block EXP_ORE = registerBlock(EXP_ORE_KEY,
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.expOreMinExperience, ExpOreConfig.expOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> DEEPSLATE_EXP_ORE_KEY = blockKey("deepslate_exp_ore");
    public static final Block DEEPSLATE_EXP_ORE = registerBlock(DEEPSLATE_EXP_ORE_KEY,
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.deepslateExpOreMinExperience, ExpOreConfig.deepslateExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> NETHER_EXP_ORE_KEY = blockKey("nether_exp_ore");
    public static final Block NETHER_EXP_ORE = registerBlock(NETHER_EXP_ORE_KEY,
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.netherExpOreMinExperience, ExpOreConfig.netherExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> END_EXP_ORE_KEY = blockKey("end_exp_ore");
    public static final Block END_EXP_ORE = registerBlock(END_EXP_ORE_KEY,
            properties -> new DropExperienceBlock(UniformInt.of(
                    ExpOreConfig.endExpOreMinExperience, ExpOreConfig.endExpOreMaxExperience),
                    properties.strength(4f).requiresCorrectToolForDrops()));


    private static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name));
    }

    private static Block registerBlock(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(key));
        registerBlockItem(key, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, key, toRegister);
    }

    private static void registerBlockItem(ResourceKey<Block> blockKey, Block block) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());
        Registry.register(BuiltInRegistries.ITEM, itemKey,
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
    }

    public static void registerModBlocks() {
        ExpOre.LOGGER.info("Registering ModBlocks for " + ExpOre.MOD_ID);
    }
}