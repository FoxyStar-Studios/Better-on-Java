package com.xkingdark.bob.client.entities;

import com.xkingdark.bob.Main;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class EntityModelLayers {
    public static EntityModelLayer CHORUS_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/chorus"), "main");
    public static EntityModelLayer CHORUS_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/chorus"), "main");
    public static EntityModelLayer VACANT_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/vacant"), "main");
    public static EntityModelLayer VACANT_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/vacant"), "main");
    public static EntityModelLayer VOIDING_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "boat/voiding"), "main");
    public static EntityModelLayer VOIDING_CHEST_BOAT = new EntityModelLayer(Identifier.of(Main.MOD_ID, "chest_boat/voiding"), "main");
}
