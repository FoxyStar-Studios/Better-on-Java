package com.xkingdark.bob.blocks.entity;

import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.blocks.pedestal.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.*;
import net.minecraft.block.entity.BlockEntityType;

public class PedestalBlockEntityType {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("tutorial", path), blockEntityType);
    }

    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL = register(
            "pedestal",
            // For versions 1.21.2 and above,
            // replace `BlockEntityType.Builder` with `FabricBlockEntityTypeBuilder`.
            FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, Blocks.PEDESTAL).build()
    );

    public static void initialize() {
    }
}