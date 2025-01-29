package com.xkingdark.bob.blocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class TallEyeblossomBlock extends TallPlantBlock {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

    public TallEyeblossomBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(OPEN, false).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OPEN, HALF);
    }


    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf half = state.get(HALF);
        BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState otherState = world.getBlockState(otherPos);
        if (otherState.isOf(this) && otherState.get(HALF) != half) {
            world.setBlockState(otherPos, net.minecraft.block.Blocks.AIR.getDefaultState(), 35);
        }
        super.onBreak(world, pos, state, player);
        return otherState;
    }


    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < 1 && world.getTimeOfDay() % 24000 >= 13000) { // Only change state at night
            setOpen(world, pos, true); // Set open to true during night
        } else {
            setOpen(world, pos, false); // Set open to true during night
        }
        super.randomTick(state, world, pos, random);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        randomTick(state, world, pos, random);

        super.scheduledTick(state, world, pos, random);
    }

    public void setOpen(World world, BlockPos pos, boolean open) {
        BlockState state = world.getBlockState(pos);
        if (state.isOf(this)) {
            world.setBlockState(pos, state.with(OPEN, open));
            BlockPos otherPos = state.get(HALF) == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
            BlockState otherState = world.getBlockState(otherPos);
            if (otherState.isOf(this)) {
                world.setBlockState(otherPos, otherState.with(OPEN, open));
            }
        }
    }
}
