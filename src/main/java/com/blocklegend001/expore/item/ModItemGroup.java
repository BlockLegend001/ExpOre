package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup EXPORE;

    public static void registerItemGroup() {
        EXPORE = FabricItemGroup.builder(new Identifier(ExpOre.MOD_ID, "expore"))
                .displayName(Text.literal("Exp Ore"))
                .icon(() -> new ItemStack(ModBlocks.EXP_ORE)).build();
    }
}