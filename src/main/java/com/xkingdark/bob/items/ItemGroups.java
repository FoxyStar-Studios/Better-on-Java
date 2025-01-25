package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.stream.IntStream;

public class ItemGroups {
    public static final RegistryKey<ItemGroup> BUILDING = keyOf("building");
    public static final RegistryKey<ItemGroup> NATURAL = keyOf("natural");
    public static final RegistryKey<ItemGroup> TOOLS = keyOf("tools");
    public static final RegistryKey<ItemGroup> COMBAT = keyOf("combat");
    public static final RegistryKey<ItemGroup> UPGRADES = keyOf("upgrades");
    public static final RegistryKey<ItemGroup> FOOD = keyOf("food");

    private static RegistryKey<ItemGroup> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Main.MOD_ID, id));
    }

    static {
        // Top
        Registry.register(Registries.ITEM_GROUP, BUILDING, ItemGroup.create(ItemGroup.Row.TOP, 0)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.building"))
            .icon(() -> new ItemStack(net.minecraft.item.Items.STONE))
            .entries((displayContext, entries) -> {
                entries.add(net.minecraft.item.Items.STONE);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, NATURAL, ItemGroup.create(ItemGroup.Row.TOP, 1)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.natural"))
            .icon(() -> new ItemStack(Items.PINK_LAVENDER))
            .entries((displayContext, entries) -> {
                entries.add(Items.PINK_LAVENDER);
                entries.add(Items.TALL_LAVENDER);
                entries.add(Items.BLUEGROD);
                entries.add(Items.TALLER_GRASS);
                entries.add(Items.STARDUST_ORE);
            }).build()
        );

        // Bottom
        Registry.register(Registries.ITEM_GROUP, TOOLS, ItemGroup.create(ItemGroup.Row.BOTTOM, 0)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.tools"))
            .icon(() -> new ItemStack(Items.WAYSTONE))
            .entries((displayContext, entries) -> {
                entries.add(Items.WAYSTONE);
                entries.add(Items.STARDUST_AXE);
                entries.add(Items.STARDUST_PICKAXE);
                entries.add(Items.STARDUST_SHOVEL);
                entries.add(Items.STARDUST_HOE);

                entries.add(Items.COPPER_AXE);
                entries.add(Items.COPPER_PICKAXE);
                entries.add(Items.COPPER_SHOVEL);
                entries.add(Items.COPPER_HOE);


                entries.add(Items.MUSIC_DISC_FOX);
                entries.add(Items.MUSIC_DISC_STARDUST);
                entries.add(Items.MUSIC_DISC_TRAVELERS);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, COMBAT, ItemGroup.create(ItemGroup.Row.BOTTOM, 1)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.combat"))
            .icon(() -> new ItemStack(Items.CORSTINITE_CHESTPLATE))
            .entries((displayContext, entries) -> {
                entries.add(Items.CORSTINITE_HELMET);
                entries.add(Items.CORSTINITE_CHESTPLATE);
                entries.add(Items.CORSTINITE_LEGGINGS);
                entries.add(Items.CORSTINITE_BOOTS);

                entries.add(Items.STARDUST_HELMET);
                entries.add(Items.STARDUST_CHESTPLATE);
                entries.add(Items.STARDUST_LEGGINGS);
                entries.add(Items.STARDUST_BOOTS);
                entries.add(Items.STARDUST_SWORD);
                entries.add(Items.STARDUST_AXE);

                entries.add(Items.COPPER_HELMET);
                entries.add(Items.COPPER_CHESTPLATE);
                entries.add(Items.COPPER_LEGGINGS);
                entries.add(Items.COPPER_BOOTS);
                entries.add(Items.COPPER_SWORD);
                entries.add(Items.COPPER_AXE);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, FOOD, ItemGroup.create(ItemGroup.Row.BOTTOM, 2)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.food"))
            .icon(() -> new ItemStack(Items.BAGUETTE))
            .entries((displayContext, entries) -> {
                entries.add(Items.BAGUETTE);
                entries.add(Items.BAKED_EGGPLANT);
                entries.add(Items.BAKED_ONION);
                entries.add(Items.BARLEY_STEW);
                entries.add(Items.BLUE_BERRY);
                entries.add(Items.BURGER);
                entries.add(Items.CABBAGE_LEAF);
                entries.add(Items.COCONUT);
                entries.add(Items.COOKED_BEEF_PATTY);
                entries.add(Items.COOKED_DEER_MEAT);
                entries.add(Items.EGGPLANT);
                entries.add(Items.EGG_SANDWICH);
                entries.add(Items.END_BERRY);
                entries.add(Items.END_COOKIE);
                entries.add(Items.ENDER_STEW);
                entries.add(Items.FRIED_EGG);
                entries.add(Items.FUNGUS_STEW);
                entries.add(Items.GRAPE);
                entries.add(Items.HEALTHY_CARROT);
                entries.add(Items.LAVA_STEW);
                entries.add(Items.MUTTON_CHOPS_RAW); 
                entries.add(Items.MUTTON_CHOPS_COOKED);
                entries.add(Items.ONION);
                entries.add(Items.OPENED_COCONUT);
                entries.add(Items.PEACH);
                entries.add(Items.RAW_BEEF_PATTY);
                entries.add(Items.RAW_DEER_MEAT);
                entries.add(Items.SALAD);
                entries.add(Items.SANDWICH);
                entries.add(Items.SWEET_BERRY_PIE);
                entries.add(Items.SWEET_BERRY_PIE_SLICE);
                entries.add(Items.TOMATO);
                entries.add(Items.VOIDBERRY_PIE);
                entries.add(Items.WILD_CARROT);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, UPGRADES, ItemGroup.create(ItemGroup.Row.BOTTOM, 3)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.upgrades"))
            .icon(() -> new ItemStack(Items.STARDUST_UPGRADE))
            .entries((displayContext, entries) -> {
                entries.add(Items.STARDUST_NUGGET);
                entries.add(Items.STARDUST);
                entries.add(Items.STARDUST_INGOT);
                entries.add(Items.STARDUST_UPGRADE);

                displayContext.lookup().getOptional(RegistryKeys.ENCHANTMENT).ifPresent(registryWrapper -> {
					addMaxLevelEnchantedBooks(entries, registryWrapper, ItemGroup.StackVisibility.PARENT_TAB_ONLY);
					addAllLevelEnchantedBooks(entries, registryWrapper, ItemGroup.StackVisibility.SEARCH_TAB_ONLY);
				});
            }).build()
        );
    }

    private static void addMaxLevelEnchantedBooks(
        ItemGroup.Entries entries,
        RegistryWrapper<Enchantment> registryWrapper,
        ItemGroup.StackVisibility stackVisibility
    ) {
        registryWrapper.streamEntries()
            .filter(entry -> {
                Identifier identifier = Identifier.tryParse(entry.getIdAsString());
                if (identifier == null)
                    return false;

                return identifier.getNamespace().equals(Main.MOD_ID);
            })
            .map(
                enchantmentEntry -> EnchantmentHelper.getEnchantedBookWith(
                    new EnchantmentLevelEntry(enchantmentEntry, ((Enchantment)enchantmentEntry.value()).getMaxLevel())
                )
            )
            .forEach(stack -> entries.add(stack, stackVisibility));
    }

    private static void addAllLevelEnchantedBooks(
        ItemGroup.Entries entries,
        RegistryWrapper<Enchantment> registryWrapper,
        ItemGroup.StackVisibility stackVisibility
    ) {
        registryWrapper.streamEntries()
            .filter(entry -> {
                Identifier identifier = Identifier.tryParse(entry.getIdAsString());
                if (identifier == null)
                    return false;

                return identifier.getNamespace().equals(Main.MOD_ID);
            })
            .flatMap(
                enchantmentEntry -> IntStream.rangeClosed(((Enchantment)enchantmentEntry.value()).getMinLevel(), ((Enchantment)enchantmentEntry.value()).getMaxLevel())
                    .mapToObj(level -> EnchantmentHelper.getEnchantedBookWith(new EnchantmentLevelEntry(enchantmentEntry, level)))
            )
            .forEach(stack -> entries.add(stack, stackVisibility));
    }
}