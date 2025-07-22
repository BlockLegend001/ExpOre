package com.blocklegend001.expore.items;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpOre.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXP_ORE = CREATIVE_MODE_TABS.register("expore",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EXP_ORE.get()))
                    .title(Component.translatable("itemGroup.expore"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.EXP_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_EXP_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_EXP_ORE.get());
                        pOutput.accept(ModBlocks.END_EXP_ORE.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
