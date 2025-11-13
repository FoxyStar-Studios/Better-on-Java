package com.xkingdark.bob.client.render.blocks;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.pedestal.PedestalBlockEntity;
import com.xkingdark.bob.client.render.blocks.state.PedestalBlockEntityRenderState;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.block.vault.VaultClientData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.block.entity.state.VaultBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.state.ItemStackEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HeldItemContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity, PedestalBlockEntityRenderState> {
    private final ItemModelManager itemModelManager;
    private final Random random = Random.create();

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.itemModelManager = context.itemModelManager();
    };

    public PedestalBlockEntityRenderState createRenderState() {
        return new PedestalBlockEntityRenderState();
    };

    @Override
    public void updateRenderState(PedestalBlockEntity blockEntity, PedestalBlockEntityRenderState renderState, float tickDelta, Vec3d vec3d, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand) {
        World world = blockEntity.getWorld();
        if (world == null)
            return;

        ItemStack itemStack = blockEntity.getStack(0);
        if (itemStack.isEmpty())
            return;

        renderState.itemStackState = new ItemStackEntityRenderState();
        this.itemModelManager.clearAndUpdate(renderState.itemStackState.itemRenderState, itemStack, ItemDisplayContext.GROUND, blockEntity.getWorld(), null, 0);

        renderState.itemStackState.renderedAmount = ItemStackEntityRenderState.getRenderedAmount(itemStack.getCount());
        renderState.itemStackState.seed = ItemStackEntityRenderState.getSeed(itemStack);
        renderState.displayRotationDegrees = (float) ((world.getTime() + tickDelta) * 1.75);

        BlockEntityRenderer.super.updateRenderState(blockEntity, renderState, tickDelta, vec3d, crumblingOverlayCommand);
    };

    @Override
    public void render(PedestalBlockEntityRenderState renderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (renderState.itemStackState == null)
            return;

        matrixStack.push();

        matrixStack.translate(0.5, 1.15, 0.5);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(renderState.displayRotationDegrees));

        ItemEntityRenderer.renderStack(matrixStack, orderedRenderCommandQueue, renderState.lightmapCoordinates, renderState.itemStackState, this.random);

        matrixStack.pop();
    };
};