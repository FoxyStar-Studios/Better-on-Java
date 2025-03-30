package com.xkingdark.bob;

import com.xkingdark.bob.helpers.Registry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static final String MOD_ID = "better_on_bedrock";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better on Bedrock");
    
    @Override
    public void onInitialize() {
        LOGGER.info("Hello, world!");
    }

    static {
        Registry.initialize();
    };
};