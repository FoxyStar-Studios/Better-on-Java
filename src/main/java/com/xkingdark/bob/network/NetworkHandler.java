package com.xkingdark.bob.network;

import com.xkingdark.bob.network.packets.WaystoneHandlePacket;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public interface NetworkHandler {
    static void registerServerPackets() {
        PayloadTypeRegistry.playC2S().register(Packets.WAYSTONE_HANDLE_PACKET, WaystoneHandlePacket.CODEC);
    };

    static void registerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(Packets.WAYSTONE_HANDLE_PACKET, WaystoneHandlePacket::handle);
    };
};