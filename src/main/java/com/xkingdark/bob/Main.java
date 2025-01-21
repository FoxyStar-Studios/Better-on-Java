package com.xkingdark.bob;

import com.xkingdark.bob.network.NetworkHandler;
import com.xkingdark.bob.network.Packets;
import com.xkingdark.bob.network.packets.WaystoneHandlePacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.items.Items;
import com.xkingdark.bob.items.ItemGroups;

public class Main implements ModInitializer {
    public static final String MOD_ID = "better_on_bedrock";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better on Bedrock");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello, world!");
    }

    static {
        new Blocks();
        new Items();
        new ItemGroups();

        PayloadTypeRegistry.playC2S().register(Packets.WAYSTONE_HANDLE_PACKET, WaystoneHandlePacket.CODEC);
        new NetworkHandler();
    }
}
