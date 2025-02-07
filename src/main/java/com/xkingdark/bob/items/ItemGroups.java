package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.stream.IntStream;

public class ItemGroups {
    public static final RegistryKey<ItemGroup> BUILDING = keyOf("building");
    public static final RegistryKey<ItemGroup> NATURAL = keyOf("natural");
    public static final RegistryKey<ItemGroup> FUNCTIONAL = keyOf("functional");
    public static final RegistryKey<ItemGroup> TOOLS = keyOf("tools");
    public static final RegistryKey<ItemGroup> COMBAT = keyOf("combat");
    public static final RegistryKey<ItemGroup> UPGRADES = keyOf("upgrades");
    public static final RegistryKey<ItemGroup> FOOD = keyOf("food");

    private static RegistryKey<ItemGroup> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Main.MOD_ID, id));
    }

    static {
        // Top
        Registry.register(Registries.ITEM_GROUP, BUILDING, new ItemGroup.Builder(ItemGroup.Row.TOP, 0)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.building"))
            .icon(() -> new ItemStack(Items.VACANT_LOG))
            .entries((displayContext, entries) -> {
                entries.add(Items.CHORUS_LOG);
                entries.add(Items.CHORUS_WOOD);
                entries.add(Items.STRIPPED_CHORUS_LOG);
                entries.add(Items.STRIPPED_CHORUS_WOOD);
                entries.add(Items.CHORUS_PLANKS);
                entries.add(Items.CHORUS_STAIRS);
                entries.add(Items.CHORUS_SLAB);
                entries.add(Items.CHORUS_FENCE);
                entries.add(Items.CHORUS_FENCE_GATE);
                entries.add(Items.CHORUS_DOOR);
                entries.add(Items.CHORUS_TRAPDOOR);
                entries.add(Items.CHORUS_PRESSURE_PLATE);
                entries.add(Items.CHORUS_BUTTON);

                entries.add(Items.VACANT_LOG);
                entries.add(Items.VACANT_WOOD);
                entries.add(Items.STRIPPED_VACANT_LOG);
                entries.add(Items.STRIPPED_VACANT_WOOD);
                entries.add(Items.VACANT_PLANKS);
                entries.add(Items.VACANT_STAIRS);
                entries.add(Items.VACANT_SLAB);
                entries.add(Items.VACANT_FENCE);
                entries.add(Items.VACANT_FENCE_GATE);
                entries.add(Items.VACANT_DOOR);
                entries.add(Items.VACANT_TRAPDOOR);
                entries.add(Items.VACANT_PRESSURE_PLATE);
                entries.add(Items.VACANT_BUTTON);

                entries.add(Items.VOIDING_LOG);
                entries.add(Items.VOIDING_WOOD);
                entries.add(Items.STRIPPED_VOIDING_LOG);
                entries.add(Items.STRIPPED_VOIDING_WOOD);
                entries.add(Items.VOIDING_PLANKS);
                entries.add(Items.VOIDING_STAIRS);
                entries.add(Items.VOIDING_SLAB);
                entries.add(Items.VOIDING_FENCE);
                entries.add(Items.VOIDING_FENCE_GATE);
                entries.add(Items.VOIDING_DOOR);
                entries.add(Items.VOIDING_TRAPDOOR);
                entries.add(Items.VOIDING_PRESSURE_PLATE);
                entries.add(Items.VOIDING_BUTTON);

                entries.add(Items.COBBLED_GRANITE);
                entries.add(Items.GRANITE_BRICKS);
                entries.add(Items.CRACKED_GRANITE_BRICKS);
                entries.add(Items.CHISELED_GRANITE);
                entries.add(Items.MOSSY_GRANITE_BRICKS);
                entries.add(Items.CHISELED_POLISHED_GRANITE);

                entries.add(Items.COBBLED_DIORITE);
                entries.add(Items.DIORITE_BRICKS);
                entries.add(Items.CRACKED_DIORITE_BRICKS);
                entries.add(Items.MOSSY_DIORITE_BRICKS);
                entries.add(Items.CHISELED_POLISHED_DIORITE);

                entries.add(Items.COBBLED_ANDESITE);
                entries.add(Items.COBBLED_ANDESITE_STAIRS);
                entries.add(Items.COBBLED_ANDESITE_SLAB);
                entries.add(Items.COBBLED_ANDESITE_WALL);
                entries.add(Items.ANDESITE_BRICKS);
                entries.add(Items.ANDESITE_BRICK_STAIRS);
                entries.add(Items.ANDESITE_BRICK_SLAB);
                entries.add(Items.ANDESITE_BRICK_WALL);
                entries.add(Items.CRACKED_ANDESITE_BRICKS);
                entries.add(Items.CRACKED_ANDESITE_BRICK_STAIRS);
                entries.add(Items.CRACKED_ANDESITE_BRICK_SLAB);
                entries.add(Items.CRACKED_ANDESITE_BRICK_WALL);
                entries.add(Items.MOSSY_ANDESITE_BRICKS);
                entries.add(Items.MOSSY_ANDESITE_BRICK_STAIRS);
                entries.add(Items.MOSSY_ANDESITE_BRICK_SLAB);
                entries.add(Items.MOSSY_ANDESITE_BRICK_WALL);
                entries.add(Items.CHISELED_ANDESITE);
                entries.add(Items.CHISELED_POLISHED_ANDESITE);

                entries.add(Items.POLISHED_CALCITE);
                entries.add(Items.CALCITE_BRICKS);
                entries.add(Items.CHISELED_CALCITE_BRICKS);
                entries.add(Items.CRACKED_CALCITE_BRICKS);
                entries.add(Items.POLISHED_CALCITE_BRICKS);
                entries.add(Items.CRACKED_POLISHED_CALCITE_BRICKS);

                entries.add(Items.SLICED_TUFF);

                entries.add(Items.CUT_RESIN);
                entries.add(Items.SMOOTH_RESIN);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, NATURAL, new ItemGroup.Builder(ItemGroup.Row.TOP, 1)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.natural"))
            .icon(() -> new ItemStack(Items.PINK_LAVENDER))
            .entries((displayContext, entries) -> {
                entries.add(Items.STARDUST_ORE);

                entries.add(Items.PEACH_LEAVES);
                entries.add(Items.ORANGE_LEAVES);
                entries.add(Items.LUSH_GRASS);
                entries.add(Items.TALLER_GRASS);

                entries.add(Items.TALL_LAVENDER);
                entries.add(Items.BLUEGROD);
                entries.add(Items.CLOSED_TALL_EYEBLOSSOM);
                entries.add(Items.OPEN_TALL_EYEBLOSSOM);

                entries.add(Items.PINK_LAVENDER);
                entries.add(Items.LILAC_HEADS);
                entries.add(Items.IRIS);
                entries.add(Items.HYDRANGEA);
                entries.add(Items.CLEMATIS);
                entries.add(Items.BIG_SPROUT);
                entries.add(Items.BELLFLOWER);
                entries.add(Items.ANEMONE);
                entries.add(Items.TINY_SPROUT);
                entries.add(Items.WILDFLOWER);
                entries.add(Items.PURPLE_HYDRANGEA);



                entries.add(Items.BARLEY_SEEDS);
                entries.add(Items.CABBAGE_SEEDS);
                entries.add(Items.EGGPLANT_SEEDS);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, FUNCTIONAL, new ItemGroup.Builder(ItemGroup.Row.TOP, 2)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.functional"))
            .icon(() -> new ItemStack(Items.WAYSTONE))
            .entries((displayContext, entries) -> {
                entries.add(Items.RESIN_LAMP);

                entries.add(Items.WAYSTONE);
                entries.add(Items.PEDESTAL);

                entries.add(Items.CHORUS_SIGN);
                entries.add(Items.CHORUS_HANGING_SIGN);
                entries.add(Items.VACANT_SIGN);
                entries.add(Items.VACANT_HANGING_SIGN);
                entries.add(Items.VOIDING_SIGN);
                entries.add(Items.VOIDING_HANGING_SIGN);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, FOOD, new ItemGroup.Builder(ItemGroup.Row.TOP, 3)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.food"))
            .icon(() -> new ItemStack(Items.SWEET_BERRY_PIE_SLICE))
            .entries((displayContext, entries) -> {
                entries.add(Items.EGGPLANT);
                entries.add(Items.BAKED_EGGPLANT);
                entries.add(Items.ONION);
                entries.add(Items.BAKED_ONION);
                entries.add(Items.TOMATO);
                entries.add(Items.CABBAGE_LEAF);
                entries.add(Items.HEALTHY_CARROT);
                entries.add(Items.WILD_CARROT);

                entries.add(Items.RAW_DEER_MEAT);
                entries.add(Items.COOKED_DEER_MEAT);
                entries.add(Items.RAW_BEEF_PATTY);
                entries.add(Items.COOKED_BEEF_PATTY);
                entries.add(Items.MUTTON_CHOPS_RAW);
                entries.add(Items.MUTTON_CHOPS_COOKED);

                entries.add(Items.BAGUETTE);
                entries.add(Items.SANDWICH);
                entries.add(Items.FRIED_EGG);
                entries.add(Items.EGG_SANDWICH);
                entries.add(Items.BURGER);

                entries.add(Items.SALAD);
                entries.add(Items.BARLEY_STEW);
                entries.add(Items.ENDER_STEW);
                entries.add(Items.FUNGUS_STEW);
                entries.add(Items.LAVA_STEW);

                entries.add(Items.PEACH);
                entries.add(Items.BLUE_BERRIES);
                entries.add(Items.GRAPES);
                entries.add(Items.COCONUT);
                entries.add(Items.OPENED_COCONUT);
                entries.add(Items.END_BERRY);
                entries.add(Items.END_COOKIE);
                entries.add(Items.VOIDBERRY_PIE);
                entries.add(Items.SWEET_BERRY_PIE);
                entries.add(Items.SWEET_BERRY_PIE_SLICE);
            }).build()
        );

        // Bottom
        Registry.register(Registries.ITEM_GROUP, TOOLS, new ItemGroup.Builder(ItemGroup.Row.BOTTOM, 0)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.tools"))
            .icon(() -> new ItemStack(Items.AMETHYST_PICKAXE))
            .entries((displayContext, entries) -> {
                entries.add(Items.COPPER_AXE);
                entries.add(Items.COPPER_PICKAXE);
                entries.add(Items.COPPER_SHOVEL);
                entries.add(Items.COPPER_HOE);

                entries.add(Items.AMETHYST_AXE);
                entries.add(Items.AMETHYST_PICKAXE);
                entries.add(Items.AMETHYST_SHOVEL);
                entries.add(Items.AMETHYST_HOE);

                entries.add(Items.STARDUST_AXE);
                entries.add(Items.STARDUST_PICKAXE);
                entries.add(Items.STARDUST_SHOVEL);
                entries.add(Items.STARDUST_HOE);

                entries.add(Items.CHORUS_BOAT);
                entries.add(Items.CHORUS_CHEST_BOAT);
                entries.add(Items.VACANT_BOAT);
                entries.add(Items.VACANT_CHEST_BOAT);
                entries.add(Items.VOIDING_BOAT);
                entries.add(Items.VOIDING_CHEST_BOAT);

                entries.add(Items.MUSIC_DISC_FOX);
                entries.add(Items.MUSIC_DISC_STARDUST);
                entries.add(Items.MUSIC_DISC_TRAVELERS);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, COMBAT, new ItemGroup.Builder(ItemGroup.Row.BOTTOM, 1)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.combat"))
            .icon(() -> new ItemStack(Items.AMETHYST_SWORD))
            .entries((displayContext, entries) -> {
                entries.add(Items.COPPER_SWORD);
                entries.add(Items.COPPER_AXE);
                entries.add(Items.COPPER_HELMET);
                entries.add(Items.COPPER_CHESTPLATE);
                entries.add(Items.COPPER_LEGGINGS);
                entries.add(Items.COPPER_BOOTS);

                entries.add(Items.AMETHYST_SWORD);
                entries.add(Items.AMETHYST_AXE);
                entries.add(Items.AMETHYST_HELMET);
                entries.add(Items.AMETHYST_CHESTPLATE);
                entries.add(Items.AMETHYST_LEGGINGS);
                entries.add(Items.AMETHYST_BOOTS);

                entries.add(Items.SHULKER_HELMET);
                entries.add(Items.SHULKER_CHESTPLATE);
                entries.add(Items.SHULKER_LEGGINGS);
                entries.add(Items.SHULKER_BOOTS);

                entries.add(Items.CORSTINITE_HELMET);
                entries.add(Items.CORSTINITE_CHESTPLATE);
                entries.add(Items.CORSTINITE_LEGGINGS);
                entries.add(Items.CORSTINITE_BOOTS);

                entries.add(Items.STARDUST_SWORD);
                entries.add(Items.STARDUST_AXE);
                entries.add(Items.STARDUST_HELMET);
                entries.add(Items.STARDUST_CHESTPLATE);
                entries.add(Items.STARDUST_LEGGINGS);
                entries.add(Items.STARDUST_BOOTS);

                entries.add(Items.BANE_SPIKE);
                entries.add(Items.BLADE_OF_THE_NETHER);
                entries.add(Items.WOODEN_SPEAR);
                entries.add(Items.STONE_SPEAR);
                entries.add(Items.GOLDEN_SPEAR);
                entries.add(Items.AMETHYST_SPEAR);
                entries.add(Items.IRON_SPEAR);
                entries.add(Items.DIAMOND_SPEAR);
                entries.add(Items.STARDUST_SPEAR);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, UPGRADES, new ItemGroup.Builder(ItemGroup.Row.BOTTOM, 2)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.upgrades"))
            .icon(() -> new ItemStack(Items.STARDUST_UPGRADE))
            .entries((displayContext, entries) -> {
                entries.add(Items.STARDUST_NUGGET);
                entries.add(Items.STARDUST);
                entries.add(Items.STARDUST_INGOT);

                entries.add(Items.BLANK_POTTERY_SHERD);
                entries.add(Items.PARTY_POTTERY_SHERD);
                entries.add(Items.FORGER_POTTERY_SHERD);
                entries.add(Items.PIGLIN_POTTERY_SHERD);

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