package com.xkingdark.bob.client;

import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.client.helpers.Registry;
import com.xkingdark.bob.client.network.NetworkHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ClientModInitializer {
    public static final String MOD_ID = "better_on_bedrock";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better on Bedrock");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing client.");
    };

    static {
        Registry.initialize();
        new NetworkHandler();
    }
};
