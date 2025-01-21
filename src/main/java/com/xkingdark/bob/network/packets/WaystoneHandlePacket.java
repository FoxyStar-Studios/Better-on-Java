package com.xkingdark.bob.network.packets;

import com.xkingdark.bob.network.Packets;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.text.Text;

public record WaystoneHandlePacket(int index) implements CustomPayload {
    public static final PacketCodec<RegistryByteBuf, WaystoneHandlePacket> CODEC = PacketCodec.tuple(
        PacketCodecs.INTEGER, WaystoneHandlePacket::index,
        WaystoneHandlePacket::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return Packets.WAYSTONE_HANDLE_PACKET;
    }

    public static void handle(WaystoneHandlePacket payload, ServerPlayNetworking.Context context) {
        context.player().sendMessage(Text.of("Index: " + payload.index));
    }
}
