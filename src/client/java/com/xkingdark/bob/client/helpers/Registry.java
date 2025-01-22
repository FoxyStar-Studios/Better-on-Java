package com.xkingdark.bob.client.helpers;
import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.client.Client;

import com.xkingdark.bob.client.screens.WaystoneScreen;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
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

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PINK_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALL_LAVENDER, RenderLayer.getCutout());
    };
};
