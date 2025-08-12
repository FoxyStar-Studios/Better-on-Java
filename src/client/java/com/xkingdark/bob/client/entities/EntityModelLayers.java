package com.xkingdark.bob.client.entities;

import com.xkingdark.bob.Main;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class EntityModelLayers {
    public static EntityModelLayer WOODEN_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "wooden_spear"), "main");
    public static EntityModelLayer STONE_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "stone_spear"), "main");
    public static EntityModelLayer GOLDEN_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "golden_spear"), "main");
    public static EntityModelLayer IRON_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "iron_spear"), "main");
    public static EntityModelLayer DIAMOND_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "diamond_spear"), "main");
    public static EntityModelLayer AMETHYST_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "amethyst_spear"), "main");
    public static EntityModelLayer STARDUST_SPEAR = new EntityModelLayer(Identifier.of(Main.MOD_ID, "stardust_spear"), "main");

    public static EntityModelLayer CHORUS_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/chorus"), "main");
    public static EntityModelLayer CHORUS_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/chorus"), "main");
    public static EntityModelLayer VACANT_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/vacant"), "main");
    public static EntityModelLayer VACANT_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/vacant"), "main");
    public static EntityModelLayer VOIDING_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/voiding"), "main");
    public static EntityModelLayer VOIDING_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/voiding"), "main");
};