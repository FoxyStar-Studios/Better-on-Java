package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.crops.*;
import com.xkingdark.bob.blocks.pedestal.Pedestal;
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

import static net.minecraft.block.Blocks.*;

public final class Blocks {
    public static final Block WAYSTONE;
    public static final Block BOUNTY_BOARD;
    public static final Block STARDUST_ORE;

    //Flowers
    public static final Block TALL_LAVENDER;
    public static final Block BLUEGROD;
    public static final Block LUSH_GRASS;
    public static final Block PINK_LAVENDER;
    public static final Block TALLER_GRASS;
    public static final Block LILAC_HEADS;
    public static final Block IRIS;
    public static final Block HYDRANGEA;
    public static final Block CLEMATIS;
    public static final Block BIG_SPROUT;
    public static final Block BELLFLOWER;
    public static final Block ANEMONE;
    public static final Block TINY_SPROUT;
    public static final Block WILDFLOWER;
    public static final Block PURPLE_HYDRANGEA;
    public static final Block OPEN_TALL_EYEBLOSSOM;
    public static final Block CLOSED_TALL_EYEBLOSSOM;

    //Crops
    public static final Block BARLEY_CROP;
    public static final Block BLUE_BERRY_BUSH;
    public static final Block GRAPE_BUSH;
    public static final Block CABBAGE_CROP;
    public static final Block EGGPLANT_CROP;
    public static final Block HEALTHY_CARROT_CROP;
    public static final Block ONION_CROP;
    public static final Block TOMATO_CROP;
    public static final Block WILD_CARROT;

    public static final Block PEACH_LEAVES;
    public static final Block ORANGE_LEAVES;

    public static final Block PEDESTAL;

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

    // Decorative Blocks
    public static final Block COBBLED_ANDESITE;
    public static final Block COBBLED_ANDESITE_STAIRS;
    public static final Block COBBLED_ANDESITE_SLAB;
    public static final Block COBBLED_ANDESITE_WALL;
    public static final Block ANDESITE_BRICKS;
    public static final Block ANDESITE_BRICK_STAIRS;
    public static final Block ANDESITE_BRICK_SLAB;
    public static final Block ANDESITE_BRICK_WALL;
    public static final Block CRACKED_ANDESITE_BRICKS;
    public static final Block CRACKED_ANDESITE_BRICK_STAIRS;
    public static final Block CRACKED_ANDESITE_BRICK_SLAB;
    public static final Block CRACKED_ANDESITE_BRICK_WALL;
    public static final Block MOSSY_ANDESITE_BRICKS;
    public static final Block MOSSY_ANDESITE_BRICK_STAIRS;
    public static final Block MOSSY_ANDESITE_BRICK_SLAB;
    public static final Block MOSSY_ANDESITE_BRICK_WALL;
    public static final Block CHISELED_ANDESITE;
    public static final Block CHISELED_POLISHED_ANDESITE;

    public static final Block COBBLED_DIORITE;
    public static final Block DIORITE_BRICKS;
    public static final Block CRACKED_DIORITE_BRICKS;
    public static final Block MOSSY_DIORITE_BRICKS;
    public static final Block CHISELED_POLISHED_DIORITE;

    public static final Block COBBLED_GRANITE;
    public static final Block GRANITE_BRICKS;
    public static final Block CRACKED_GRANITE_BRICKS;
    public static final Block MOSSY_GRANITE_BRICKS;
    public static final Block CHISELED_GRANITE;
    public static final Block CHISELED_POLISHED_GRANITE;

    public static final Block POLISHED_CALCITE;
    public static final Block CALCITE_BRICKS;
    public static final Block CHISELED_CALCITE_BRICKS;
    public static final Block CRACKED_CALCITE_BRICKS;
    public static final Block POLISHED_CALCITE_BRICKS;
    public static final Block CRACKED_POLISHED_CALCITE_BRICKS;

    public static final Block SLICED_TUFF;

    public static final Block CUT_RESIN;
    public static final Block SMOOTH_RESIN;
    public static final Block RESIN_LAMP;

