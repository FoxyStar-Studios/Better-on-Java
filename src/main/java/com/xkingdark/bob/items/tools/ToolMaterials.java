package com.xkingdark.bob.items.tools;

import com.xkingdark.bob.items.ItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ToolMaterials {
	public static final ToolMaterial STARDUST;
	public static final ToolMaterial COPPER;

	static {
		STARDUST = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, ItemTags.STARDUST_TOOL_MATERIALS);
		COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1031, 2.0F, 4.0F, 15, ItemTags.COPPER_TOOL_MATERIALS);
	}
}
