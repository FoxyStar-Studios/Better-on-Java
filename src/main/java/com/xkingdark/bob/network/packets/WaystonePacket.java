package com.xkingdark.bob.network.packets;

import com.xkingdark.bob.Main;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public record WaystonePacket(Boolean isBlock, BlockPos blockPos) implements CustomPayload {
    public static final CustomPayload.Id<WaystonePacket> IDENTIFIER = new CustomPayload.Id<>(Identifier.of(Main.MOD_ID, "waystone_open"));
    public static final PacketCodec<RegistryByteBuf, WaystonePacket> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOLEAN, WaystonePacket::isBlock,
            BlockPos.PACKET_CODEC, WaystonePacket::blockPos,
            WaystonePacket::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return IDENTIFIER;
    }
}
