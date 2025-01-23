package com.xkingdark.bob.blocks.jukebox;

import com.xkingdark.bob.Main;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public interface JukeboxSongs {
    RegistryKey<JukeboxSong> FOX = of("fox");
    RegistryKey<JukeboxSong> STARDUST = of("stardust");
    RegistryKey<JukeboxSong> STELLAR_CRYSTALS = of("stellar_crystals");
    RegistryKey<JukeboxSong> TRAVELERS = of("travelers");

    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Main.MOD_ID, id));
    }
}
