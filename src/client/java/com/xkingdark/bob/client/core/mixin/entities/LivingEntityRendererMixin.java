package com.xkingdark.bob.client.core.mixin.entities;

import com.google.common.collect.Lists;
import com.xkingdark.bob.Main;
import com.xkingdark.bob.core.accessor.EnchantedEntityAccessor;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.CowEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static net.minecraft.client.render.entity.LivingEntityRenderer.getOverlay;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin <T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends EntityRenderer<T, S> implements FeatureRendererContext<S, M> {
    @Shadow protected M model;
    @Shadow protected final List<FeatureRenderer<S, M>> features = Lists.newArrayList();
    @Unique boolean isEnchanted = false;

    protected LivingEntityRendererMixin(EntityRendererFactory.Context context) {
        super(context);
    };

    @Shadow
    public M getModel() {
        return null;
    };

    @Inject(
        method = "updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V",
        at = @At("TAIL")
    )
    public void BoB$updateRenderState(T livingEntity, S livingEntityRenderState, float f, CallbackInfo ci) {
        if (livingEntity instanceof EnchantedEntityAccessor accessor) {
            isEnchanted = accessor.BoB$isEnchanted();
        };
    };

    @Inject(
        method = "render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void BoB$render(S livingEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState, CallbackInfo ci) {
        matrixStack.push();

        if (livingEntityRenderState.isInPose(EntityPose.SLEEPING)) {
            Direction direction = livingEntityRenderState.sleepingDirection;
            if (direction != null) {
                float f = livingEntityRenderState.standingEyeHeight - 0.1F;
                matrixStack.translate((float)(-direction.getOffsetX()) * f, 0.0F, (float)(-direction.getOffsetZ()) * f);
            };
        };

        float g = livingEntityRenderState.baseScale;
        matrixStack.scale(g, g, g);

        this.setupTransforms(livingEntityRenderState, matrixStack, livingEntityRenderState.bodyYaw, g);
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        this.scale(livingEntityRenderState, matrixStack);
        matrixStack.translate(0.0F, -1.501F, 0.0F);
        this.model.setAngles(livingEntityRenderState);

        boolean bl = this.isVisible(livingEntityRenderState);
        boolean bl2 = !bl && !livingEntityRenderState.invisibleToPlayer;
        RenderLayer renderLayer = this.getRenderLayer(livingEntityRenderState, bl, bl2, livingEntityRenderState.hasOutline());
        if (renderLayer != null) {
            List<RenderLayer> list = ItemRenderer.getGlintRenderLayers(this.model.getLayer(getTexture(livingEntityRenderState)), false, isEnchanted);
            for (int i = 0; i < list.size(); ++i) {
                orderedRenderCommandQueue.getBatchingQueue(i).submitModel(this.model, livingEntityRenderState, matrixStack, list.get(i), livingEntityRenderState.light, OverlayTexture.DEFAULT_UV, -1, null, livingEntityRenderState.outlineColor, null);
            };

            //VertexConsumer vertexConsumer;
            //if (this.isEnchanted) {
            //    vertexConsumer = ItemRenderer.getItemGlintConsumer(
            //        vertexConsumerProvider, RenderLayer.getEntityCutoutNoCull(getTexture(livingEntityRenderState)), false, isEnchanted
            //    );
            //}
            //else {
            //    vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);
            //};

            int i = getOverlay(livingEntityRenderState, this.getAnimationCounter(livingEntityRenderState));
            int j = bl2 ? 654311423 : -1;
            int k = ColorHelper.mix(j, this.getMixColor(livingEntityRenderState));
            orderedRenderCommandQueue.submitModel(this.model, livingEntityRenderState, matrixStack, renderLayer, livingEntityRenderState.light, i, k, null, livingEntityRenderState.outlineColor, null);
        };

        if (this.shouldRenderFeatures(livingEntityRenderState)) {
            for(FeatureRenderer<S, M> featureRenderer : this.features) {
                featureRenderer.render(
                    matrixStack, orderedRenderCommandQueue, livingEntityRenderState.light, livingEntityRenderState,
                    livingEntityRenderState.relativeHeadYaw, livingEntityRenderState.pitch
                );
            };
        };

        matrixStack.pop();
        super.render(livingEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);

        ci.cancel();
    };

    @Shadow
    protected boolean isVisible(S state) {
        return !state.invisible;
    };

    @Shadow
    protected int getMixColor(S state) {
        return -1;
    };

    @Shadow
    public Identifier getTexture(S state) {
        return null;
    };

    @Shadow
    protected RenderLayer getRenderLayer(S state, boolean showBody, boolean translucent, boolean showOutline) {
        return null;
    };

    @Shadow
    protected float getAnimationCounter(S state) {
        return 0.0F;
    };

    @Shadow
    protected void scale(S state, MatrixStack matrices) {};

    @Shadow
    protected boolean shouldRenderFeatures(S state) {
        return true;
    };

    @Override
    public S createRenderState() {
        return null;
    };

    @Shadow
    protected void setupTransforms(S state, MatrixStack matrices, float bodyYaw, float baseHeight) {};
};