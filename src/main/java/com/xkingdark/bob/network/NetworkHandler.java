package com.xkingdark.bob.network;

import com.xkingdark.bob.network.packets.WaystoneHandlePacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class NetworkHandler {
    static {
        ServerPlayNetworking.registerGlobalReceiver(Packets.WAYSTONE_HANDLE_PACKET, WaystoneHandlePacket::handle);
    }
}
