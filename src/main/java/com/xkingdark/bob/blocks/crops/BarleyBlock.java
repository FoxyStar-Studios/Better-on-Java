package com.xkingdark.bob.blocks.crops;

import com.mojang.serialization.MapCodec;
import com.xkingdark.bob.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BarleyBlock extends CropBlock {
    public static final MapCodec<BarleyBlock> CODEC = createCodec(BarleyBlock::new);
    public static final int MAX_AGE = Properties.AGE_3_MAX;
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public BarleyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<BarleyBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return Items.CABBAGE_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
