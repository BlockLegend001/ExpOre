package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExpOre.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DeferredHolder<Block, ? extends Block> block : ModBlocks.BLOCKS.getEntries()) {
            simpleBlock(block.get());
            itemModels().withExistingParent(block.getId().getPath(), ResourceLocation.fromNamespaceAndPath(ExpOre.MODID, "block/" + block.getId().getPath()));
        }
    }

    @Override
    public String getName() {
        return "ExpOre Blockstates";
    }
}
