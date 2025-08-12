package com.xkingdark.bob.sound;

import com.xkingdark.bob.Main;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundEvents {
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_FOX;
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_STARDUST;
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_STELLAR_CRYSTALS;
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_TRAVELERS;

    static {
        MUSIC_DISC_FOX = registerReference("music_disc.fox");
        MUSIC_DISC_STARDUST = registerReference("music_disc.stardust");
        MUSIC_DISC_STELLAR_CRYSTALS = registerReference("music_disc.stellar_crystals");
        MUSIC_DISC_TRAVELERS = registerReference("music_disc.travelers");
    };

    private static RegistryEntry.Reference<SoundEvent> registerReference(String soundId) {
        return registerReference(Identifier.of(Main.MOD_ID, soundId));
    };

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, soundId, SoundEvent.of(soundId));
    };

    private static SoundEvent register(String soundId) {
        return register(Identifier.of(Main.MOD_ID, soundId));
    };

    private static SoundEvent register(Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, soundId, SoundEvent.of(soundId));
    };
};