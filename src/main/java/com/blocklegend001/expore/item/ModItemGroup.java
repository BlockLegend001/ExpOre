package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup EXPORE = FabricItemGroupBuilder.build(
            new Identifier(ExpOre.MOD_ID, "expore"), () -> new ItemStack(ModBlocks.EXP_ORE));
}
