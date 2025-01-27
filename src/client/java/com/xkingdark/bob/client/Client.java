package com.xkingdark.bob.client;

import com.xkingdark.bob.blocks.entity.PedestalBlockEntityType;
import com.xkingdark.bob.blocks.pedestal.PedestalBlockEntity;
import com.xkingdark.bob.client.blocks.PedestalBlockEntityDisplay;
import com.xkingdark.bob.client.helpers.Registry;
import com.xkingdark.bob.client.network.NetworkHandler;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.RotationAxis;

import static com.xkingdark.bob.Main.LOGGER;


public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing client.");
        BlockEntityRendererFactories.register(PedestalBlockEntityType.PEDESTAL, PedestalBlockEntityDisplay::new);
    }



    static {
        Registry.initialize();
        NetworkHandler.registerServerPackets();
        NetworkHandler.registerReceivers();
    }
}