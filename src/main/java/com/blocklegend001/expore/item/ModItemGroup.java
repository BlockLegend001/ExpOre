package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
public class ModItemGroup {
    public static ItemGroup EXPORE = Registry.register(Registries.ITEM_GROUP, new Identifier(ExpOre.MOD_ID, "expore"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.expore"))
                    .icon(() -> new ItemStack(ModBlocks.EXP_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.EXP_ORE);
                        entries.add(ModBlocks.DEEPSLATE_EXP_ORE);
                        entries.add(ModBlocks.NETHER_EXP_ORE);
                        entries.add(ModBlocks.END_EXP_ORE);
                    }).build());

    public static void registerItemGroups() {

    }
}