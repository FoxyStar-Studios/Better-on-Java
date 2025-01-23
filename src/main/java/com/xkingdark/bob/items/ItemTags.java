package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ItemTags {
    public static final TagKey<Item> CORSTINITE = of("corstinite");
    public static final TagKey<Item> STARDUST = of("stardust");
    public static final TagKey<Item> STARDUST_TOOL_MATERIALS = of("stardust_tool_materials");
    public static final TagKey<Item> COPPER_TOOL_MATERIALS = of("copper_tool_materials");

    private static TagKey<Item> of(String identifier) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, identifier));
    }
}
