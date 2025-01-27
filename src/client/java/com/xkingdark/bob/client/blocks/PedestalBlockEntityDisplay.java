package com.xkingdark.bob.client.blocks;

import com.xkingdark.bob.blocks.pedestal.PedestalBlockEntity;
import com.xkingdark.bob.items.Items;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.RotationAxis;

public class PedestalBlockEntityDisplay implements BlockEntityRenderer<PedestalBlockEntity> {
    public PedestalBlockEntityDisplay(BlockEntityRendererFactory.Context ctx) {
        super();
    }

    @Override
    public void render(PedestalBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (blockEntity.getWorld() == null)
            return;

        float time = blockEntity.getWorld().getTime() + tickDelta;
        matrices.push();

        // Calculate the current offset in the y value
        double offset = Math.sin((time) / 8.0) / 6.0;

        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);

        // Rotate the item
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((time) * 2));

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        itemRenderer.renderItem(
            blockEntity.getStack(0),
            ModelTransformationMode.GROUND,
            light, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0
        );

        // Mandatory call after GL calls
        matrices.pop();
    }
}