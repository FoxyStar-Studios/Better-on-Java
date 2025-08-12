package com.xkingdark.bob.entities.spears;

import com.xkingdark.bob.entities.SpearEntity;
import com.xkingdark.bob.items.Items;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StardustSpearEntity extends SpearEntity {
    public StardustSpearEntity(EntityType<? extends SpearEntity> entityType, World world) {
        super(entityType, world);
        this.setDamage(9);
    };

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(Items.STARDUST_SPEAR);
    };
};