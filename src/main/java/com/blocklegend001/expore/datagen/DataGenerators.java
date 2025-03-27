package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ExpOre.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherDara(final GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ModBlockTagGenerator blockTagsProvider = new ModBlockTagGenerator(packOutput, lookupProvider, ExpOre.MODID);

        event.addProvider(blockTagsProvider);
        event.addProvider(new ModWorldGenProvider(packOutput, lookupProvider));
        event.addProvider(new ModLootTables(packOutput, lookupProvider));
        event.addProvider(new ModModelProvider(packOutput, ExpOre.MODID));
    }
}