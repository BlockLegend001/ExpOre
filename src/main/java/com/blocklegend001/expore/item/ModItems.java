package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExpOre.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExpOre.LOGGER.info("Registering Mod Items for " + ExpOre.MOD_ID);
    }
}
