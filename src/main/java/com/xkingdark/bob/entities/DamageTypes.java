package com.xkingdark.bob.entities;

import com.xkingdark.bob.Main;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class DamageTypes {
    public static final RegistryKey<DamageType> BLUE_BERRY_BUSH = of("blue_berry_bush");

    public static DamageSource getSource(World world, RegistryKey<DamageType> key) {
        Registry<DamageType> registry = world.getRegistryManager().getOrThrow(RegistryKeys.DAMAGE_TYPE);
        return new DamageSource(registry.getOrThrow(key));
    }

    public static RegistryKey<DamageType> of(String id) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Main.MOD_ID, id));
    }
}
