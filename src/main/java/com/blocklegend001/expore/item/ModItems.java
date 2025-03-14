package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExpOre.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
