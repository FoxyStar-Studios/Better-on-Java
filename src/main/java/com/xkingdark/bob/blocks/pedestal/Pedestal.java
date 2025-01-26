package com.xkingdark.bob.blocks.pedestal;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class Pedestal extends BlockWithEntity {
    public Pedestal(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<Pedestal> getCodec() {
        return createCodec(Pedestal::new);
    }

    @Override
    public PedestalBlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    protected ActionResult.Success onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        Object ItemActionResult;
        if (!(world.getBlockEntity(pos) instanceof PedestalBlockEntity blockEntity)) {
            return ActionResult.SUCCESS;
        }

        if (!player.getStackInHand(hand).isEmpty()) {
            // Check what is the first open slot and put an item from the player's hand there
            if (blockEntity.getStack(0).isEmpty()) {
                // Put the stack the player is holding into the inventory
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                // Remove the stack from the player's hand
                player.getStackInHand(hand).setCount(0);
            } else if (blockEntity.getStack(1).isEmpty()) {
                blockEntity.setStack(1, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            } else {
                // If the inventory is full we'll notify the player
                player.sendMessage(Text.literal("The inventory is full! The first slot holds "), true);
            }
        }
        return ActionResult.SUCCESS;
    }
}