package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import com.xkingdark.bob.items.components.FoodComponents;
import com.xkingdark.bob.items.equipment.ArmorMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Items {
    public static final Item WAYSTONE = register(Blocks.WAYSTONE);
    public static final Item CORSTINITE_HELMET = register("corstinite_helmet", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.HELMET, settings));
    public static final Item CORSTINITE_CHESTPLATE = register("corstinite_chestplate", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.CHESTPLATE, settings));
    public static final Item CORSTINITE_LEGGINGS = register("corstinite_leggings", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.LEGGINGS, settings));
    public static final Item CORSTINITE_BOOTS = register("corstinite_boots", (settings) ->
            new ArmorItem(ArmorMaterials.CORSTINITE, EquipmentType.BOOTS, settings));
    public static final Item MUTTON_CHOPS_RAW = register("mutton_chops_raw", new Item.Settings().food(FoodComponents.MUTTON_CHOPS_RAW));
    public static final Item MUTTON_CHOPS_COOKED = register("mutton_chops_cooked", new Item.Settings().food(FoodComponents.MUTTON_CHOPS_COOKED));

    public Items() {}

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
                (Item)factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey());
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
        Item item = (Item)factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item) Registry.register(Registries.ITEM, key, item);
    }
}
