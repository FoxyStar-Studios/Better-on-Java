package com.xkingdark.bob.client.core.mixin.entities;

import com.xkingdark.bob.core.accessor.CowEntityAccessor;
import net.minecraft.client.model.BabyModelPair;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.CowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.state.CowEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.CowVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CowEntityRenderer.class)
public class CowEntityRendererMixin extends MobEntityRenderer<CowEntity, CowEntityRenderState, CowEntityModel> {
    @Shadow @Final
    private Map<CowVariant.Model, BabyModelPair<CowEntityModel>> babyModelPairMap;

    @Unique
    boolean isEnchanted = false;

    public CowEntityRendererMixin(EntityRendererFactory.Context context, CowEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }
    /*@Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo info) {
        //isEnchanted = Math.round(Math.random()) == 1;
    }*/

    @Inject(
        method = "updateRenderState(Lnet/minecraft/entity/passive/CowEntity;Lnet/minecraft/client/render/entity/state/CowEntityRenderState;F)V",
        at = @At("TAIL")
    )
    public void updateRenderState(CowEntity entity, CowEntityRenderState renderState, float f, CallbackInfo ci) {
        if (entity instanceof CowEntityAccessor accessor) {
            isEnchanted = accessor.bob$isEnchanted();
        }
    }

    @Inject(
        method = "render(Lnet/minecraft/client/render/entity/state/CowEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void bob$render(CowEntityRenderState renderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (renderState.variant != null) {
            this.model = this.babyModelPairMap.get(renderState.variant.modelAndTexture().model()).get(renderState.baby);
            matrixStack.push();

            float g = renderState.baseScale;
            matrixStack.scale(g, g, g);

            this.setupTransforms(renderState, matrixStack, renderState.bodyYaw, g);
            matrixStack.scale(-1.0F, -1.0F, 1.0F);
            this.scale(renderState, matrixStack);
            matrixStack.translate(0.0F, -1.501F, 0.0F);
            this.model.setAngles(renderState);

            boolean bl = this.isVisible(renderState);
            boolean bl2 = !bl && !renderState.invisibleToPlayer;
            RenderLayer renderLayer = this.getRenderLayer(renderState, bl, bl2, renderState.hasOutline);
            if (renderLayer != null) {
                VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                    vertexConsumerProvider, RenderLayer.getEntityCutout(getTexture(renderState)), false, isEnchanted
                );

                int j = getOverlay(renderState, this.getAnimationCounter(renderState));
                int k = bl2 ? 654311423 : -1;
                int l = ColorHelper.mix(k, this.getMixColor(renderState));
                this.model.render(matrixStack, vertexConsumer, i, j, l);
            }

            if (this.shouldRenderFeatures(renderState)) {
                for(FeatureRenderer<CowEntityRenderState, CowEntityModel> featureRenderer : this.features) {
                    featureRenderer.render(matrixStack, vertexConsumerProvider, i, renderState, renderState.relativeHeadYaw, renderState.pitch);
                }
            }

            matrixStack.pop();
        }

        ci.cancel();
    }

    @Shadow
    public Identifier getTexture(CowEntityRenderState state) {
        return null;
    }

    @Shadow
    public CowEntityRenderState createRenderState() {
        return null;
    }
}