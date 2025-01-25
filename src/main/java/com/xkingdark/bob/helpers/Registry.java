package com.xkingdark.bob.helpers;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.items.Enchantments;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.advancement.AdvancementManager;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlacedAdvancement;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    public static void initialize() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
            ItemStack mainhand = player.getMainHandStack();
            if (!player.isSneaking()) {
                if ((Enchantments.hasEnchantment(world, mainhand, Enchantments.VEIN_MINER)
                    && Enchantments.ORES.contains(state.getBlock()))
                    || (Enchantments.hasEnchantment(world, mainhand, Enchantments.TREE_CAPITATOR)
                    && Enchantments.LOGS.contains(state.getBlock()))) {

                    List<BlockPos> visitedBlocks = new ArrayList<>();
                    Enchantments.applyVeinMiner(visitedBlocks, world, player, mainhand, state, pos);

                    mainhand.damage(visitedBlocks.size(), player);
                }
            }
        });

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