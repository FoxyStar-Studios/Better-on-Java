package com.xkingdark.bob.client;

import com.xkingdark.bob.client.helpers.Registry;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ClientModInitializer {
    public static final String MOD_ID = "better_on_bedrock";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better on Bedrock");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing client.");
        Registry.initialize();
    };
};
