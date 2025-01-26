package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.minecraft.block.Blocks.createLogSettings;
import static net.minecraft.block.Blocks.createButtonSettings;

public final class Blocks {
    public static final Block WAYSTONE;
    public static final Block STARDUST_ORE;
    public static final Block PINK_LAVENDER;
    public static final Block TALL_LAVENDER;
    public static final Block BLUEGROD;
    public static final Block TALLER_GRASS;

    //Crops
    public static final Block CABBAGE_CROP;

    // Chorus Woodset
    public static final Block CHORUS_LOG;
    public static final Block CHORUS_WOOD;
    public static final Block STRIPPED_CHORUS_LOG;
    public static final Block STRIPPED_CHORUS_WOOD;
    public static final Block CHORUS_PLANKS;
    public static final Block CHORUS_DOOR;
    public static final Block CHORUS_PRESSURE_PLATE;
    public static final Block CHORUS_TRAPDOOR;
    public static final Block CHORUS_BUTTON;
    public static final Block CHORUS_STAIRS;
    public static final Block CHORUS_SLAB;
    public static final Block CHORUS_SIGN;
    public static final Block CHORUS_WALL_SIGN;
    public static final Block CHORUS_HANGING_SIGN;
    public static final Block CHORUS_WALL_HANGING_SIGN;
    public static final Block CHORUS_FENCE;
    public static final Block CHORUS_FENCE_GATE;

    // Vacant Woodset
    public static final Block VACANT_LOG;
    public static final Block VACANT_WOOD;
    public static final Block STRIPPED_VACANT_LOG;
    public static final Block STRIPPED_VACANT_WOOD;
    public static final Block VACANT_PLANKS;
    public static final Block VACANT_DOOR;
    public static final Block VACANT_PRESSURE_PLATE;
    public static final Block VACANT_TRAPDOOR;
    public static final Block VACANT_BUTTON;
    public static final Block VACANT_STAIRS;
    public static final Block VACANT_SLAB;
    public static final Block VACANT_SIGN;
    public static final Block VACANT_WALL_SIGN;
    public static final Block VACANT_HANGING_SIGN;
    public static final Block VACANT_WALL_HANGING_SIGN;
    public static final Block VACANT_FENCE;
    public static final Block VACANT_FENCE_GATE;

