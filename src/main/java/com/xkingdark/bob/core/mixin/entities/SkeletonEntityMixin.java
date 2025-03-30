package com.xkingdark.bob.core.mixin.entities;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonEntityMixin extends LivingEntityMixin {
    public SkeletonEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "initialize", at = @At("TAIL"))
    private void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        boolean isEnchanted = ThreadLocalRandom.current().nextInt(210) < 55;
        if (isEnchanted) {
            this.setEnchanted(true);
            this.setMaxHealth(30);
        }
    }
}
