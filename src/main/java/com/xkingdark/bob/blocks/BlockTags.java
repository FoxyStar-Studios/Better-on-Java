package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BlockTags {
    public static final TagKey<Block> NEEDS_COPPER_TOOL = of("needs_copper_tool");
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = of("incorrect_for_copper_tool");

    private static TagKey<Block> of(String identifier) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Main.MOD_ID, identifier));
    };
};