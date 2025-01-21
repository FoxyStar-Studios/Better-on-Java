package com.xkingdark.bob.network;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.network.packets.WaystoneHandlePacket;
import com.xkingdark.bob.network.packets.WaystoneOpenPacket;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class Packets {
    public static final CustomPayload.Id<WaystoneOpenPacket> WAYSTONE_OPEN_PACKET = new CustomPayload.Id<>(Identifier.of(Main.MOD_ID, "waystone_open_packet"));
    public static final CustomPayload.Id<WaystoneHandlePacket> WAYSTONE_HANDLE_PACKET = new CustomPayload.Id<>(Identifier.of(Main.MOD_ID, "waystone_handle_packet"));
}
