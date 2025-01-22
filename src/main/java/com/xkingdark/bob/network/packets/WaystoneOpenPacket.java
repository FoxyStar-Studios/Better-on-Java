package com.xkingdark.bob.network.packets;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;
import com.xkingdark.bob.network.Packets;

public record WaystoneOpenPacket(
    Boolean isFromBlock,
    BlockPos blockPos
) implements CustomPayload {
    public static final PacketCodec<RegistryByteBuf, WaystoneOpenPacket> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOLEAN, WaystoneOpenPacket::isFromBlock,
            BlockPos.PACKET_CODEC, WaystoneOpenPacket::blockPos,
            WaystoneOpenPacket::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return Packets.WAYSTONE_OPEN_PACKET;
    }
}
