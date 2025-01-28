package com.xkingdark.bob.blocks;

import com.xkingdark.bob.Main;
import net.minecraft.block.DecoratedPotPattern;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DecoratedPotPatterns {
    public static final RegistryKey<DecoratedPotPattern> BLANK = of("blank");
    public static final RegistryKey<DecoratedPotPattern> PARTY = of("party");
    public static final RegistryKey<DecoratedPotPattern> FORGER = of("forger");
    public static final RegistryKey<DecoratedPotPattern> PIGLIN = of("piglin");

    static {
        register(BLANK, "blank_pottery_pattern");
        register(PARTY, "party_pottery_pattern");
        register(FORGER, "forger_pottery_pattern");
        register(PIGLIN, "piglin_pottery_pattern");
    }

    private static RegistryKey<DecoratedPotPattern> of(String path) {
        return RegistryKey.of(RegistryKeys.DECORATED_POT_PATTERN, Identifier.of(Main.MOD_ID, path));
    }

    private static DecoratedPotPattern register(RegistryKey<DecoratedPotPattern> key, String id) {
        return register(key, Identifier.of(Main.MOD_ID, id));
    }

    private static DecoratedPotPattern register(RegistryKey<DecoratedPotPattern> key, Identifier identifier) {
        return Registry.register(Registries.DECORATED_POT_PATTERN, key,
            new DecoratedPotPattern(identifier));
    }
}
