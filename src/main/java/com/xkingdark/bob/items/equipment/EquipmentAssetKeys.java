package com.xkingdark.bob.items.equipment;

import com.xkingdark.bob.Main;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static net.minecraft.item.equipment.EquipmentAssetKeys.REGISTRY_KEY;

public interface EquipmentAssetKeys {
    RegistryKey<EquipmentAsset> COPPER = of("copper");
    RegistryKey<EquipmentAsset> AMETHYST = of("amethyst");
    RegistryKey<EquipmentAsset> SHULKER = of("shulker");
    RegistryKey<EquipmentAsset> CORSTINITE = of("corstinite");
    RegistryKey<EquipmentAsset> STARDUST = of("stardust");

    static RegistryKey<EquipmentAsset> of(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.of(Main.MOD_ID, name));
    };
};