    // Voiding Woodset
    public static final Block VOIDING_LOG;
    public static final Block VOIDING_WOOD;
    public static final Block STRIPPED_VOIDING_LOG;
    public static final Block STRIPPED_VOIDING_WOOD;
    public static final Block VOIDING_PLANKS;
    public static final Block VOIDING_DOOR;
    public static final Block VOIDING_PRESSURE_PLATE;
    public static final Block VOIDING_TRAPDOOR;
    public static final Block VOIDING_BUTTON;
    public static final Block VOIDING_STAIRS;
    public static final Block VOIDING_SLAB;
    public static final Block VOIDING_SIGN;
    public static final Block VOIDING_WALL_SIGN;
    public static final Block VOIDING_HANGING_SIGN;
    public static final Block VOIDING_WALL_HANGING_SIGN;
    public static final Block VOIDING_FENCE;
    public static final Block VOIDING_FENCE_GATE;

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
        BLUEGROD = Blocks.register("bluegrod", TallFlowerBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        TALLER_GRASS = Blocks.register("taller_grass", TallFlowerBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        CABBAGE_CROP = Blocks.register("cabbage_crop", CabbageCrop::new, AbstractBlock.Settings.create().breakInstantly().noCollision().noBlockBreakParticles());

        // Chorus Woodset
        CHORUS_LOG = register("chorus_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
        CHORUS_WOOD = register("chorus_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        STRIPPED_CHORUS_LOG = register("stripped_chorus_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.OAK_TAN, BlockSoundGroup.WOOD));
        StrippableBlockRegistry.register(CHORUS_LOG, STRIPPED_CHORUS_LOG);
        STRIPPED_CHORUS_WOOD = register("stripped_chorus_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        StrippableBlockRegistry.register(CHORUS_WOOD, STRIPPED_CHORUS_WOOD);
        CHORUS_PLANKS = register("chorus_planks", WoodTypes.createPlanksSettings());
        CHORUS_DOOR = register("chorus_door", settings ->
            new DoorBlock(BlockSetTypes.CHORUS, settings), WoodTypes.createDoorSettings(CHORUS_PLANKS));
        CHORUS_PRESSURE_PLATE = register("chorus_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetTypes.CHORUS, settings), WoodTypes.createPressurePlateSettings(CHORUS_PLANKS));
        CHORUS_TRAPDOOR = register("chorus_trapdoor", settings ->
            new TrapdoorBlock(BlockSetTypes.CHORUS, settings), WoodTypes.createTrapdoorSettings());
        CHORUS_BUTTON = register("chorus_button", settings ->
            new ButtonBlock(BlockSetTypes.CHORUS, 30, settings), createButtonSettings());
        CHORUS_STAIRS = registerStairsBlock("chorus_stairs", CHORUS_PLANKS);
        CHORUS_SLAB = register("chorus_slab", SlabBlock::new,
            WoodTypes.createPlanksSettings());
        CHORUS_SIGN = register("chorus_sign", settings ->
            new SignBlock(WoodTypes.CHORUS, settings), WoodTypes.createSignSettings());
        CHORUS_WALL_SIGN = register("chorus_wall_sign", settings ->
                new WallSignBlock(WoodType.OAK, settings),
            copyLootTable(CHORUS_SIGN, true)
                .mapColor(MapColor.OAK_TAN)
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.SIGN.addSupportedBlock(CHORUS_SIGN);
        BlockEntityType.SIGN.addSupportedBlock(CHORUS_WALL_SIGN);
        CHORUS_HANGING_SIGN = register("chorus_hanging_sign", settings ->
            new HangingSignBlock(WoodTypes.CHORUS, settings), WoodTypes.createSignSettings());
        CHORUS_WALL_HANGING_SIGN = register("chorus_wall_hanging_sign", settings ->
                new WallHangingSignBlock(WoodTypes.CHORUS, settings),
            copyLootTable(CHORUS_HANGING_SIGN, true)
                .mapColor(CHORUS_LOG.getDefaultMapColor())
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.HANGING_SIGN.addSupportedBlock(CHORUS_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(CHORUS_WALL_HANGING_SIGN);
        CHORUS_FENCE = register("chorus_fence", FenceBlock::new,
            WoodTypes.createFenceSettings(CHORUS_PLANKS).sounds(BlockSoundGroup.WOOD));
        CHORUS_FENCE_GATE = register("chorus_fence_gate", settings ->
            new FenceGateBlock(WoodTypes.CHORUS, settings), WoodTypes.createFenceSettings(CHORUS_PLANKS));

        // Vacant Woodset
        VACANT_LOG = register("vacant_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
        VACANT_WOOD = register("vacant_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        STRIPPED_VACANT_LOG = register("stripped_vacant_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.OAK_TAN, BlockSoundGroup.WOOD));
        StrippableBlockRegistry.register(VACANT_LOG, STRIPPED_VACANT_LOG);
        STRIPPED_VACANT_WOOD = register("stripped_vacant_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        StrippableBlockRegistry.register(VACANT_WOOD, STRIPPED_VACANT_WOOD);
        VACANT_PLANKS = register("vacant_planks", WoodTypes.createPlanksSettings());
        VACANT_DOOR = register("vacant_door", settings ->
            new DoorBlock(BlockSetTypes.VACANT, settings), WoodTypes.createDoorSettings(VACANT_PLANKS));
        VACANT_PRESSURE_PLATE = register("vacant_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetTypes.VACANT, settings), WoodTypes.createPressurePlateSettings(VACANT_PLANKS));
        VACANT_TRAPDOOR = register("vacant_trapdoor", settings ->
            new TrapdoorBlock(BlockSetTypes.VACANT, settings), WoodTypes.createTrapdoorSettings());
        VACANT_BUTTON = register("vacant_button", settings ->
            new ButtonBlock(BlockSetTypes.VACANT, 30, settings), createButtonSettings());
        VACANT_STAIRS = registerStairsBlock("vacant_stairs", VACANT_PLANKS);
        VACANT_SLAB = register("vacant_slab", SlabBlock::new,
            WoodTypes.createPlanksSettings());
        VACANT_SIGN = register("vacant_sign", settings ->
            new SignBlock(WoodTypes.VACANT, settings), WoodTypes.createSignSettings());
        VACANT_WALL_SIGN = register("vacant_wall_sign", settings ->
                new WallSignBlock(WoodType.OAK, settings),
            copyLootTable(VACANT_SIGN, true)
                .mapColor(MapColor.OAK_TAN)
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.SIGN.addSupportedBlock(VACANT_SIGN);
        BlockEntityType.SIGN.addSupportedBlock(VACANT_WALL_SIGN);
        VACANT_HANGING_SIGN = register("vacant_hanging_sign", settings ->
            new HangingSignBlock(WoodTypes.VACANT, settings), WoodTypes.createSignSettings());
        VACANT_WALL_HANGING_SIGN = register("vacant_wall_hanging_sign", settings ->
                new WallHangingSignBlock(WoodTypes.VACANT, settings),
            copyLootTable(VACANT_HANGING_SIGN, true)
                .mapColor(VACANT_LOG.getDefaultMapColor())
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.HANGING_SIGN.addSupportedBlock(VACANT_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(VACANT_WALL_HANGING_SIGN);
        VACANT_FENCE = register("vacant_fence", FenceBlock::new,
            WoodTypes.createFenceSettings(VACANT_PLANKS).sounds(BlockSoundGroup.WOOD));
        VACANT_FENCE_GATE = register("vacant_fence_gate", settings ->
            new FenceGateBlock(WoodTypes.VACANT, settings), WoodTypes.createFenceSettings(VACANT_PLANKS));

        // Voiding Woodset
        VOIDING_LOG = register("voiding_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN, BlockSoundGroup.WOOD));
        VOIDING_WOOD = register("voiding_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        STRIPPED_VOIDING_LOG = register("stripped_voiding_log", PillarBlock::new,
            createLogSettings(MapColor.OAK_TAN, MapColor.OAK_TAN, BlockSoundGroup.WOOD));
        StrippableBlockRegistry.register(VOIDING_LOG, STRIPPED_VOIDING_LOG);
        STRIPPED_VOIDING_WOOD = register("stripped_voiding_wood", PillarBlock::new,
            WoodTypes.createWoodSettings());
        StrippableBlockRegistry.register(VOIDING_WOOD, STRIPPED_VOIDING_WOOD);
        VOIDING_PLANKS = register("voiding_planks", WoodTypes.createPlanksSettings());
        VOIDING_DOOR = register("voiding_door", settings ->
            new DoorBlock(BlockSetTypes.VOIDING, settings), WoodTypes.createDoorSettings(VOIDING_PLANKS));
        VOIDING_PRESSURE_PLATE = register("voiding_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetTypes.VOIDING, settings), WoodTypes.createPressurePlateSettings(VOIDING_PLANKS));
        VOIDING_TRAPDOOR = register("voiding_trapdoor", settings ->
            new TrapdoorBlock(BlockSetTypes.VOIDING, settings), WoodTypes.createTrapdoorSettings());
        VOIDING_BUTTON = register("voiding_button", settings ->
            new ButtonBlock(BlockSetTypes.VOIDING, 30, settings), createButtonSettings());
        VOIDING_STAIRS = registerStairsBlock("voiding_stairs", VOIDING_PLANKS);
        VOIDING_SLAB = register("voiding_slab", SlabBlock::new,
            WoodTypes.createPlanksSettings());
        VOIDING_SIGN = register("voiding_sign", settings ->
            new SignBlock(WoodTypes.VOIDING, settings), WoodTypes.createSignSettings());
        VOIDING_WALL_SIGN = register("voiding_wall_sign", settings ->
                new WallSignBlock(WoodType.OAK, settings),
            copyLootTable(VOIDING_SIGN, true)
                .mapColor(MapColor.OAK_TAN)
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.SIGN.addSupportedBlock(VOIDING_SIGN);
        BlockEntityType.SIGN.addSupportedBlock(VOIDING_WALL_SIGN);
        VOIDING_HANGING_SIGN = register("voiding_hanging_sign", settings ->
            new HangingSignBlock(WoodTypes.VOIDING, settings), WoodTypes.createSignSettings());
        VOIDING_WALL_HANGING_SIGN = register("voiding_wall_hanging_sign", settings ->
                new WallHangingSignBlock(WoodTypes.VOIDING, settings),
            copyLootTable(VOIDING_HANGING_SIGN, true)
                .mapColor(VOIDING_LOG.getDefaultMapColor())
                .solid().noCollision()
                .instrument(NoteBlockInstrument.BASS)
                .strength(1.0F).burnable());
        BlockEntityType.HANGING_SIGN.addSupportedBlock(VOIDING_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(VOIDING_WALL_HANGING_SIGN);
        VOIDING_FENCE = register("voiding_fence", FenceBlock::new,
            WoodTypes.createFenceSettings(VOIDING_PLANKS).sounds(BlockSoundGroup.WOOD));
        VOIDING_FENCE_GATE = register("voiding_fence_gate", settings ->
            new FenceGateBlock(WoodTypes.VOIDING, settings), WoodTypes.createFenceSettings(VOIDING_PLANKS));
    }

    private static Block registerStairsBlock(String id, Block base) {
        return register(id, settings ->
            new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copy(base));
    }

    private static AbstractBlock.Settings copyLootTable(Block block, boolean copyTranslationKey) {
        AbstractBlock.Settings settings = block.getSettings();
        AbstractBlock.Settings settings2 = AbstractBlock.Settings.create().lootTable(block.getLootTableKey());
        if (copyTranslationKey) {
            settings2 = settings2.overrideTranslationKey(block.getTranslationKey());
        }

        return settings2;
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
