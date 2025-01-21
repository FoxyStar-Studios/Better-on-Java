package com.xkingdark.bob.client.network;

import com.xkingdark.bob.network.Packets;
import com.xkingdark.bob.client.network.packets.WaystoneOpenPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class NetworkHandler {
    static {
        ClientPlayNetworking.registerGlobalReceiver(Packets.WAYSTONE_OPEN_PACKET, WaystoneOpenPacket::handle);
    }
}
