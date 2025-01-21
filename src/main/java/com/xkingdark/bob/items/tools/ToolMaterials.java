package com.xkingdark.bob.items.tools;

import com.xkingdark.bob.items.ItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ToolMaterials {
	public static final ToolMaterial STARDUST;

	static {
		STARDUST = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, ItemTags.STARDUST_TOOL_MATERIALS);
	}
}
