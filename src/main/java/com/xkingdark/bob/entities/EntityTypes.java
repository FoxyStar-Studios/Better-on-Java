package com.xkingdark.bob.entities;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.items.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class EntityTypes {
    public static final EntityType<BoatEntity> CHORUS_BOAT;
    public static final EntityType<ChestBoatEntity> CHORUS_CHEST_BOAT;
    public static final EntityType<BoatEntity> VACANT_BOAT;
    public static final EntityType<ChestBoatEntity> VACANT_CHEST_BOAT;
    public static final EntityType<BoatEntity> VOIDING_BOAT;
    public static final EntityType<ChestBoatEntity> VOIDING_CHEST_BOAT;

    static {
        CHORUS_BOAT = register("chorus_boat",
            EntityType.Builder.create(getBoatFactory(() -> Items.CHORUS_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
        CHORUS_CHEST_BOAT = register("chorus_chest_boat",
            EntityType.Builder.create(getChestBoatFactory(() -> Items.CHORUS_CHEST_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
        VACANT_BOAT = register("vacant_boat",
            EntityType.Builder.create(getBoatFactory(() -> Items.VACANT_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
        VACANT_CHEST_BOAT = register("vacant_chest_boat",
            EntityType.Builder.create(getChestBoatFactory(() -> Items.VACANT_CHEST_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
        VOIDING_BOAT = register("voiding_boat",
            EntityType.Builder.create(getBoatFactory(() -> Items.VOIDING_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
        VOIDING_CHEST_BOAT = register("voiding_chest_boat",
            EntityType.Builder.create(getChestBoatFactory(() -> Items.VOIDING_CHEST_BOAT), SpawnGroup.MISC)
                .dropsNothing()
                .dimensions(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .maxTrackingRange(10)
        );
    }

    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Main.MOD_ID, id));
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }

    private static EntityType.EntityFactory<BoatEntity> getBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> new BoatEntity(type, world, itemSupplier);
    }

    private static EntityType.EntityFactory<ChestBoatEntity> getChestBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> new ChestBoatEntity(type, world, itemSupplier);
    }
}
