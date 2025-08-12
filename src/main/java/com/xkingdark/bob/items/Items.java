package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.blocks.jukebox.JukeboxSongs;
import com.xkingdark.bob.blocks.DecoratedPotPatterns;
import com.xkingdark.bob.entities.EntityTypes;
import com.xkingdark.bob.items.components.FoodComponents;
import com.xkingdark.bob.items.equipment.ArmorMaterials;
import com.xkingdark.bob.items.tools.ToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
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
    public static final Item GUIDE_BOOK;
    public static final Item BOUNTY_BOARD;
    public static final Item PEDESTAL;

    public static final Item BANE_SPIKE;
    public static final Item BLADE_OF_THE_NETHER;
    public static final Item WOODEN_SPEAR;
    public static final Item STONE_SPEAR;
    public static final Item GOLDEN_SPEAR;
    public static final Item AMETHYST_SPEAR;
    public static final Item IRON_SPEAR;
    public static final Item DIAMOND_SPEAR;
    public static final Item STARDUST_SPEAR;

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

    // Food
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
    public static final Item GRAPES;
    public static final Item BLUE_BERRIES;
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

    // Crops
    public static final Item BARLEY;
    public static final Item BARLEY_SEEDS;
    public static final Item CABBAGE_SEEDS;
    public static final Item EGGPLANT_SEEDS;

    public static final Item PEACH_LEAVES;
    public static final Item ORANGE_LEAVES;


    public static final Item BLANK_POTTERY_SHERD;
    public static final Item PARTY_POTTERY_SHERD;
    public static final Item FORGER_POTTERY_SHERD;
    public static final Item PIGLIN_POTTERY_SHERD;

    public static final Item MUSIC_DISC_FOX;
    public static final Item MUSIC_DISC_STARDUST;
    public static final Item MUSIC_DISC_STELLAR_CRYSTALS;
    public static final Item MUSIC_DISC_TRAVELERS;
    public static final Item BROKEN_STELLAR_CRYSTALS;

    public static final Item STARDUST_ORE;

    public static final Item TALL_LAVENDER;
    public static final Item BLUEGROD;
    public static final Item LUSH_GRASS;
    public static final Item OPEN_TALL_EYEBLOSSOM;
    public static final Item CLOSED_TALL_EYEBLOSSOM;

    //Flowers
    public static final Item PINK_LAVENDER;
    public static final Item TALLER_GRASS;
    public static final Item LILAC_HEADS;
    public static final Item IRIS;
    public static final Item HYDRANGEA;
    public static final Item CLEMATIS;
    public static final Item TINY_SPROUT;
    public static final Item BIG_SPROUT;
    public static final Item BELLFLOWER;
    public static final Item ANEMONE;
    public static final Item WILDFLOWER;
    public static final Item PURPLE_HYDRANGEA;

    // Chorus Woodset
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

    // Vacant Woodset
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

    // Voiding Woodset
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

    // Decorative Blocks
    public static final Item COBBLED_ANDESITE;
    public static final Item COBBLED_ANDESITE_STAIRS;
    public static final Item COBBLED_ANDESITE_SLAB;
    public static final Item COBBLED_ANDESITE_WALL;
    public static final Item ANDESITE_BRICKS;
    public static final Item ANDESITE_BRICK_STAIRS;
    public static final Item ANDESITE_BRICK_SLAB;
    public static final Item ANDESITE_BRICK_WALL;
    public static final Item CRACKED_ANDESITE_BRICKS;
    public static final Item CRACKED_ANDESITE_BRICK_STAIRS;
    public static final Item CRACKED_ANDESITE_BRICK_SLAB;
    public static final Item CRACKED_ANDESITE_BRICK_WALL;
    public static final Item MOSSY_ANDESITE_BRICKS;
    public static final Item MOSSY_ANDESITE_BRICK_STAIRS;
    public static final Item MOSSY_ANDESITE_BRICK_SLAB;
    public static final Item MOSSY_ANDESITE_BRICK_WALL;
    public static final Item CHISELED_ANDESITE;
    public static final Item CHISELED_POLISHED_ANDESITE;

    public static final Item COBBLED_DIORITE;
    public static final Item DIORITE_BRICKS;
    public static final Item CRACKED_DIORITE_BRICKS;
    public static final Item MOSSY_DIORITE_BRICKS;
    public static final Item CHISELED_POLISHED_DIORITE;
    public static final Item COBBLED_DIORITE_SLAB;
    public static final Item COBBLED_DIORITE_STAIRS;
    public static final Item COBBLED_DIORITE_WALL;
    public static final Item DIORITE_BRICK_SLAB;
    public static final Item DIORITE_BRICK_STAIRS;
    public static final Item DIORITE_BRICK_WALL;
    public static final Item CRACKED_DIORITE_BRICK_SLAB;
    public static final Item CRACKED_DIORITE_BRICK_STAIRS;
    public static final Item CRACKED_DIORITE_BRICK_WALL;
    public static final Item MOSSY_DIORITE_BRICK_SLAB;
    public static final Item MOSSY_DIORITE_BRICK_STAIRS;
    public static final Item MOSSY_DIORITE_BRICK_WALL;

    public static final Item COBBLED_GRANITE;
    public static final Item GRANITE_BRICKS;
    public static final Item CRACKED_GRANITE_BRICKS;
    public static final Item MOSSY_GRANITE_BRICKS;
    public static final Item CHISELED_GRANITE;
    public static final Item CHISELED_POLISHED_GRANITE;
    public static final Item COBBLED_GRANITE_SLAB;
    public static final Item COBBLED_GRANITE_STAIRS;
    public static final Item COBBLED_GRANITE_WALL;
    public static final Item GRANITE_BRICK_SLAB;
    public static final Item GRANITE_BRICK_STAIRS;
    public static final Item GRANITE_BRICK_WALL;
    public static final Item CRACKED_GRANITE_BRICK_SLAB;
    public static final Item CRACKED_GRANITE_BRICK_STAIRS;
    public static final Item CRACKED_GRANITE_BRICK_WALL;
    public static final Item MOSSY_GRANITE_BRICK_SLAB;
    public static final Item MOSSY_GRANITE_BRICK_STAIRS;
    public static final Item MOSSY_GRANITE_BRICK_WALL;


    public static final Item POLISHED_CALCITE;
    public static final Item CALCITE_BRICKS;
    public static final Item CHISELED_CALCITE_BRICKS;
    public static final Item CRACKED_CALCITE_BRICKS;
    public static final Item POLISHED_CALCITE_BRICKS;
    public static final Item CRACKED_POLISHED_CALCITE_BRICKS;
    public static final Item POLISHED_CALCITE_SLAB;
    public static final Item POLISHED_CALCITE_STAIRS;
    public static final Item POLISHED_CALCITE_WALL;
    public static final Item CALCITE_BRICK_SLAB;
    public static final Item CALCITE_BRICK_STAIRS;
    public static final Item CALCITE_BRICK_WALL;
    public static final Item CRACKED_CALCITE_BRICK_SLAB;
    public static final Item CRACKED_CALCITE_BRICK_STAIRS;
    public static final Item CRACKED_CALCITE_BRICK_WALL;
    public static final Item CRACKED_POLISHED_CALCITE_BRICK_SLAB;
    public static final Item CRACKED_POLISHED_CALCITE_BRICK_STAIRS;
    public static final Item CRACKED_POLISHED_CALCITE_BRICK_WALL;
    public static final Item POLISHED_CALCITE_BRICK_SLAB;
    public static final Item POLISHED_CALCITE_BRICK_STAIRS;
    public static final Item POLISHED_CALCITE_BRICK_WALL;

    public static final Item SLICED_TUFF;
    public static final Item SLICED_TUFF_SLAB;
    public static final Item SLICED_TUFF_STAIRS;
    public static final Item SLICED_TUFF_WALL;

    public static final Item CUT_RESIN;
    public static final Item SMOOTH_RESIN;
    public static final Item RESIN_LAMP;

    static {
        WAYSTONE = register(Blocks.WAYSTONE);
        GUIDE_BOOK = register("guide_book");
        BOUNTY_BOARD = register(Blocks.BOUNTY_BOARD);
        PEDESTAL = register(Blocks.PEDESTAL);

        BANE_SPIKE = register("bane_spike", BaneSpikeItem::new);
        BLADE_OF_THE_NETHER = register("blade_of_the_nether", BladeOfTheNetherItem::new);
        WOODEN_SPEAR = register("wooden_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(60)
                .attributeModifiers(SpearItem.createAttributeModifiers(4))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        STONE_SPEAR = register("stone_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(132)
                .attributeModifiers(SpearItem.createAttributeModifiers(5))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        GOLDEN_SPEAR = register("golden_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(33)
                .attributeModifiers(SpearItem.createAttributeModifiers(7))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        AMETHYST_SPEAR = register("amethyst_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(125)
                .attributeModifiers(SpearItem.createAttributeModifiers(6))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        IRON_SPEAR = register("iron_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(251)
                .attributeModifiers(SpearItem.createAttributeModifiers(6))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        DIAMOND_SPEAR = register("diamond_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(1562)
                .attributeModifiers(SpearItem.createAttributeModifiers(8))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));
        STARDUST_SPEAR = register("stardust_spear", SpearItem::new,
            new Item.Settings()
                .maxDamage(2531)
                .attributeModifiers(SpearItem.createAttributeModifiers(9))
                .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                .enchantable(1));

        COPPER_HELMET = register("copper_helmet", (new Item.Settings())
            .armor(ArmorMaterials.COPPER, EquipmentType.HELMET));
        COPPER_CHESTPLATE = register("copper_chestplate", (new Item.Settings())
            .armor(ArmorMaterials.COPPER, EquipmentType.CHESTPLATE));
        COPPER_LEGGINGS = register("copper_leggings", (new Item.Settings())
            .armor(ArmorMaterials.COPPER, EquipmentType.LEGGINGS));
        COPPER_BOOTS = register("copper_boots", (new Item.Settings())
            .armor(ArmorMaterials.COPPER, EquipmentType.BOOTS));
        COPPER_SWORD = register("copper_sword", (new Item.Settings())
            .sword(ToolMaterials.COPPER, 2.0F, -2.4F));
        COPPER_AXE = register("copper_axe", (new Item.Settings())
            .axe(ToolMaterials.COPPER, 6.0F, -3.1F));
        COPPER_PICKAXE = register("copper_pickaxe", (new Item.Settings())
            .pickaxe(ToolMaterials.COPPER, 0.5F, -2.8F));
        COPPER_SHOVEL = register("copper_shovel", (new Item.Settings())
            .shovel(ToolMaterials.COPPER, 1.0F, -3.0F));
        COPPER_HOE = register("copper_hoe", (new Item.Settings())
            .hoe(ToolMaterials.COPPER, -2.0F, -2.0F));

        AMETHYST_HELMET = register("amethyst_helmet", (new Item.Settings())
            .armor(ArmorMaterials.AMETHYST, EquipmentType.HELMET));
        AMETHYST_CHESTPLATE = register("amethyst_chestplate", (new Item.Settings())
            .armor(ArmorMaterials.AMETHYST, EquipmentType.CHESTPLATE));
        AMETHYST_LEGGINGS = register("amethyst_leggings", (new Item.Settings())
            .armor(ArmorMaterials.AMETHYST, EquipmentType.LEGGINGS));
        AMETHYST_BOOTS = register("amethyst_boots", (new Item.Settings())
            .armor(ArmorMaterials.AMETHYST, EquipmentType.BOOTS));
        AMETHYST_SWORD = register("amethyst_sword", (new Item.Settings())
            .sword(ToolMaterials.AMETHYST, 3.0F, -2.4F));
        AMETHYST_AXE = register("amethyst_axe", (new Item.Settings())
            .axe(ToolMaterials.AMETHYST, 6.0F, -3.1F));
        AMETHYST_PICKAXE = register("amethyst_pickaxe", (new Item.Settings())
            .pickaxe(ToolMaterials.AMETHYST, 1.0F, -2.8F));
        AMETHYST_SHOVEL = register("amethyst_shovel", (new Item.Settings())
            .shovel(ToolMaterials.AMETHYST, 1.5F, -3.0F));
        AMETHYST_HOE = register("amethyst_hoe", (new Item.Settings())
            .hoe(ToolMaterials.AMETHYST, -2.0F, -1.0F));

        SHULKER_HELMET = register("shulker_helmet", (new Item.Settings())
            .armor(ArmorMaterials.SHULKER, EquipmentType.HELMET));
        SHULKER_CHESTPLATE = register("shulker_chestplate", (new Item.Settings())
            .armor(ArmorMaterials.SHULKER, EquipmentType.CHESTPLATE));
        SHULKER_LEGGINGS = register("shulker_leggings", (new Item.Settings())
            .armor(ArmorMaterials.SHULKER, EquipmentType.LEGGINGS));
        SHULKER_BOOTS = register("shulker_boots", (new Item.Settings())
            .armor(ArmorMaterials.SHULKER, EquipmentType.BOOTS));

        CORSTINITE_HELMET = register("corstinite_helmet", (new Item.Settings())
            .armor(ArmorMaterials.CORSTINITE, EquipmentType.HELMET).fireproof());
        CORSTINITE_CHESTPLATE = register("corstinite_chestplate", (new Item.Settings())
            .armor(ArmorMaterials.CORSTINITE, EquipmentType.CHESTPLATE).fireproof());
        CORSTINITE_LEGGINGS = register("corstinite_leggings", (new Item.Settings())
            .armor(ArmorMaterials.CORSTINITE, EquipmentType.LEGGINGS).fireproof());
        CORSTINITE_BOOTS = register("corstinite_boots", (new Item.Settings())
            .armor(ArmorMaterials.CORSTINITE, EquipmentType.BOOTS).fireproof());

        STARDUST_HELMET = register("stardust_helmet", (new Item.Settings())
            .armor(ArmorMaterials.STARDUST, EquipmentType.HELMET).fireproof());
        STARDUST_CHESTPLATE = register("stardust_chestplate", (new Item.Settings())
            .armor(ArmorMaterials.STARDUST, EquipmentType.CHESTPLATE).fireproof());
        STARDUST_LEGGINGS = register("stardust_leggings", (new Item.Settings())
            .armor(ArmorMaterials.STARDUST, EquipmentType.LEGGINGS).fireproof());
        STARDUST_BOOTS = register("stardust_boots", (new Item.Settings())
            .armor(ArmorMaterials.STARDUST, EquipmentType.BOOTS).fireproof());
        STARDUST_SWORD = register("stardust_sword", (new Item.Settings())
            .sword(ToolMaterials.STARDUST, 3.0F, -2.4F));
        STARDUST_AXE = register("stardust_axe", (new Item.Settings())
            .axe(ToolMaterials.STARDUST, 5.0F, -3.0F).fireproof());
        STARDUST_PICKAXE = register("stardust_pickaxe", (new Item.Settings())
            .pickaxe(ToolMaterials.STARDUST, 1.0F, -2.8F).fireproof());
        STARDUST_SHOVEL = register("stardust_shovel", (new Item.Settings())
            .shovel(ToolMaterials.STARDUST, 1.5F, -3.0F).fireproof());
        STARDUST_HOE = register("stardust_hoe", (new Item.Settings())
            .hoe(ToolMaterials.STARDUST, -4.0F, 0.0F).fireproof());

        STARDUST_UPGRADE = register("stardust_upgrade_smithing_template", (settings) ->
            SmithingTemplates.createUpgrade("stardust", settings), new Item.Settings().rarity(Rarity.RARE));
        STARDUST_INGOT = register("stardust_ingot");
        STARDUST = register("stardust");
        STARDUST_NUGGET = register("stardust_nugget");

        // Food
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
        GRAPES = register("grapes", createBlockItemWithUniqueName(Blocks.GRAPE_BUSH),
            new Item.Settings().food(FoodComponents.GRAPES));
        BLUE_BERRIES = register("blue_berries", createBlockItemWithUniqueName(Blocks.BLUE_BERRY_BUSH),
            new Item.Settings().food(FoodComponents.BLUE_BERRIES));
        HEALTHY_CARROT = register("healthy_carrot",
            new Item.Settings().food(FoodComponents.HEALTHY_CARROT));
        ONION = register("onion", createBlockItemWithUniqueName(Blocks.ONION_CROP),
            new Item.Settings().food(FoodComponents.ONION));
        OPENED_COCONUT = register("opened_coconut", new Item.Settings().food(FoodComponents.OPENED_COCONUT));
        ORANGE = register("orange", new Item.Settings().food(FoodComponents.ORANGE));
        PEACH = register("peach", new Item.Settings().food(FoodComponents.PEACH));
        SALAD = register("salad", new Item.Settings().food(FoodComponents.SALAD));
        TOMATO = register("tomato", createBlockItemWithUniqueName(Blocks.TOMATO_CROP),
            new Item.Settings().food(FoodComponents.TOMATO));
        WILD_CARROT = register("wild_carrot", createBlockItemWithUniqueName(Blocks.HEALTHY_CARROT_CROP),
            new Item.Settings().food(FoodComponents.WILD_CARROT));
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

        // Crops
        BARLEY = register("barley");
        BARLEY_SEEDS = register("barley_seeds", createBlockItemWithUniqueName(Blocks.BARLEY_CROP));
        CABBAGE_SEEDS = register("cabbage_seeds", createBlockItemWithUniqueName(Blocks.CABBAGE_CROP));
        EGGPLANT_SEEDS = register("eggplant_seeds", createBlockItemWithUniqueName(Blocks.EGGPLANT_CROP));

        PEACH_LEAVES = register(Blocks.PEACH_LEAVES);
        ORANGE_LEAVES = register(Blocks.ORANGE_LEAVES);

        BLANK_POTTERY_SHERD = register("blank_pottery_sherd", new Item.Settings().rarity(Rarity.UNCOMMON));
        PARTY_POTTERY_SHERD = register("party_pottery_sherd", new Item.Settings().rarity(Rarity.UNCOMMON));
        FORGER_POTTERY_SHERD = register("forger_pottery_sherd", new Item.Settings().rarity(Rarity.UNCOMMON));
        PIGLIN_POTTERY_SHERD = register("piglin_pottery_sherd", new Item.Settings().rarity(Rarity.UNCOMMON));

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

        //Flowers
        TALL_LAVENDER = register(Blocks.TALL_LAVENDER);
        BLUEGROD = register(Blocks.BLUEGROD);
        LUSH_GRASS = register(Blocks.LUSH_GRASS);
        OPEN_TALL_EYEBLOSSOM = register(Blocks.OPEN_TALL_EYEBLOSSOM);
        CLOSED_TALL_EYEBLOSSOM = register(Blocks.CLOSED_TALL_EYEBLOSSOM);
        PINK_LAVENDER = register(Blocks.PINK_LAVENDER);
        TALLER_GRASS = register(Blocks.TALLER_GRASS);
        LILAC_HEADS = register(Blocks.LILAC_HEADS);
        IRIS = register(Blocks.IRIS);
        HYDRANGEA = register(Blocks.HYDRANGEA);
        CLEMATIS = register(Blocks.CLEMATIS);
        TINY_SPROUT = register(Blocks.TINY_SPROUT);
        BIG_SPROUT = register(Blocks.BIG_SPROUT);
        BELLFLOWER = register(Blocks.BELLFLOWER);
        ANEMONE = register(Blocks.ANEMONE);
        WILDFLOWER = register(Blocks.WILDFLOWER);
        PURPLE_HYDRANGEA = register(Blocks.PURPLE_HYDRANGEA);

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

        // Decorative Blocks
        COBBLED_ANDESITE = register(Blocks.COBBLED_ANDESITE);
        COBBLED_ANDESITE_STAIRS = register(Blocks.COBBLED_ANDESITE_STAIRS);
        COBBLED_ANDESITE_SLAB = register(Blocks.COBBLED_ANDESITE_SLAB);
        COBBLED_ANDESITE_WALL = register(Blocks.COBBLED_ANDESITE_WALL);
        ANDESITE_BRICKS = register(Blocks.ANDESITE_BRICKS);
        ANDESITE_BRICK_STAIRS = register(Blocks.ANDESITE_BRICK_STAIRS);
        ANDESITE_BRICK_SLAB = register(Blocks.ANDESITE_BRICK_SLAB);
        ANDESITE_BRICK_WALL = register(Blocks.ANDESITE_BRICK_WALL);
        CRACKED_ANDESITE_BRICKS = register(Blocks.CRACKED_ANDESITE_BRICKS);
        CRACKED_ANDESITE_BRICK_STAIRS = register(Blocks.CRACKED_ANDESITE_BRICK_STAIRS);
        CRACKED_ANDESITE_BRICK_SLAB = register(Blocks.CRACKED_ANDESITE_BRICK_SLAB);
        CRACKED_ANDESITE_BRICK_WALL = register(Blocks.CRACKED_ANDESITE_BRICK_WALL);
        MOSSY_ANDESITE_BRICKS = register(Blocks.MOSSY_ANDESITE_BRICKS);
        MOSSY_ANDESITE_BRICK_STAIRS = register(Blocks.MOSSY_ANDESITE_BRICK_STAIRS);
        MOSSY_ANDESITE_BRICK_SLAB = register(Blocks.MOSSY_ANDESITE_BRICK_SLAB);
        MOSSY_ANDESITE_BRICK_WALL = register(Blocks.MOSSY_ANDESITE_BRICK_WALL);
        CHISELED_ANDESITE = register(Blocks.CHISELED_ANDESITE);
        CHISELED_POLISHED_ANDESITE = register(Blocks.CHISELED_POLISHED_ANDESITE);

        COBBLED_DIORITE = register(Blocks.COBBLED_DIORITE);
        DIORITE_BRICKS = register(Blocks.DIORITE_BRICKS);
        CRACKED_DIORITE_BRICKS = register(Blocks.CRACKED_DIORITE_BRICKS);
        MOSSY_DIORITE_BRICKS = register(Blocks.MOSSY_DIORITE_BRICKS);
        CHISELED_POLISHED_DIORITE = register(Blocks.CHISELED_POLISHED_DIORITE);
        COBBLED_DIORITE_SLAB = register(Blocks.COBBLED_DIORITE_SLAB);
        COBBLED_DIORITE_STAIRS = register(Blocks.COBBLED_DIORITE_STAIRS);
        COBBLED_DIORITE_WALL = register(Blocks.COBBLED_DIORITE_WALL);
        DIORITE_BRICK_SLAB = register(Blocks.DIORITE_BRICK_SLAB);
        DIORITE_BRICK_STAIRS = register(Blocks.DIORITE_BRICK_STAIRS);
        DIORITE_BRICK_WALL = register(Blocks.DIORITE_BRICK_WALL);
        CRACKED_DIORITE_BRICK_SLAB = register(Blocks.CRACKED_DIORITE_BRICK_SLAB);
        CRACKED_DIORITE_BRICK_STAIRS = register(Blocks.CRACKED_DIORITE_BRICK_STAIRS);
        CRACKED_DIORITE_BRICK_WALL = register(Blocks.CRACKED_DIORITE_BRICK_WALL);
        MOSSY_DIORITE_BRICK_SLAB = register(Blocks.MOSSY_DIORITE_BRICK_SLAB);
        MOSSY_DIORITE_BRICK_STAIRS = register(Blocks.MOSSY_DIORITE_BRICK_STAIRS);
        MOSSY_DIORITE_BRICK_WALL = register(Blocks.MOSSY_DIORITE_BRICK_WALL);


        COBBLED_GRANITE = register(Blocks.COBBLED_GRANITE);
        GRANITE_BRICKS = register(Blocks.GRANITE_BRICKS);
        CRACKED_GRANITE_BRICKS = register(Blocks.CRACKED_GRANITE_BRICKS);
        MOSSY_GRANITE_BRICKS = register(Blocks.MOSSY_GRANITE_BRICKS);
        CHISELED_GRANITE = register(Blocks.CHISELED_GRANITE);
        CHISELED_POLISHED_GRANITE = register(Blocks.CHISELED_POLISHED_GRANITE);
        COBBLED_GRANITE_SLAB = register(Blocks.COBBLED_GRANITE_SLAB);
        COBBLED_GRANITE_STAIRS = register(Blocks.COBBLED_GRANITE_STAIRS);
        COBBLED_GRANITE_WALL = register(Blocks.COBBLED_GRANITE_WALL);
        GRANITE_BRICK_SLAB = register(Blocks.GRANITE_BRICK_SLAB);
        GRANITE_BRICK_STAIRS = register(Blocks.GRANITE_BRICK_STAIRS);
        GRANITE_BRICK_WALL = register(Blocks.GRANITE_BRICK_WALL);
        CRACKED_GRANITE_BRICK_SLAB = register(Blocks.CRACKED_GRANITE_BRICK_SLAB);
        CRACKED_GRANITE_BRICK_STAIRS = register(Blocks.CRACKED_GRANITE_BRICK_STAIRS);
        CRACKED_GRANITE_BRICK_WALL = register(Blocks.CRACKED_GRANITE_BRICK_WALL);
        MOSSY_GRANITE_BRICK_SLAB = register(Blocks.MOSSY_GRANITE_BRICK_SLAB);
        MOSSY_GRANITE_BRICK_STAIRS = register(Blocks.MOSSY_GRANITE_BRICK_STAIRS);
        MOSSY_GRANITE_BRICK_WALL = register(Blocks.MOSSY_GRANITE_BRICK_WALL);

        POLISHED_CALCITE = register(Blocks.POLISHED_CALCITE);
        CALCITE_BRICKS = register(Blocks.CALCITE_BRICKS);
        CHISELED_CALCITE_BRICKS = register(Blocks.CHISELED_CALCITE_BRICKS);
        CRACKED_CALCITE_BRICKS = register(Blocks.CRACKED_CALCITE_BRICKS);
        POLISHED_CALCITE_BRICKS = register(Blocks.POLISHED_CALCITE_BRICKS);
        CRACKED_POLISHED_CALCITE_BRICKS = register(Blocks.CRACKED_POLISHED_CALCITE_BRICKS);
        POLISHED_CALCITE_SLAB = register(Blocks.POLISHED_CALCITE_SLAB);
        POLISHED_CALCITE_STAIRS = register(Blocks.POLISHED_CALCITE_STAIRS);
        POLISHED_CALCITE_WALL = register(Blocks.POLISHED_CALCITE_WALL);
        CALCITE_BRICK_SLAB = register(Blocks.CALCITE_BRICK_SLAB);
        CALCITE_BRICK_STAIRS = register(Blocks.CALCITE_BRICK_STAIRS);
        CALCITE_BRICK_WALL = register(Blocks.CALCITE_BRICK_WALL);
        CRACKED_CALCITE_BRICK_SLAB = register(Blocks.CRACKED_CALCITE_BRICK_SLAB);
        CRACKED_CALCITE_BRICK_STAIRS = register(Blocks.CRACKED_CALCITE_BRICK_STAIRS);
        CRACKED_CALCITE_BRICK_WALL = register(Blocks.CRACKED_CALCITE_BRICK_WALL);
        CRACKED_POLISHED_CALCITE_BRICK_SLAB = register(Blocks.CRACKED_POLISHED_CALCITE_BRICK_SLAB);
        CRACKED_POLISHED_CALCITE_BRICK_STAIRS = register(Blocks.CRACKED_POLISHED_CALCITE_BRICK_STAIRS);
        CRACKED_POLISHED_CALCITE_BRICK_WALL = register(Blocks.CRACKED_POLISHED_CALCITE_BRICK_WALL);
        POLISHED_CALCITE_BRICK_SLAB = register(Blocks.POLISHED_CALCITE_BRICK_SLAB);
        POLISHED_CALCITE_BRICK_STAIRS = register(Blocks.POLISHED_CALCITE_BRICK_STAIRS);
        POLISHED_CALCITE_BRICK_WALL = register(Blocks.POLISHED_CALCITE_BRICK_WALL);


        SLICED_TUFF = register(Blocks.SLICED_TUFF);
        SLICED_TUFF_SLAB = register(Blocks.SLICED_TUFF_SLAB);
        SLICED_TUFF_STAIRS = register(Blocks.SLICED_TUFF_STAIRS);
        SLICED_TUFF_WALL = register(Blocks.SLICED_TUFF_WALL);

        CUT_RESIN = register(Blocks.CUT_RESIN);
        SMOOTH_RESIN = register(Blocks.SMOOTH_RESIN);
        RESIN_LAMP = register(Blocks.RESIN_LAMP);

        DecoratedPotPatterns.register();
    };


    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return (settings) -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    };

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, id));
    };

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    };

    public static Item register(Block block) {
        return register(block, BlockItem::new);
    };

    public static Item register(Block block, Item.Settings settings) {
        return register(block, BlockItem::new, settings);
    };

    public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
        return register(block, (blockx, settings) ->
            new BlockItem(blockx, settingsOperator.apply(settings)));
    };

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return register(block, factory, new Item.Settings());
    };

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(block.getRegistryEntry().registryKey()), (itemSettings) ->
            factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey());
    };

    public static Item register(String id, Function<Item.Settings, Item> factory) {
        return register(keyOf(id), factory, new Item.Settings());
    };

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return register(keyOf(id), factory, settings);
    };

    public static Item register(String id, Item.Settings settings) {
        return register(keyOf(id), Item::new, settings);
    };

    public static Item register(String id) {
        return register(keyOf(id), Item::new, new Item.Settings());
    };

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory) {
        return register(key, factory, new Item.Settings());
    };

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem)
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);

        return Registry.register(Registries.ITEM, key, item);
    };
};