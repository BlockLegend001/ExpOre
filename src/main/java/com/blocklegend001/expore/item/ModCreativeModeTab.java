package com.blocklegend001.expore.item;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EXP_ORE = new CreativeModeTab("expore") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.EXP_ORE.get());
        }
    };
}
