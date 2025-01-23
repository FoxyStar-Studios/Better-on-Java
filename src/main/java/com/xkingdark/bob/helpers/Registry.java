package com.xkingdark.bob.helpers;

import com.xkingdark.bob.Main;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;

public class Registry {
    public static void initialize() {
        /*ServerTickEvents.END_SERVER_TICK.register((server) -> {
            List<ServerPlayerEntity> players = server.getPlayerManager().getPlayerList();
            AdvancementManager manager = server.getAdvancementLoader().getManager();
            PlacedAdvancement advancement = manager.get(Identifier.of(Main.MOD_ID, "root"));
            if (advancement == null)
                return;

            for (ServerPlayerEntity player : players) {
                AdvancementProgress progress = player.getAdvancementTracker().getProgress(advancement.getAdvancementEntry());
                progress.isDone();
            }
        });*/
    }
}