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
    public static final RegistryKey<ItemGroup> TOOLS = keyOf("tools");
    public static final RegistryKey<ItemGroup> FOOD = keyOf("food");
    public static final RegistryKey<ItemGroup> COMBAT = keyOf("combat");

    private static RegistryKey<ItemGroup> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Main.MOD_ID, id));
    }

    static {
        // Top
        Registry.register(Registries.ITEM_GROUP, TOOLS, ItemGroup.create(ItemGroup.Row.TOP, 0)
                .displayName(Text.translatable("itemGroup.betterOnBedrock.tools"))
                .icon(() -> new ItemStack(Items.WAYSTONE))
                .entries((displayContext, entries) -> {
                    entries.add(Items.WAYSTONE);
                }).build()
        );

        // Bottom
        Registry.register(Registries.ITEM_GROUP, FOOD, ItemGroup.create(ItemGroup.Row.BOTTOM, 0)
                .displayName(Text.translatable("itemGroup.betterOnBedrock.food"))
                .icon(() -> new ItemStack(Items.MUTTON_CHOPS_RAW))
                .entries((displayContext, entries) -> {
                    entries.add(Items.MUTTON_CHOPS_RAW);
                    entries.add(Items.MUTTON_CHOPS_COOKED);
                }).build()
        );
        Registry.register(Registries.ITEM_GROUP, COMBAT, ItemGroup.create(ItemGroup.Row.BOTTOM, 1)
                .displayName(Text.translatable("itemGroup.betterOnBedrock.combat"))
                .icon(() -> new ItemStack(Items.CORSTINITE_HELMET))
                .entries((displayContext, entries) -> {
                    entries.add(Items.CORSTINITE_HELMET);
                    entries.add(Items.CORSTINITE_CHESTPLATE);
                    entries.add(Items.CORSTINITE_LEGGINGS);
                    entries.add(Items.CORSTINITE_BOOTS);
                }).build()
        );
    }
}
