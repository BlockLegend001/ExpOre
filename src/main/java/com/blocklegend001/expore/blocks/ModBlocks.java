package com.blocklegend001.expore.blocks;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.ExpOreConfig;
import com.blocklegend001.expore.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ExpOre.MODID);

    public static final DeferredBlock<Block> EXP_ORE = registerBlock("exp_ore",
            () -> new DropExperienceBlock(UniformInt.of(ExpOreConfig.expOreMinExperience, ExpOreConfig.expOreMaxExperience),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                            .strength(4f).requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, "exp_ore")))));

    public static final DeferredBlock<Block> DEEPSLATE_EXP_ORE = registerBlock("deepslate_exp_ore",
            () -> new DropExperienceBlock(UniformInt.of(ExpOreConfig.deepslateExpOreMinExperience, ExpOreConfig.deepslateExpOreMaxExperience),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)
                            .strength(4f).requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, "deepslate_exp_ore")))));

    public static final DeferredBlock<Block> NETHER_EXP_ORE = registerBlock("nether_exp_ore",
            () -> new DropExperienceBlock(UniformInt.of(ExpOreConfig.netherExpOreMinExperience, ExpOreConfig.netherExpOreMaxExperience),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                            .strength(4f).requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, "nether_exp_ore")))));

    public static final DeferredBlock<Block> END_EXP_ORE = registerBlock("end_exp_ore",
            () -> new DropExperienceBlock(UniformInt.of(ExpOreConfig.endExpOreMinExperience, ExpOreConfig.endExpOreMaxExperience),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                            .strength(4f).requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, "end_exp_ore")))));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}