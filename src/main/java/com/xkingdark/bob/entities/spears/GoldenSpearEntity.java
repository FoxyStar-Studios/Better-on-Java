package com.xkingdark.bob.entities.spears;

import com.xkingdark.bob.entities.SpearEntity;
import com.xkingdark.bob.items.Items;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GoldenSpearEntity extends SpearEntity {
    public GoldenSpearEntity(EntityType<? extends SpearEntity> entityType, World world) {
        super(entityType, world);
        this.setDamage(7);
    };

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.GOLDEN_SPEAR);
    };
};