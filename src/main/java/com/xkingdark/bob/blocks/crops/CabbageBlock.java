package com.xkingdark.bob.blocks.crops;

import com.mojang.serialization.MapCodec;
import com.xkingdark.bob.items.Items;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CabbageBlock extends CropBlock {
    public static final MapCodec<CabbageBlock> CODEC = createCodec(CabbageBlock::new);
    public static final int MAX_AGE = Properties.AGE_4_MAX;
    public static final IntProperty AGE = Properties.AGE_4;
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
        Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
        Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
        Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 8.0, 14.0),
        Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0),
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public CabbageBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<CabbageBlock> getCodec() {
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
