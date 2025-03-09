package com.blocklegend001.expore.blocks;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.ExpOreConfig;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block EXP_ORE = registerBlock("exp_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(
                    ExpOreConfig.expOreMinExperience, ExpOreConfig.expOreMaxExperience),
                    Block.Settings.copy(Blocks.STONE).strength(4f).requiresTool()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpOre.MOD_ID, "exp_ore")))));

    public static final Block DEEPSLATE_EXP_ORE = registerBlock("deepslate_exp_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(
                    ExpOreConfig.deepslateExpOreMinExperience, ExpOreConfig.deepslateExpOreMaxExperience),
                    Block.Settings.copy(Blocks.COBBLED_DEEPSLATE).strength(4f).requiresTool()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpOre.MOD_ID, "deepslate_exp_ore")))));

    public static final Block NETHER_EXP_ORE = registerBlock("nether_exp_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(
                    ExpOreConfig.netherExpOreMinExperience, ExpOreConfig.netherExpOreMaxExperience),
                    Block.Settings.copy(Blocks.NETHERRACK).strength(4f).requiresTool()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpOre.MOD_ID, "nether_exp_ore")))));

    public static final Block END_EXP_ORE = registerBlock("end_exp_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(
                    ExpOreConfig.endExpOreMinExperience, ExpOreConfig.endExpOreMaxExperience),
                    Block.Settings.copy(Blocks.END_STONE).strength(4f).requiresTool()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ExpOre.MOD_ID, "end_exp_ore")))));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExpOre.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ExpOre.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExpOre.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        ExpOre.LOGGER.info("Registering ModBlocks for " + ExpOre.MOD_ID);
    }
}