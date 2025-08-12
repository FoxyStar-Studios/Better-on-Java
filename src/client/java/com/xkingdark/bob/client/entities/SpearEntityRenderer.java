package com.xkingdark.bob.client.entities;

import com.xkingdark.bob.client.entities.models.SpearEntityModel;
import com.xkingdark.bob.entities.SpearEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.entity.state.TridentEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class SpearEntityRenderer extends EntityRenderer<SpearEntity, TridentEntityRenderState> {
    public final Identifier texture;
    private final SpearEntityModel model;

    public SpearEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context);
        this.texture = layer.id().withPath(path -> "textures/item/spears/entity/" + path + ".png");
        this.model = new SpearEntityModel(context.getPart(layer));
    };

    public void render(TridentEntityRenderState renderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
        matrixStack.push();

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(renderState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(renderState.pitch + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
            vertexConsumerProvider, RenderLayer.getEntityCutout(this.texture), false, renderState.enchanted
        );
        this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

        matrixStack.pop();
        super.render(renderState, matrixStack, vertexConsumerProvider, light);
    };

    public TridentEntityRenderState createRenderState() {
        return new TridentEntityRenderState();
    };

    public void updateRenderState(SpearEntity entity, TridentEntityRenderState renderState, float f) {
        super.updateRenderState(entity, renderState, f);
        renderState.yaw = entity.getLerpedYaw(f);
        renderState.pitch = entity.getLerpedPitch(f);
        renderState.enchanted = entity.isEnchanted();
    };
};