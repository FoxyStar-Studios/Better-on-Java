package com.xkingdark.bob.blocks;

import com.xkingdark.bob.network.packets.WaystonePacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.Direction;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

import org.jetbrains.annotations.Nullable;

public class WaystoneBlock extends Block implements Waterloggable {
    private static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    private static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public WaystoneBlock(AbstractBlock.Settings settings) {
        super(settings);

        BlockState state = this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(HALF, DoubleBlockHalf.LOWER)
                .with(WATERLOGGED, false);
        this.setDefaultState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        FluidState fluidState = world.getFluidState(pos.up());
        BlockState blockState = state
                .with(HALF, DoubleBlockHalf.UPPER)
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        world.setBlockState(pos.up(), blockState);
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        BlockPos blockPos = doubleBlockHalf == DoubleBlockHalf.UPPER ? pos.down() : pos;
        BlockState blockState = world.getBlockState(blockPos);

        if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
            BlockPos pos2 = doubleBlockHalf == DoubleBlockHalf.UPPER ? pos.down() : pos.up();
            BlockState state2 = world.getBlockState(pos2).getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
            world.setBlockState(pos2, state2);

            return super.onBreak(world, blockPos, blockState, player);
        }
        
        return super.onBreak(world, pos, state, player);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState floor = world.getBlockState(blockPos);
        return floor.isOpaqueFullCube();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            ServerPlayNetworking.send((ServerPlayerEntity) player, new WaystonePacket(true, pos));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        double maxY = doubleBlockHalf == DoubleBlockHalf.LOWER ? 16 : 14;
        return Block.createCuboidShape(1f, 0f, 1f, 15f, maxY, 15f);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockPos = context.getBlockPos();
        BlockPos up = blockPos.up();
        World world = context.getWorld();
        if (up.getY() >= world.getTopYInclusive())
            return null;

        FluidState fluidState = world.getFluidState(blockPos);
        if (world.getBlockState(up).canReplace(context)) {
            return this.getDefaultState()
                    .with(FACING, context.getHorizontalPlayerFacing().getOpposite())
                    .with(HALF, DoubleBlockHalf.LOWER)
                    .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        }

        return null;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}