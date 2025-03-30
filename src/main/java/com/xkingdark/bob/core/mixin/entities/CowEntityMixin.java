package com.xkingdark.bob.core.mixin.entities;

import com.xkingdark.bob.core.accessor.EnchantedEntityAccessor;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(CowEntity.class)
public class CowEntityMixin extends AbstractCowEntity implements EnchantedEntityAccessor {
    @Unique
    private static final TrackedData<Boolean> ENCHANTED = DataTracker.registerData(CowEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique private boolean isEnchanted;

    public CowEntityMixin(EntityType<? extends AbstractCowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initDataTracker", at = @At("HEAD"))
    public void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(ENCHANTED, false);
    }

    @Inject(method = "initialize", at = @At("TAIL"))
    private void initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, CallbackInfoReturnable<EntityData> cir) {
        this.isEnchanted = ThreadLocalRandom.current().nextInt(210) < 55;
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void bob$readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.isEnchanted = nbt.getBoolean("isEnchanted", false);
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void bob$writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
        nbt.putBoolean("isEnchanted", this.isEnchanted);
    }

    @Unique
    public Boolean bob$isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }

    @Shadow
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}