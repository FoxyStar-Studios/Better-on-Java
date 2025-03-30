package com.xkingdark.bob.client.helpers;

import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.client.blocks.PedestalBlockEntityDisplay;
import com.xkingdark.bob.client.core.Events;
import com.xkingdark.bob.client.core.Keybinds;
import com.xkingdark.bob.client.entities.EntityModelLayers;
import com.xkingdark.bob.client.entities.SpearEntityRenderer;
import com.xkingdark.bob.client.entities.models.SpearEntityModel;
import com.xkingdark.bob.entities.EntityTypes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.DecoratedPotPattern;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.registry.Registries;

public class Registry {
    public static void initialize() {
        Registry.registerPotterySherds();
        Registry.registerBlockRender();
        Registry.registerEntityRender();

        new Keybinds();
        Events.register();
    };

    private static void registerPotterySherds() {
        // Pottery Patters
        com.xkingdark.bob.blocks.DecoratedPotPatterns.SHERD_TO_PATTERN.forEach(
            (item, key) -> {
                DecoratedPotPattern registry = Registries.DECORATED_POT_PATTERN.get(key);
                if (registry == null)
                    return;

                TexturedRenderLayers.DECORATED_POT_PATTERN_TEXTURES.put(key,
                    TexturedRenderLayers.DECORATED_POT_SPRITE_MAPPER.map(registry.assetId()));
            }
        );
    };

    private static void registerBlockRender() {
        // Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALL_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BLUEGROD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.LUSH_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OPEN_TALL_EYEBLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CLOSED_TALL_EYEBLOSSOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PINK_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALLER_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.LILAC_HEADS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.IRIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.HYDRANGEA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CLEMATIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BIG_SPROUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.ANEMONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TINY_SPROUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WILDFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PURPLE_HYDRANGEA, RenderLayer.getCutout());


        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PEACH_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.ORANGE_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BARLEY_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BLUE_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GRAPE_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CABBAGE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.EGGPLANT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.HEALTHY_CARROT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.ONION_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.WILD_CARROT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CHORUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CHORUS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VACANT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VACANT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VOIDING_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.VOIDING_TRAPDOOR, RenderLayer.getCutout());
    };

    private static void registerEntityRender() {
        // Entities
        BlockEntityRendererFactories.register(EntityTypes.PEDESTAL, PedestalBlockEntityDisplay::new);

        EntityRendererRegistry.register(EntityTypes.WOODEN_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.WOODEN_SPEAR));
        EntityRendererRegistry.register(EntityTypes.STONE_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.STONE_SPEAR));
        EntityRendererRegistry.register(EntityTypes.GOLDEN_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.GOLDEN_SPEAR));
        EntityRendererRegistry.register(EntityTypes.AMETHYST_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.AMETHYST_SPEAR));
        EntityRendererRegistry.register(EntityTypes.IRON_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.IRON_SPEAR));
        EntityRendererRegistry.register(EntityTypes.DIAMOND_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.DIAMOND_SPEAR));
        EntityRendererRegistry.register(EntityTypes.STARDUST_SPEAR, (context) ->
            new SpearEntityRenderer(context, EntityModelLayers.STARDUST_SPEAR));

        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.WOODEN_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.STONE_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.GOLDEN_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.AMETHYST_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.IRON_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.DIAMOND_SPEAR, SpearEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.STARDUST_SPEAR, SpearEntityModel::getTexturedModelData);


        //  Chorus
        EntityRendererRegistry.register(EntityTypes.CHORUS_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.CHORUS_BOAT));
        EntityRendererRegistry.register(EntityTypes.CHORUS_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.CHORUS_CHEST_BOAT));

        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.CHORUS_BOAT, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.CHORUS_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);

        //  Vacant
        EntityRendererRegistry.register(EntityTypes.VACANT_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VACANT_BOAT));
        EntityRendererRegistry.register(EntityTypes.VACANT_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VACANT_CHEST_BOAT));

        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VACANT_BOAT, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VACANT_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);

        //  Voiding
        EntityRendererRegistry.register(EntityTypes.VOIDING_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VOIDING_BOAT));
        EntityRendererRegistry.register(EntityTypes.VOIDING_CHEST_BOAT, (context) ->
            new BoatEntityRenderer(context, EntityModelLayers.VOIDING_CHEST_BOAT));

        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VOIDING_BOAT, BoatEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EntityModelLayers.VOIDING_CHEST_BOAT, BoatEntityModel::getChestTexturedModelData);
    };
};