    static {
        WAYSTONE = Blocks.register("waystone", WaystoneBlock::new,
            AbstractBlock.Settings.create().hardness(2.52f).requiresTool().nonOpaque());
        BOUNTY_BOARD = Blocks.register("bounty_board",
                AbstractBlock.Settings.create().hardness(2.52f).nonOpaque().dynamicBounds());
        PEDESTAL = Blocks.register("pedestal", Pedestal::new,
            AbstractBlock.Settings.create().hardness(2.52f).requiresTool().nonOpaque());

        STARDUST_ORE = Blocks.register("stardust_ore",
            AbstractBlock.Settings.create().hardness(2.52f).requiresTool().nonOpaque());
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
        LUSH_GRASS = Blocks.register("lush_grass", TallFlowerBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        OPEN_TALL_EYEBLOSSOM = Blocks.register("open_tall_eyeblossom", (settings) ->
                new TallEyeblossomBlock(TallEyeblossomBlock.EyeblossomState.OPEN, settings),
            AbstractBlock.Settings.create()
                .mapColor(CREAKING_HEART.getDefaultMapColor()).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .noCollision().ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        CLOSED_TALL_EYEBLOSSOM = Blocks.register("closed_tall_eyeblossom", (settings) ->
                new TallEyeblossomBlock(TallEyeblossomBlock.EyeblossomState.CLOSED, settings),
            AbstractBlock.Settings.create()
                .mapColor(CREAKING_HEART.getDefaultMapColor()).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .noCollision().ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));

        //Flowers
        PINK_LAVENDER = Blocks.register("pink_lavender", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        TALLER_GRASS = Blocks.register("taller_grass", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        LILAC_HEADS = Blocks.register("lilac_heads", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        IRIS = Blocks.register("iris", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        HYDRANGEA = Blocks.register("hydrangea", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        CLEMATIS = Blocks.register("clematis", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        BIG_SPROUT = Blocks.register("big_sprout", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        BELLFLOWER = Blocks.register("bellflower", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        ANEMONE = Blocks.register("anemone", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        TINY_SPROUT = Blocks.register("tiny_sprout", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        WILDFLOWER = Blocks.register("wildflower", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        PURPLE_HYDRANGEA = Blocks.register("purple_hydrangea", ShortPlantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XYZ)
                .replaceable()
                .noCollision().burnable()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));

        // Crops
        BARLEY_CROP = Blocks.register("barley", BarleyBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        BLUE_BERRY_BUSH = Blocks.register("blue_berry_bush", BlueBerryBushBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        GRAPE_BUSH = Blocks.register("grape_bush", GrapeBushBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        CABBAGE_CROP = Blocks.register("cabbage", CabbageBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        EGGPLANT_CROP = Blocks.register("eggplants", EggplantBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        HEALTHY_CARROT_CROP = Blocks.register("healthy_carrots", HealthyCarrotBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        ONION_CROP = Blocks.register("onions", OnionBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        TOMATO_CROP = Blocks.register("tomatoes", TomatoBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.CROP)
                .noCollision()
                .ticksRandomly()
                .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));
        WILD_CARROT = Blocks.register("wild_carrot", ShortPlantBlock::new,
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.DARK_GREEN).sounds(BlockSoundGroup.GRASS)
                        .noCollision()
                        .breakInstantly().pistonBehavior(PistonBehavior.DESTROY));

        PEACH_LEAVES = register("peach_leaves", LeavesBlock::new,
            createLeavesSettings(BlockSoundGroup.GRASS));
        ORANGE_LEAVES = register("orange_leaves", LeavesBlock::new,
            createLeavesSettings(BlockSoundGroup.GRASS));

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

        // Decorative Blocks
        COBBLED_ANDESITE = register("cobbled_andesite", AbstractBlock.Settings.copyShallow(ANDESITE));
        COBBLED_ANDESITE_STAIRS = registerStairsBlock("cobbled_andesite_stairs", COBBLED_ANDESITE);
        COBBLED_ANDESITE_SLAB = register("cobbled_andesite_slab", SlabBlock::new,
            AbstractBlock.Settings.copyShallow(COBBLED_ANDESITE));
        COBBLED_ANDESITE_WALL = register("cobbled_andesite_wall", WallBlock::new,
            AbstractBlock.Settings.copyShallow(COBBLED_ANDESITE));
        ANDESITE_BRICKS = register("andesite_bricks", AbstractBlock.Settings.copyShallow(ANDESITE));
        ANDESITE_BRICK_STAIRS = registerStairsBlock("andesite_brick_stairs", ANDESITE_BRICKS);
        ANDESITE_BRICK_SLAB = register("andesite_brick_slab", SlabBlock::new,
            AbstractBlock.Settings.copyShallow(ANDESITE_BRICKS));
        ANDESITE_BRICK_WALL = register("andesite_brick_wall", WallBlock::new,
            AbstractBlock.Settings.copyShallow(ANDESITE_BRICKS));
        CRACKED_ANDESITE_BRICKS = register("cracked_andesite_bricks", AbstractBlock.Settings.copyShallow(ANDESITE));
        CRACKED_ANDESITE_BRICK_STAIRS = registerStairsBlock("cracked_andesite_brick_stairs", CRACKED_ANDESITE_BRICKS);
        CRACKED_ANDESITE_BRICK_SLAB = register("cracked_andesite_brick_slab", SlabBlock::new,
            AbstractBlock.Settings.copyShallow(CRACKED_ANDESITE_BRICKS));
        CRACKED_ANDESITE_BRICK_WALL = register("cracked_andesite_brick_wall", WallBlock::new,
            AbstractBlock.Settings.copyShallow(CRACKED_ANDESITE_BRICKS));
        MOSSY_ANDESITE_BRICKS = register("mossy_andesite_bricks", AbstractBlock.Settings.copyShallow(ANDESITE));
        MOSSY_ANDESITE_BRICK_STAIRS = registerStairsBlock("mossy_andesite_brick_stairs", MOSSY_ANDESITE_BRICKS);
        MOSSY_ANDESITE_BRICK_SLAB = register("mossy_andesite_brick_slab", SlabBlock::new,
            AbstractBlock.Settings.copyShallow(MOSSY_ANDESITE_BRICKS));
        MOSSY_ANDESITE_BRICK_WALL = register("mossy_andesite_brick_wall", WallBlock::new,
            AbstractBlock.Settings.copyShallow(MOSSY_ANDESITE_BRICKS));
        CHISELED_ANDESITE = register("chiseled_andesite", AbstractBlock.Settings.copyShallow(ANDESITE));
        CHISELED_POLISHED_ANDESITE = register("chiseled_polished_andesite", AbstractBlock.Settings.copyShallow(ANDESITE));

        COBBLED_DIORITE = register("cobbled_diorite", AbstractBlock.Settings.copyShallow(DIORITE));
        DIORITE_BRICKS = register("diorite_bricks", AbstractBlock.Settings.copyShallow(DIORITE));
        CRACKED_DIORITE_BRICKS = register("cracked_diorite_bricks", AbstractBlock.Settings.copyShallow(DIORITE));
        MOSSY_DIORITE_BRICKS = register("mossy_diorite_bricks", AbstractBlock.Settings.copyShallow(DIORITE));
        CHISELED_POLISHED_DIORITE = register("chiseled_polished_diorite", AbstractBlock.Settings.copyShallow(DIORITE));

        COBBLED_GRANITE = register("cobbled_granite", AbstractBlock.Settings.copyShallow(GRANITE));
        GRANITE_BRICKS = register("granite_bricks", AbstractBlock.Settings.copyShallow(GRANITE));
        CRACKED_GRANITE_BRICKS = register("cracked_granite_bricks", AbstractBlock.Settings.copyShallow(GRANITE));
        MOSSY_GRANITE_BRICKS = register("mossy_granite_bricks", AbstractBlock.Settings.copyShallow(GRANITE));
        CHISELED_GRANITE = register("chiseled_granite", AbstractBlock.Settings.copyShallow(GRANITE));
        CHISELED_POLISHED_GRANITE = register("chiseled_polished_granite", AbstractBlock.Settings.copyShallow(GRANITE));

        POLISHED_CALCITE = register("polished_calcite", AbstractBlock.Settings.copyShallow(CALCITE));
        CALCITE_BRICKS = register("calcite_bricks", AbstractBlock.Settings.copyShallow(CALCITE));
        CHISELED_CALCITE_BRICKS = register("chiseled_calcite_bricks", AbstractBlock.Settings.copyShallow(CALCITE));
        CRACKED_CALCITE_BRICKS = register("cracked_calcite_bricks", AbstractBlock.Settings.copyShallow(CALCITE));
        POLISHED_CALCITE_BRICKS = register("polished_calcite_bricks", AbstractBlock.Settings.copyShallow(CALCITE));
        CRACKED_POLISHED_CALCITE_BRICKS = register("cracked_polished_calcite_bricks", AbstractBlock.Settings.copyShallow(CALCITE));

        SLICED_TUFF = register("sliced_tuff", AbstractBlock.Settings.copyShallow(TUFF));

        CUT_RESIN = register("cut_resin", AbstractBlock.Settings.copyShallow(RESIN_BLOCK));
        SMOOTH_RESIN = register("smooth_resin", AbstractBlock.Settings.copyShallow(RESIN_BLOCK));
        RESIN_LAMP = register("resin_lamp", LampBlock::new,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.TERRACOTTA_ORANGE)
                .luminance(createLightLevelFromLitBlockState(15))
                .strength(0.3F)
                .sounds(BlockSoundGroup.GLASS)
                .allowsSpawning(net.minecraft.block.Blocks::always));
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
