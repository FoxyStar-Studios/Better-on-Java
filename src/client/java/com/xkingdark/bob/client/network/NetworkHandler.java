package com.xkingdark.bob.client.network;

import com.xkingdark.bob.network.Packets;
import com.xkingdark.bob.client.network.packets.WaystoneOpenPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public interface NetworkHandler {
    static void registerServerPackets() {
        PayloadTypeRegistry.playS2C().register(Packets.WAYSTONE_OPEN_PACKET, com.xkingdark.bob.network.packets.WaystoneOpenPacket.CODEC);
    };

    static void registerReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(Packets.WAYSTONE_OPEN_PACKET, WaystoneOpenPacket::handle);
    };
};
