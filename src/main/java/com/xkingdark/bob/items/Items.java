package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.blocks.jukebox.JukeboxSongs;
import com.xkingdark.bob.entities.EntityTypes;
import com.xkingdark.bob.items.components.FoodComponents;
import com.xkingdark.bob.items.equipment.ArmorMaterials;
import com.xkingdark.bob.items.tools.ToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Items {
    public static final Item WAYSTONE;

    public static final Item BANE_SPIKE;
    public static final Item BLADE_OF_THE_NETHER;

    public static final Item COPPER_HELMET;
    public static final Item COPPER_CHESTPLATE;
    public static final Item COPPER_LEGGINGS;
    public static final Item COPPER_BOOTS;
    public static final Item COPPER_SWORD;
    public static final Item COPPER_AXE;
    public static final Item COPPER_PICKAXE;
    public static final Item COPPER_SHOVEL;
    public static final Item COPPER_HOE;

    public static final Item AMETHYST_HELMET;
    public static final Item AMETHYST_CHESTPLATE;
    public static final Item AMETHYST_LEGGINGS;
    public static final Item AMETHYST_BOOTS;
    public static final Item AMETHYST_SWORD;
    public static final Item AMETHYST_AXE;
    public static final Item AMETHYST_PICKAXE;
    public static final Item AMETHYST_SHOVEL;
    public static final Item AMETHYST_HOE;

    public static final Item SHULKER_HELMET;
    public static final Item SHULKER_CHESTPLATE;
    public static final Item SHULKER_LEGGINGS;
    public static final Item SHULKER_BOOTS;

    public static final Item CORSTINITE_HELMET;
    public static final Item CORSTINITE_CHESTPLATE;
    public static final Item CORSTINITE_LEGGINGS;
    public static final Item CORSTINITE_BOOTS;

    public static final Item STARDUST_HELMET;
    public static final Item STARDUST_CHESTPLATE;
    public static final Item STARDUST_LEGGINGS;
    public static final Item STARDUST_BOOTS;
    public static final Item STARDUST_SWORD;
    public static final Item STARDUST_AXE;
    public static final Item STARDUST_PICKAXE;
    public static final Item STARDUST_SHOVEL;
    public static final Item STARDUST_HOE;

    public static final Item STARDUST_UPGRADE;
    public static final Item STARDUST_INGOT;
    public static final Item STARDUST;
    public static final Item STARDUST_NUGGET;

    public static final Item MUTTON_CHOPS_RAW;
    public static final Item MUTTON_CHOPS_COOKED;
    public static final Item BAGUETTE;
    public static final Item BAKED_EGGPLANT;
    public static final Item BAKED_ONION;
    public static final Item BARLEY_STEW;
    public static final Item SWEET_BERRY_PIE;
    public static final Item SWEET_BERRY_PIE_SLICE;
    public static final Item CABBAGE_LEAF;
    public static final Item EGGPLANT;
    public static final Item GRAPE;
    public static final Item BLUE_BERRY;
    public static final Item HEALTHY_CARROT;
    public static final Item ONION;
    public static final Item OPENED_COCONUT;
    public static final Item ORANGE;
    public static final Item PEACH;
    public static final Item SALAD;
    public static final Item TOMATO;
    public static final Item WILD_CARROT;
    public static final Item FUNGUS_STEW;
    public static final Item SANDWICH;
    public static final Item RAW_DEER_MEAT;
    public static final Item COOKED_DEER_MEAT;
    public static final Item COOKED_BEEF_PATTY;
    public static final Item RAW_BEEF_PATTY;
    public static final Item LAVA_STEW;
    public static final Item BURGER;
    public static final Item FRIED_EGG;
    public static final Item GRAPE_PIE;
    public static final Item GRAPE_PIE_SLICE;
    public static final Item EGG_SANDWICH;
    public static final Item END_BERRY;
    public static final Item VOIDBERRY_PIE;
    public static final Item END_COOKIE;
    public static final Item ENDER_STEW;
    public static final Item COCONUT;

    public static final Item CABBAGE_CROP;

    public static final Item MUSIC_DISC_FOX;
    public static final Item MUSIC_DISC_STARDUST;
    public static final Item MUSIC_DISC_STELLAR_CRYSTALS;
    public static final Item MUSIC_DISC_TRAVELERS;
    public static final Item BROKEN_STELLAR_CRYSTALS;

    public static final Item STARDUST_ORE;

    public static final Item PINK_LAVENDER;
    public static final Item TALL_LAVENDER;
    public static final Item BLUEGROD;
    public static final Item TALLER_GRASS;

    public static final Item CHORUS_LOG;
    public static final Item CHORUS_WOOD;
    public static final Item STRIPPED_CHORUS_LOG;
    public static final Item STRIPPED_CHORUS_WOOD;
    public static final Item CHORUS_PLANKS;
    public static final Item CHORUS_DOOR;
    public static final Item CHORUS_PRESSURE_PLATE;
    public static final Item CHORUS_TRAPDOOR;
    public static final Item CHORUS_BUTTON;
    public static final Item CHORUS_STAIRS;
    public static final Item CHORUS_SLAB;
    public static final Item CHORUS_SIGN;
    public static final Item CHORUS_HANGING_SIGN;
    public static final Item CHORUS_FENCE;
    public static final Item CHORUS_FENCE_GATE;
    public static final Item CHORUS_BOAT;
    public static final Item CHORUS_CHEST_BOAT;

    public static final Item VACANT_LOG;
    public static final Item VACANT_WOOD;
    public static final Item STRIPPED_VACANT_LOG;
    public static final Item STRIPPED_VACANT_WOOD;
    public static final Item VACANT_PLANKS;
    public static final Item VACANT_DOOR;
    public static final Item VACANT_PRESSURE_PLATE;
    public static final Item VACANT_TRAPDOOR;
    public static final Item VACANT_BUTTON;
    public static final Item VACANT_STAIRS;
    public static final Item VACANT_SLAB;
    public static final Item VACANT_SIGN;
    public static final Item VACANT_HANGING_SIGN;
    public static final Item VACANT_FENCE;
    public static final Item VACANT_FENCE_GATE;
    public static final Item VACANT_BOAT;
    public static final Item VACANT_CHEST_BOAT;

    public static final Item VOIDING_LOG;
    public static final Item VOIDING_WOOD;
    public static final Item STRIPPED_VOIDING_LOG;
    public static final Item STRIPPED_VOIDING_WOOD;
    public static final Item VOIDING_PLANKS;
    public static final Item VOIDING_DOOR;
    public static final Item VOIDING_PRESSURE_PLATE;
    public static final Item VOIDING_TRAPDOOR;
    public static final Item VOIDING_BUTTON;
    public static final Item VOIDING_STAIRS;
    public static final Item VOIDING_SLAB;
    public static final Item VOIDING_SIGN;
    public static final Item VOIDING_HANGING_SIGN;
    public static final Item VOIDING_FENCE;
    public static final Item VOIDING_FENCE_GATE;
    public static final Item VOIDING_BOAT;
    public static final Item VOIDING_CHEST_BOAT;

    static {
        WAYSTONE = register(Blocks.WAYSTONE);

        BANE_SPIKE = register("bane_spike", BaneSpikeItem::new);
        BLADE_OF_THE_NETHER = register("blade_of_the_nether", BladeOfTheNetherItem::new);

        COPPER_HELMET = register("copper_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.COPPER, EquipmentType.HELMET, settings));
        COPPER_CHESTPLATE = register("copper_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.COPPER, EquipmentType.CHESTPLATE, settings));
        COPPER_LEGGINGS = register("copper_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.COPPER, EquipmentType.LEGGINGS, settings));
        COPPER_BOOTS = register("copper_boots", (settings) ->
            new ArmorItem(ArmorMaterials.COPPER, EquipmentType.BOOTS, settings));
        COPPER_SWORD = register("copper_sword", (settings) ->
                new SwordItem(ToolMaterials.COPPER, 2.0F, -2.4F, settings),
            (new Item.Settings()).fireproof());
        COPPER_AXE = register("copper_axe", (settings) ->
                new AxeItem(ToolMaterials.COPPER, 6.0F, -3.1F, settings),
            (new Item.Settings()).fireproof());
        COPPER_PICKAXE = register("copper_pickaxe", (settings) ->
                new PickaxeItem(ToolMaterials.COPPER, 0.5F, -2.8F, settings),
            (new Item.Settings()));
        COPPER_SHOVEL = register("copper_shovel", (settings) ->
                new ShovelItem(ToolMaterials.COPPER, 1.0F, -3.0F, settings),
            (new Item.Settings()).fireproof());
        COPPER_HOE = register("copper_hoe", (settings) ->
                new HoeItem(ToolMaterials.COPPER, -2.0F, -2.0F, settings),
            (new Item.Settings()).fireproof());

        AMETHYST_HELMET = register("amethyst_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.AMETHYST, EquipmentType.HELMET, settings));
        AMETHYST_CHESTPLATE = register("amethyst_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.AMETHYST, EquipmentType.CHESTPLATE, settings));
        AMETHYST_LEGGINGS = register("amethyst_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.AMETHYST, EquipmentType.LEGGINGS, settings));
        AMETHYST_BOOTS = register("amethyst_boots", (settings) ->
            new ArmorItem(ArmorMaterials.AMETHYST, EquipmentType.BOOTS, settings));
        AMETHYST_SWORD = register("amethyst_sword", (settings) ->
                new SwordItem(ToolMaterials.AMETHYST, 3.0F, -2.4F, settings),
            (new Item.Settings()).fireproof());
        AMETHYST_AXE = register("amethyst_axe", (settings) ->
                new AxeItem(ToolMaterials.AMETHYST, 6.0F, -3.1F, settings),
            (new Item.Settings()).fireproof());
        AMETHYST_PICKAXE = register("amethyst_pickaxe", (settings) ->
                new PickaxeItem(ToolMaterials.AMETHYST, 1.0F, -2.8F, settings),
            (new Item.Settings()));
        AMETHYST_SHOVEL = register("amethyst_shovel", (settings) ->
                new ShovelItem(ToolMaterials.AMETHYST, 1.5F, -3.0F, settings),
            (new Item.Settings()).fireproof());
        AMETHYST_HOE = register("amethyst_hoe", (settings) ->
                new HoeItem(ToolMaterials.AMETHYST, -2.0F, -1.0F, settings),
            (new Item.Settings()).fireproof());

        SHULKER_HELMET = register("shulker_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.SHULKER, EquipmentType.HELMET, settings));
        SHULKER_CHESTPLATE = register("shulker_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.SHULKER, EquipmentType.CHESTPLATE, settings));
        SHULKER_LEGGINGS = register("shulker_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.SHULKER, EquipmentType.LEGGINGS, settings));
        SHULKER_BOOTS = register("shulker_boots", (settings) ->
            new ArmorItem(ArmorMaterials.SHULKER, EquipmentType.BOOTS, settings));

        CORSTINITE_HELMET = register("corstinite_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.HELMET, settings));
        CORSTINITE_CHESTPLATE = register("corstinite_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.CHESTPLATE, settings));
        CORSTINITE_LEGGINGS = register("corstinite_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.LEGGINGS, settings));
        CORSTINITE_BOOTS = register("corstinite_boots", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.BOOTS, settings));

        STARDUST_HELMET = register("stardust_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.STARDUST, EquipmentType.HELMET, settings));
        STARDUST_CHESTPLATE = register("stardust_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.STARDUST, EquipmentType.CHESTPLATE, settings));
        STARDUST_LEGGINGS = register("stardust_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.STARDUST, EquipmentType.LEGGINGS, settings));
        STARDUST_BOOTS = register("stardust_boots", (settings) ->
            new ArmorItem(ArmorMaterials.STARDUST, EquipmentType.BOOTS, settings));
        STARDUST_SWORD = register("stardust_sword", (settings) ->
                new SwordItem(ToolMaterials.STARDUST, 3.0F, -2.4F, settings),
            (new Item.Settings()).fireproof());
        STARDUST_AXE = register("stardust_axe", (settings) ->
                new AxeItem(ToolMaterials.STARDUST, 5.0F, -3.0F, settings),
            (new Item.Settings()).fireproof());
        STARDUST_PICKAXE = register("stardust_pickaxe", (settings) ->
                new PickaxeItem(ToolMaterials.STARDUST, 1.0F, -2.8F, settings),
            (new Item.Settings()));
        STARDUST_SHOVEL = register("stardust_shovel", (settings) ->
                new ShovelItem(ToolMaterials.STARDUST, 1.5F, -3.0F, settings),
            (new Item.Settings()).fireproof());
        STARDUST_HOE = register("stardust_hoe", (settings) ->
                new HoeItem(ToolMaterials.STARDUST, -4.0F, 0.0F, settings),
            (new Item.Settings()).fireproof());

        STARDUST_UPGRADE = register("stardust_upgrade_smithing_template", (settings) ->
            SmithingTemplates.createUpgrade("stardust", settings), new Item.Settings().rarity(Rarity.RARE));
        STARDUST_INGOT = register("stardust_ingot");
        STARDUST = register("stardust");
        STARDUST_NUGGET = register("stardust_nugget");

        MUTTON_CHOPS_RAW = register("mutton_chops_raw", new Item.Settings().food(FoodComponents.MUTTON_CHOPS_RAW));
        MUTTON_CHOPS_COOKED = register("mutton_chops_cooked", new Item.Settings().food(FoodComponents.MUTTON_CHOPS_COOKED));
        BAGUETTE = register("baguette", new Item.Settings().food(FoodComponents.BAGUETTE));
        BAKED_EGGPLANT = register("baked_eggplant", new Item.Settings().food(FoodComponents.BAKED_EGGPLANT));
        BAKED_ONION = register("baked_onion", new Item.Settings().food(FoodComponents.BAKED_ONION));
        BARLEY_STEW = register("barley_stew", new Item.Settings().food(FoodComponents.BARLEY_STEW));
        SWEET_BERRY_PIE = register("sweet_berry_pie", new Item.Settings().food(FoodComponents.SWEET_BERRY_PIE));
        SWEET_BERRY_PIE_SLICE = register("sweet_berry_pie_slice", new Item.Settings().food(FoodComponents.SWEET_BERRY_PIE_SLICE));
        CABBAGE_LEAF = register("cabbage_leaf", new Item.Settings().food(FoodComponents.CABBAGE_LEAF));
        EGGPLANT = register("eggplant", new Item.Settings().food(FoodComponents.EGGPLANT));
        GRAPE = register("grape", new Item.Settings().food(FoodComponents.GRAPE));
        BLUE_BERRY = register("blue_berry", new Item.Settings().food(FoodComponents.BLUE_BERRY));
        HEALTHY_CARROT = register("healthy_carrot", new Item.Settings().food(FoodComponents.HEALTHY_CARROT));
        ONION = register("onion", new Item.Settings().food(FoodComponents.ONION));
        OPENED_COCONUT = register("opened_coconut", new Item.Settings().food(FoodComponents.OPENED_COCONUT));
        ORANGE = register("orange", new Item.Settings().food(FoodComponents.ORANGE));
        PEACH = register("peach", new Item.Settings().food(FoodComponents.PEACH));
        SALAD = register("salad", new Item.Settings().food(FoodComponents.SALAD));
        TOMATO = register("tomato", new Item.Settings().food(FoodComponents.TOMATO));
        WILD_CARROT = register("wild_carrot", new Item.Settings().food(FoodComponents.WILD_CARROT));
        FUNGUS_STEW = register("fungus_stew", new Item.Settings().food(FoodComponents.FUNGUS_STEW));
        LAVA_STEW = register("lava_stew", new Item.Settings().food(FoodComponents.LAVA_STEW));
        SANDWICH = register("sandwich", new Item.Settings().food(FoodComponents.SANDWICH));
        RAW_DEER_MEAT = register("raw_deer_meat", new Item.Settings().food(FoodComponents.RAW_DEER_MEAT));
        COOKED_DEER_MEAT = register("cooked_deer_meat", new Item.Settings().food(FoodComponents.COOKED_DEER_MEAT));
        RAW_BEEF_PATTY = register("raw_beef_patty", new Item.Settings().food(FoodComponents.RAW_BEEF_PATTY));
        COOKED_BEEF_PATTY = register("cooked_beef_patty", new Item.Settings().food(FoodComponents.COOKED_BEEF_PATTY));
        BURGER = register("burger", new Item.Settings().food(FoodComponents.BURGER));
        FRIED_EGG = register("fried_egg", new Item.Settings().food(FoodComponents.FRIED_EGG));
        GRAPE_PIE = register("grape_pie", new Item.Settings().food(FoodComponents.GRAPE_PIE));
        GRAPE_PIE_SLICE = register("grape_pie_slice", new Item.Settings().food(FoodComponents.GRAPE_PIE_SLICE));
        EGG_SANDWICH = register("egg_sandwich", new Item.Settings().food(FoodComponents.EGG_SANDWICH));
        END_BERRY = register("end_berry", new Item.Settings().food(FoodComponents.END_BERRY));
        END_COOKIE = register("end_cookie", new Item.Settings().food(FoodComponents.END_COOKIE));
        VOIDBERRY_PIE = register("voidberry_pie", new Item.Settings().food(FoodComponents.VOIDBERRY_PIE));
        ENDER_STEW = register("ender_stew", new Item.Settings().food(FoodComponents.ENDER_STEW));
        COCONUT = register("coconut");
        
        CABBAGE_CROP = register(Blocks.CABBAGE_CROP);

        MUSIC_DISC_FOX = register("music_disc_fox",
            new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(JukeboxSongs.FOX));
        MUSIC_DISC_STARDUST = register("music_disc_stardust",
            new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(JukeboxSongs.STARDUST));
        MUSIC_DISC_STELLAR_CRYSTALS = register("music_disc_stellar_crystals",
            new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(JukeboxSongs.STELLAR_CRYSTALS));
        MUSIC_DISC_TRAVELERS = register("music_disc_travelers",
            new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(JukeboxSongs.TRAVELERS));
        BROKEN_STELLAR_CRYSTALS = register("broken_stellar_crystals", ItemDescription::new,
            new Item.Settings().maxCount(1).rarity(Rarity.RARE));

        STARDUST_ORE = register(Blocks.STARDUST_ORE);

        PINK_LAVENDER = register(Blocks.PINK_LAVENDER);
        TALL_LAVENDER = register(Blocks.TALL_LAVENDER);
        BLUEGROD = register(Blocks.BLUEGROD);
        TALLER_GRASS = register(Blocks.TALLER_GRASS);

        // Chorus Woodset
        CHORUS_LOG = register(Blocks.CHORUS_LOG);
        CHORUS_WOOD = register(Blocks.CHORUS_WOOD);
        STRIPPED_CHORUS_LOG = register(Blocks.STRIPPED_CHORUS_LOG);
        STRIPPED_CHORUS_WOOD = register(Blocks.STRIPPED_CHORUS_WOOD);
        CHORUS_PLANKS = register(Blocks.CHORUS_PLANKS);
        CHORUS_DOOR = register(Blocks.CHORUS_DOOR);
        CHORUS_PRESSURE_PLATE = register(Blocks.CHORUS_PRESSURE_PLATE);
        CHORUS_TRAPDOOR = register(Blocks.CHORUS_TRAPDOOR);
        CHORUS_BUTTON = register(Blocks.CHORUS_BUTTON);
        CHORUS_STAIRS = register(Blocks.CHORUS_STAIRS);
        CHORUS_SLAB = register(Blocks.CHORUS_SLAB);
        CHORUS_SIGN = register(Blocks.CHORUS_SIGN, (block, settings) ->
            new SignItem(block, Blocks.CHORUS_WALL_SIGN, settings), new Item.Settings().maxCount(16));
        CHORUS_HANGING_SIGN = register(Blocks.CHORUS_HANGING_SIGN, (block, settings) ->
            new HangingSignItem(block, Blocks.CHORUS_WALL_HANGING_SIGN, settings), new Item.Settings().maxCount(16));
        CHORUS_FENCE = register(Blocks.CHORUS_FENCE);
        CHORUS_FENCE_GATE = register(Blocks.CHORUS_FENCE_GATE);
        CHORUS_BOAT = register("chorus_boat", settings ->
            new BoatItem(EntityTypes.CHORUS_BOAT, settings), new Item.Settings().maxCount(1));
        CHORUS_CHEST_BOAT = register("chorus_chest_boat", settings ->
            new BoatItem(EntityTypes.CHORUS_CHEST_BOAT, settings), new Item.Settings().maxCount(1));

        // Vacant Woodset
        VACANT_LOG = register(Blocks.VACANT_LOG);
        VACANT_WOOD = register(Blocks.VACANT_WOOD);
        STRIPPED_VACANT_LOG = register(Blocks.STRIPPED_VACANT_LOG);
        STRIPPED_VACANT_WOOD = register(Blocks.STRIPPED_VACANT_WOOD);
        VACANT_PLANKS = register(Blocks.VACANT_PLANKS);
        VACANT_DOOR = register(Blocks.VACANT_DOOR);
        VACANT_PRESSURE_PLATE = register(Blocks.VACANT_PRESSURE_PLATE);
        VACANT_TRAPDOOR = register(Blocks.VACANT_TRAPDOOR);
        VACANT_BUTTON = register(Blocks.VACANT_BUTTON);
        VACANT_STAIRS = register(Blocks.VACANT_STAIRS);
        VACANT_SLAB = register(Blocks.VACANT_SLAB);
        VACANT_SIGN = register(Blocks.VACANT_SIGN, (block, settings) ->
            new SignItem(block, Blocks.VACANT_WALL_SIGN, settings), new Item.Settings().maxCount(16));
        VACANT_HANGING_SIGN = register(Blocks.VACANT_HANGING_SIGN, (block, settings) ->
            new HangingSignItem(block, Blocks.VACANT_WALL_HANGING_SIGN, settings), new Item.Settings().maxCount(16));
        VACANT_FENCE = register(Blocks.VACANT_FENCE);
        VACANT_FENCE_GATE = register(Blocks.VACANT_FENCE_GATE);
        VACANT_BOAT = register("vacant_boat", settings ->
            new BoatItem(EntityTypes.VACANT_BOAT, settings), new Item.Settings().maxCount(1));
        VACANT_CHEST_BOAT = register("vacant_chest_boat", settings ->
            new BoatItem(EntityTypes.VACANT_CHEST_BOAT, settings), new Item.Settings().maxCount(1));

        // Voiding Woodset
        VOIDING_LOG = register(Blocks.VOIDING_LOG);
        VOIDING_WOOD = register(Blocks.VOIDING_WOOD);
        STRIPPED_VOIDING_LOG = register(Blocks.STRIPPED_VOIDING_LOG);
        STRIPPED_VOIDING_WOOD = register(Blocks.STRIPPED_VOIDING_WOOD);
        VOIDING_PLANKS = register(Blocks.VOIDING_PLANKS);
        VOIDING_DOOR = register(Blocks.VOIDING_DOOR);
        VOIDING_PRESSURE_PLATE = register(Blocks.VOIDING_PRESSURE_PLATE);
        VOIDING_TRAPDOOR = register(Blocks.VOIDING_TRAPDOOR);
        VOIDING_BUTTON = register(Blocks.VOIDING_BUTTON);
        VOIDING_STAIRS = register(Blocks.VOIDING_STAIRS);
        VOIDING_SLAB = register(Blocks.VOIDING_SLAB);
        VOIDING_SIGN = register(Blocks.VOIDING_SIGN, (block, settings) ->
            new SignItem(block, Blocks.VOIDING_WALL_SIGN, settings), new Item.Settings().maxCount(16));
        VOIDING_HANGING_SIGN = register(Blocks.VOIDING_HANGING_SIGN, (block, settings) ->
            new HangingSignItem(block, Blocks.VOIDING_WALL_HANGING_SIGN, settings), new Item.Settings().maxCount(16));
        VOIDING_FENCE = register(Blocks.VOIDING_FENCE);
        VOIDING_FENCE_GATE = register(Blocks.VOIDING_FENCE_GATE);
        VOIDING_BOAT = register("voiding_boat", settings ->
            new BoatItem(EntityTypes.VOIDING_BOAT, settings), new Item.Settings().maxCount(1));
        VOIDING_CHEST_BOAT = register("voiding_chest_boat", settings ->
            new BoatItem(EntityTypes.VOIDING_CHEST_BOAT, settings), new Item.Settings().maxCount(1));
    }


    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return (settings) -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, id));
    }

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    public static Item register(Block block) {
        return register(block, BlockItem::new);
    }

    public static Item register(Block block, Item.Settings settings) {
        return register(block, BlockItem::new, settings);
    }

    public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
        return register(block, (blockx, settings) ->
            new BlockItem(blockx, (Item.Settings)settingsOperator.apply(settings)));
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return register(block, factory, new Item.Settings());
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(block.getRegistryEntry().registryKey()), (itemSettings) ->
            factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey());
    }

    public static Item register(String id, Function<Item.Settings, Item> factory) {
        return register(keyOf(id), factory, new Item.Settings());
    }

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(id), factory, settings);
    }

    public static Item register(String id, Item.Settings settings) {
        return register(keyOf(id), Item::new, settings);
    }

    public static Item register(String id) {
        return register(keyOf(id), Item::new, new Item.Settings());
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory) {
        return register(key, factory, new Item.Settings());
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem)
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);

        return Registry.register(Registries.ITEM, key, item);
    }
}
