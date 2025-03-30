package com.xkingdark.bob.core.mixin.entities;

import com.xkingdark.bob.core.accessor.EnchantedEntityAccessor;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends Entity implements EnchantedEntityAccessor {
    @Unique @Final
    private static TrackedData<Boolean> ENCHANTED = DataTracker.registerData(LivingEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    boolean isEnchanted;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    public void initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(ENCHANTED, false);
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
    public Boolean BoB$isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }

    @Unique
    public void setEnchanted(boolean enchanted) {
        this.isEnchanted = enchanted;
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
    }

    @Shadow
    protected void initDataTracker(DataTracker.Builder builder) {}

    @Shadow
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Shadow
    public void readCustomDataFromNbt(NbtCompound nbt) {}

    @Shadow
    public void writeCustomDataToNbt(NbtCompound nbt) {}
}
