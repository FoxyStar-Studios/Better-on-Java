package com.xkingdark.bob.client.core;

import com.xkingdark.bob.client.core.toasts.BobToast;
import com.xkingdark.bob.client.screens.WaystoneScreen;
import com.xkingdark.bob.items.Items;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.TutorialToast;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class Events {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(Events::onClientTick);
    };

    private static void onClientTick(MinecraftClient client) {
        if (client == null || client.player == null)
            return;

        if (Keybinds.WAYSTONE.wasPressed()) {
            client.setScreen(
                new WaystoneScreen(false, client.player.getBlockPos())
            );
        };

        if (Keybinds.TOAST_1.wasPressed()) {
            Text title = Text.literal("Better on Bedrock").withColor(Integer.parseInt("9A5CC6", 16));
            Text toastText = Text.literal("A brand new world!");

            client.getToastManager().add(
                new BobToast(
                    BobToast.Type.GOAL, title, toastText,
                    Items.GUIDE_BOOK.getDefaultStack(), true
                )
            );
        };


        if (Keybinds.TOAST_2.wasPressed()) {
            Text title = Text.literal("Quest Complete!").withColor(Colors.GREEN);
            Text toastText = Text.literal("First Wood");

            client.getToastManager().add(
                new BobToast(
                    BobToast.Type.QUEST, title, toastText,
                    Items.GUIDE_BOOK.getDefaultStack(), true
                )
            );
        };


        if (Keybinds.TOAST_3.wasPressed()) {
            Text title = Text.literal("Bounty Complete!").withColor(Integer.parseInt("55FFFF", 16));
            Text toastText = Text.literal("Claim Your Rewards!").withColor(Colors.YELLOW);

            client.getToastManager().add(
                new BobToast(
                    BobToast.Type.BOUNTY, title, toastText,
                    net.minecraft.item.Items.STICK.getDefaultStack(), true
                )
            );
        };
    };
};