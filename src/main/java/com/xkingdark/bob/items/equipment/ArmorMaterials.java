package com.xkingdark.bob.items.equipment;

import com.xkingdark.bob.items.ItemTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public interface ArmorMaterials {
    ArmorMaterial CORSTINITE = new ArmorMaterial(37, Map.of(
            EquipmentType.HELMET, 3,
            EquipmentType.CHESTPLATE, 8,
            EquipmentType.LEGGINGS, 6,
            EquipmentType.BOOTS, 3
    ), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.CORSTINITE, EquipmentAssetKeys.CORSTINITE);
}
