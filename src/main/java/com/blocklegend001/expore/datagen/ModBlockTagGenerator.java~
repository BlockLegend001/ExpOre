package com.blocklegend001.expore.datagen;

import com.blocklegend001.expore.ExpOre;
import com.blocklegend001.expore.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExpOre.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.EXP_ORE.get(),
                        ModBlocks.END_EXP_ORE.get(),
                        ModBlocks.NETHER_EXP_ORE.get(),
                        ModBlocks.DEEPSLATE_EXP_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EXP_ORE.get(),
                        ModBlocks.END_EXP_ORE.get(),
                        ModBlocks.NETHER_EXP_ORE.get(),
                        ModBlocks.DEEPSLATE_EXP_ORE.get());
    }
}
