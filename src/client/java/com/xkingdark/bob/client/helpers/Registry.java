package com.xkingdark.bob.client.helpers;
import com.xkingdark.bob.client.Client;

import com.xkingdark.bob.client.screens.WaystoneScreen;
import com.xkingdark.bob.network.packets.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class Registry {
    private static final KeyBinding test = new KeyBinding(
            "key." + Client.MOD_ID + ".test",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_1,
            "category." + Client.MOD_ID + ".keybinds"
    );

    public static void initialize() {
        KeyBindingHelper.registerKeyBinding(test);
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            while (test.wasPressed()) {

            };
        });

        PayloadTypeRegistry.playS2C().register(WaystonePacket.IDENTIFIER, WaystonePacket.CODEC);
        ClientPlayNetworking.registerGlobalReceiver(WaystonePacket.IDENTIFIER, (payload, context) -> {
            MinecraftClient client = context.client();
            if (client.player == null)
                return;

            Boolean isBlock = payload.isBlock();
            client.setScreen(new WaystoneScreen());
        });
    };
};
