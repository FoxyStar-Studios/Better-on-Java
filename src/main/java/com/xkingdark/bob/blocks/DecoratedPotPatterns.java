package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.items.Items;
import net.minecraft.block.DecoratedPotPattern;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DecoratedPotPatterns {
    public static final RegistryKey<DecoratedPotPattern> BLANK = of("blank");
    public static final RegistryKey<DecoratedPotPattern> PARTY = of("party");
    public static final RegistryKey<DecoratedPotPattern> FORGER = of("forger");
    public static final RegistryKey<DecoratedPotPattern> PIGLIN = of("piglin");
    public static final Map<Item, RegistryKey<DecoratedPotPattern>> SHERD_TO_PATTERN = Map.of(
        Items.BLANK_POTTERY_SHERD, BLANK,
        Items.PARTY_POTTERY_SHERD, PARTY,
        Items.FORGER_POTTERY_SHERD, FORGER,
        Items.PIGLIN_POTTERY_SHERD, PIGLIN
    );

    static {
        register(BLANK, "blank_pottery_pattern");
        register(PARTY, "party_pottery_pattern");
        register(FORGER, "forger_pottery_pattern");
        register(PIGLIN, "piglin_pottery_pattern");
    }

    @Nullable
    public static RegistryKey<DecoratedPotPattern> fromSherd(Item sherd) {
        return SHERD_TO_PATTERN.get(sherd);
    }

    private static RegistryKey<DecoratedPotPattern> of(String path) {
        return RegistryKey.of(RegistryKeys.DECORATED_POT_PATTERN, Identifier.of(Main.MOD_ID, path));
    }

    private static DecoratedPotPattern register(RegistryKey<DecoratedPotPattern> key, String assetId) {
        Identifier identifier = Identifier.of(Main.MOD_ID, assetId);
        return Registry.register(Registries.DECORATED_POT_PATTERN, key, new DecoratedPotPattern(identifier));
    }
}