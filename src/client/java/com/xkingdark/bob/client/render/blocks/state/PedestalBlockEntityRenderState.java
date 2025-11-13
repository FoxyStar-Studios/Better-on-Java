package com.xkingdark.bob.client.render.blocks.state;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.entity.state.ItemStackEntityRenderState;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntityRenderState extends BlockEntityRenderState {
    @Nullable
    public ItemStackEntityRenderState itemStackState;
    public float displayRotationDegrees;
};
