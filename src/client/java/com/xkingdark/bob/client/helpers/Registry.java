package com.xkingdark.bob.client.helpers;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.client.Client;

import com.xkingdark.bob.network.Packets;
import com.xkingdark.bob.network.packets.WaystoneOpenPacket;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.codec.PacketCodecs;
import org.lwjgl.glfw.GLFW;

public class Registry {
    private static final KeyBinding test = new KeyBinding(
            "key." + Client.MOD_ID + ".test",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_KP_1,
            "category." + Client.MOD_ID + ".keybinds"
    );

    public static void initialize() {
        KeyBindingHelper.registerKeyBinding(test);
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            while (test.wasPressed()) {

            };
        });

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.PINK_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TALL_LAVENDER, RenderLayer.getCutout());

        PayloadTypeRegistry.playS2C().register(Packets.WAYSTONE_OPEN_PACKET, WaystoneOpenPacket.CODEC);
    };
};
