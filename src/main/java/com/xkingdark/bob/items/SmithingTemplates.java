package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class SmithingTemplates {
	private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
		return List.of(
				Identifier.ofVanilla("container/slot/helmet"),
				Identifier.ofVanilla("container/slot/sword"),
				Identifier.ofVanilla("container/slot/chestplate"),
				Identifier.ofVanilla("container/slot/pickaxe"),
				Identifier.ofVanilla("container/slot/leggings"),
				Identifier.ofVanilla("container/slot/axe"),
				Identifier.ofVanilla("container/slot/boots"),
				Identifier.ofVanilla("container/slot/hoe"),
				Identifier.ofVanilla("container/slot/shovel")
		);
	}

	private static List<Identifier> getUpgradeEmptyAdditionsSlotTextures() {
		return List.of(Identifier.ofVanilla("container/slot/ingot"));
	}

	public static SmithingTemplateItem createUpgrade(String upgrade, Item.Settings settings) {
		return new SmithingTemplateItem(
				Text.translatable(Util.createTranslationKey("item", Identifier.of(Main.MOD_ID, "smithing_template." + upgrade + "_upgrade.applies_to"))).formatted(Formatting.BLUE),
				Text.translatable(Util.createTranslationKey("item", Identifier.of(Main.MOD_ID, "smithing_template." + upgrade + "_upgrade.ingredients"))).formatted(Formatting.BLUE),
				Text.translatable(Util.createTranslationKey("item", Identifier.of(Main.MOD_ID, "smithing_template." + upgrade + "_upgrade.base_slot_description"))),
				Text.translatable(Util.createTranslationKey("item", Identifier.of(Main.MOD_ID, "smithing_template." + upgrade + "_upgrade.additions_slot_description"))),
				getUpgradeEmptyBaseSlotTextures(),
				getUpgradeEmptyAdditionsSlotTextures(),
				settings
		);
	}
}
