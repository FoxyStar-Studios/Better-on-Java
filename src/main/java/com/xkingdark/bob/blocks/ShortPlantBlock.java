package com.xkingdark.bob.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ShortPlantBlock extends PlantBlock {
    public ShortPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ShortPlantBlock> getCodec() {
        return createCodec(ShortPlantBlock::new);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
    }
}
