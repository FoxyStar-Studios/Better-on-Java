package com.xkingdark.bob.client;

import com.xkingdark.bob.client.helpers.Registry;
import com.xkingdark.bob.client.network.NetworkHandler;
import net.fabricmc.api.ClientModInitializer;

import static com.xkingdark.bob.Main.LOGGER;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing client.");
    }

    static {
        Registry.initialize();
        NetworkHandler.registerServerPackets();
        NetworkHandler.registerReceivers();
    };
};