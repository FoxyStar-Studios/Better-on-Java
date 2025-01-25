package com.xkingdark.bob.client.helpers;
import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.client.Client;

import com.xkingdark.bob.client.entities.EntityModelLayers;
import com.xkingdark.bob.client.screens.WaystoneScreen;
import com.xkingdark.bob.entities.EntityTypes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.client.network.ClientAdvancementManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.BlazeEntityRenderer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;

public class Registry {
    private static final KeyBinding TEST = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        Util.createTranslationKey("key", Identifier.of(Main.MOD_ID, "test")),
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_KP_1,
        Util.createTranslationKey("category", Identifier.of(Main.MOD_ID, "keybinds"))
    ));

    public static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            if (client == null || client.player == null)
                return;

            while (TEST.wasPressed()) {
                client.setScreen(
                    new WaystoneScreen(false, client.player.getBlockPos())
                );
            }
        });

        // Entities
        //  Chorus
        EntityRendererRegistry.register(EntityTypes.CHORUS_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.CHORUS_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.CHORUS_BOAT, BoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(EntityTypes.CHORUS_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.CHORUS_CHEST_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.CHORUS_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);

        //  Vacant
        EntityRendererRegistry.register(EntityTypes.VACANT_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VACANT_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VACANT_BOAT, BoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(EntityTypes.VACANT_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VACANT_CHEST_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VACANT_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);

        //  Voiding
        EntityRendererRegistry.register(EntityTypes.VOIDING_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VOIDING_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VOIDING_BOAT, BoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(EntityTypes.VOIDING_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VOIDING_CHEST_BOAT));
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VOIDING_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);

        // Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PINK_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALL_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BLUEGROD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALLER_GRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CHORUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CHORUS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VACANT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VACANT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VOIDING_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VOIDING_TRAPDOOR, RenderLayer.getCutout());
;    };
};
