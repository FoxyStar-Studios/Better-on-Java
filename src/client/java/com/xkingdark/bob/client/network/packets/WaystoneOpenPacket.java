package com.xkingdark.bob.client.network.packets;

import com.xkingdark.bob.client.screens.WaystoneScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

public class WaystoneOpenPacket {
    public static void handle(com.xkingdark.bob.network.packets.WaystoneOpenPacket payload, ClientPlayNetworking.Context context) {
        MinecraftClient client = context.client();
        if (client.player == null)
            return;

        Boolean isBlock = payload.isBlock();
        client.setScreen(new WaystoneScreen());
    }
}
