package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.blocks.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, FOOD, ItemGroup.create(ItemGroup.Row.BOTTOM, 2)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.food"))
            .icon(() -> new ItemStack(Items.BAGUETTE))
            .entries((displayContext, entries) -> {
                entries.add(Items.MUTTON_CHOPS_RAW);
                entries.add(Items.MUTTON_CHOPS_COOKED);
                entries.add(Items.BAGUETTE);
            }).build()
        );

        Registry.register(Registries.ITEM_GROUP, UPGRADES, ItemGroup.create(ItemGroup.Row.BOTTOM, 3)
            .displayName(Text.translatable("itemGroup.betterOnBedrock.upgrades"))
            .icon(() -> new ItemStack(Items.STARDUST_UPGRADE))
            .entries((displayContext, entries) -> {
                entries.add(Items.STARDUST_UPGRADE);
                entries.add(Items.STARDUST_INGOT);
            }).special().build()
        );
    }
}