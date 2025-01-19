package com.xkingdark.bob.items.equipment;

import com.xkingdark.bob.Main;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static net.minecraft.item.equipment.EquipmentAssetKeys.REGISTRY_KEY;

public interface EquipmentAssetKeys {
    RegistryKey<EquipmentAsset> CORSTINITE = register("corstinite");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.of(Main.MOD_ID, name));
    }
}
