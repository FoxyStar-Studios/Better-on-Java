package com.xkingdark.bob.helpers;

import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.core.Events;
import com.xkingdark.bob.items.ItemGroups;
import com.xkingdark.bob.items.Items;
import com.xkingdark.bob.network.NetworkHandler;
import com.xkingdark.bob.sound.SoundEvents;

public class Registry {
    public static void initialize() {
        new Items();
        new Blocks();
        ItemGroups.register();
        new SoundEvents();
        Events.register();

        NetworkHandler.registerServerPackets();
        NetworkHandler.registerReceivers();
    };
};