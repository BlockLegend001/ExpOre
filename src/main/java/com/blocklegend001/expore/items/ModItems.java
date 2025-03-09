package com.blocklegend001.expore.items;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, ExpOre.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
