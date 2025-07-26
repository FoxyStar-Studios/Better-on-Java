package com.xkingdark.bob.core.mixin.entities;

import com.xkingdark.bob.core.accessor.EnchantedEntityAccessor;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements EnchantedEntityAccessor {
    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract float getHealth();

    @Shadow @Nullable public abstract EntityAttributeInstance getAttributeInstance(RegistryEntry<EntityAttribute> attribute);

    @Shadow protected abstract void updateAttribute(RegistryEntry<EntityAttribute> attribute);

    @Unique @Final
    private static final TrackedData<Boolean> ENCHANTED = DataTracker.registerData(LivingEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    boolean isEnchanted;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    public void BoB$initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
        builder.add(ENCHANTED, false);
    }

    @Inject(method = "readCustomData", at = @At("TAIL"))
    public void BoB$readCustomData(ReadView view, CallbackInfo ci) {
        this.isEnchanted = view.getBoolean("isEnchanted", false);
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
    };

    @Inject(method = "writeCustomData", at = @At("TAIL"))
    public void BoB$writeCustomData(WriteView view, CallbackInfo ci) {
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
        view.putBoolean("isEnchanted", this.isEnchanted);
    };

    @Unique
    public Boolean BoB$isEnchanted() {
        return this.dataTracker.get(ENCHANTED);
    }

    @Unique
    public void setEnchanted(boolean enchanted) {
        this.isEnchanted = enchanted;
        this.dataTracker.set(ENCHANTED, this.isEnchanted);
    }

    @Unique
    public void setMaxHealth(double value) {
        EntityAttributeInstance healthAttribute = this.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (healthAttribute != null) {
            double maxHealth = healthAttribute.getBaseValue();

            healthAttribute.setBaseValue(value);
            this.setHealth(
                (float) (value - (maxHealth - this.getHealth()))
            );
        };
    }

    @Shadow
    protected void initDataTracker(DataTracker.Builder builder) {}

    @Shadow
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }
};
