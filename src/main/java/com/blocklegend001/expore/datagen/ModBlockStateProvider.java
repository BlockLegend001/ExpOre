package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExpOre.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        normalBlock(ModBlocks.EXP_ORE.get());
        normalBlock(ModBlocks.END_EXP_ORE.get());
        normalBlock(ModBlocks.NETHER_EXP_ORE.get());
        normalBlock(ModBlocks.DEEPSLATE_EXP_ORE.get());
    }

    private void normalBlock(Block block) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block, models().cubeAll(path, modLoc("block/" + path)));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + path)));
    }

}
