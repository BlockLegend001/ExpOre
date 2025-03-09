package com.blocklegend001.expore.blocks;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block EXP_ORE = registerBlock("exp_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(40, 70)));

    public static final Block DEEPSLATE_EXP_ORE = registerBlock("deepslate_exp_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(40, 70)));

    public static final Block NETHER_EXP_ORE = registerBlock("nether_exp_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(40, 70)));

    public static final Block END_EXP_ORE = registerBlock("end_exp_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(40, 70)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ExpOre.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ExpOre.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void registerModBlocks() {
        ExpOre.LOGGER.info("Registering ModBlocks for " + ExpOre.MOD_ID);
    }
}