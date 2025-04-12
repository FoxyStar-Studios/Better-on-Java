package com.xkingdark.bob.client.blocks;

import com.xkingdark.bob.blocks.pedestal.PedestalBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PedestalBlockEntityDisplay implements BlockEntityRenderer<PedestalBlockEntity> {
    public PedestalBlockEntityDisplay(BlockEntityRendererFactory.Context context) {
        super();
    }

    @Override
    public void render(
        PedestalBlockEntity blockEntity,
        float tickDelta, MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light, int overlay,
        Vec3d cameraPos
    ) {
        World world = blockEntity.getWorld();
        if (world == null)
            return;

        ItemStack itemStack = blockEntity.getStack(0);
        if (itemStack.isEmpty())
            return;

        float time = world.getTime() + tickDelta;
        matrices.push();

        // Calculate the current offset in the y value
        //double offset = Math.sin((time) / 8.0) / 6.0;

        // Move the item
        matrices.translate(0.5, 1.15, 0.5);

        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)(time * 1.75)));

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        itemRenderer.renderItem(
            itemStack, ItemDisplayContext.GROUND,
            light, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0
        );

        // Mandatory call after GL calls
        matrices.pop();
    }
}