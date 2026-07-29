package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {
    public static final CreativeModeTab EXPORE = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, 
            Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, "expore"),
        FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EXP_ORE))
                .title(Component.translatable("itemgroup.expore"))
                .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.EXP_ORE);
                        output.accept(ModBlocks.DEEPSLATE_EXP_ORE);
                        output.accept(ModBlocks.NETHER_EXP_ORE);
                        output.accept(ModBlocks.END_EXP_ORE);
                    }).build());

    public static void registerItemGroups() {

    }
}