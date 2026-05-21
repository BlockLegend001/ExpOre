package com.blocklegend001.expore.item;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;
public class ModItems {

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExpOre.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ExpOre.LOGGER.info("Registering Mod Items for " + ExpOre.MOD_ID);
    }
}