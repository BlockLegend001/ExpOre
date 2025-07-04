package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModel(blockModels, ModBlocks.EXP_ORE.get());
        blockModel(blockModels, ModBlocks.END_EXP_ORE.get());
        blockModel(blockModels, ModBlocks.NETHER_EXP_ORE.get());
        blockModel(blockModels, ModBlocks.DEEPSLATE_EXP_ORE.get());
    }

    public void blockModel(BlockModelGenerators blockModels, Block block)
    {
        blockModels.createTrivialCube(block);
    }
}
