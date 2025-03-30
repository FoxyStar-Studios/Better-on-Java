package com.xkingdark.bob.core;

import com.xkingdark.bob.items.Enchantments;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class Events {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register(Events::onPlayerBlockBreakEvent);

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
    };

    private static void onPlayerBlockBreakEvent(
        World world, PlayerEntity player,
        BlockPos pos, BlockState state, BlockEntity entity
    ) {
        if (player.isSneaking())
            return;

        ItemStack mainHand = player.getMainHandStack();

        List<BlockPos> visitedBlocks = new ArrayList<>();
        if (Enchantments.checkMinerEnchantment(world, mainHand, state)) {
            Enchantments.applyVeinMiner(visitedBlocks, world, player, mainHand, state, pos);
            mainHand.damage(visitedBlocks.size(), player);
        };
    };
};