package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class Blocks {
    public static final Block WAYSTONE;
    public static final Block STARDUST_ORE;
    public static final Block PINK_LAVENDER;
    public static final Block TALL_LAVENDER;

    static {
        WAYSTONE = Blocks.register("waystone", WaystoneBlock::new,
                AbstractBlock.Settings.create().hardness(2.52f).requiresTool().nonOpaque());
        STARDUST_ORE = Blocks.register("stardust_ore",
                AbstractBlock.Settings.create().hardness(2.52f).requiresTool().nonOpaque());
        PINK_LAVENDER = Blocks.register("pink_lavender", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        TALL_LAVENDER = Blocks.register("tall_lavender", TallFlowerBlock::new,
            AbstractBlock.Settings.create()
                 .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                 .offset(AbstractBlock.OffsetType.XZ)
                 .noCollision().burnable()
                 .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
    }


    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(key));
        return net.minecraft.registry.Registry.register(Registries.BLOCK, key, block);
    }

    public static Block register(RegistryKey<Block> key, AbstractBlock.Settings settings) {
        return register(key, Block::new, settings);
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Main.MOD_ID, id));
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(keyOf(id), factory, settings);
    }

    private static Block register(String id, AbstractBlock.Settings settings) {
        return register(id, Block::new, settings);
    }
}
