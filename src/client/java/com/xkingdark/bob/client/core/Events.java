package com.xkingdark.bob.client.core;

import com.xkingdark.bob.client.screens.WaystoneScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.TutorialToast;
import net.minecraft.text.Text;

public class Events {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(Events::onClientTick);
    }

    private static void onClientTick(MinecraftClient client) {
        if (client == null || client.player == null)
            return;

        if (Keybinds.WAYSTONE.wasPressed()) {
            client.setScreen(
                new WaystoneScreen(false, client.player.getBlockPos())
            );
        };

        if (Keybinds.TOAST_1.wasPressed()) {
            Toast toast = new TutorialToast(client.textRenderer, TutorialToast.Type.MOVEMENT_KEYS,
                Text.literal("Test"), Text.literal("Hello, world!"), true);

            client.getToastManager().add(toast);
        };
    };
};