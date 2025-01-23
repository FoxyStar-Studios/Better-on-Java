package com.xkingdark.bob;

import com.xkingdark.bob.helpers.Registry;
import com.xkingdark.bob.network.NetworkHandler;
import com.xkingdark.bob.sound.SoundEvents;
import net.fabricmc.api.ModInitializer;
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
        Registry.initialize();

        new Blocks();
        new Items();
        new ItemGroups();
        new SoundEvents();

        NetworkHandler.registerServerPackets();
        NetworkHandler.registerReceivers();
    }
}
