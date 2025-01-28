package com.xkingdark.bob.blocks.crops;

import com.xkingdark.bob.entities.DamageTypes;
import com.xkingdark.bob.items.Items;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;

public class BlueBerryBushBlock extends BushBlock {
    public BlueBerryBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    public Item getDrop() {
        return Items.BLUE_BERRIES;
    }

    @Override
    public boolean shouldDamage() {
        return true;
    }

    @Override
    public RegistryKey<DamageType> damageType() {
        return DamageTypes.BLUE_BERRY_BUSH;
    }
}