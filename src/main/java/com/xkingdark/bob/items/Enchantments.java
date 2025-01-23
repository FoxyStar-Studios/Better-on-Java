package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Enchantments {
    public static final RegistryKey<Enchantment> VEIN_MINER = keyOf("vein_miner");

    public static final List<Block> ORES = List.of(
        Blocks.ANCIENT_DEBRIS,
        Blocks.NETHER_GOLD_ORE,
        Blocks.NETHER_QUARTZ_ORE,

        Blocks.IRON_ORE,
        Blocks.COAL_ORE,
        Blocks.COPPER_ORE,
        Blocks.DIAMOND_ORE,
        Blocks.GOLD_ORE,
        Blocks.EMERALD_ORE,
        Blocks.LAPIS_ORE,
        Blocks.REDSTONE_ORE,
        Blocks.DEEPSLATE_IRON_ORE,
        Blocks.DEEPSLATE_COAL_ORE,
        Blocks.DEEPSLATE_COPPER_ORE,
        Blocks.DEEPSLATE_DIAMOND_ORE,
        Blocks.DEEPSLATE_GOLD_ORE,
        Blocks.DEEPSLATE_EMERALD_ORE,
        Blocks.DEEPSLATE_LAPIS_ORE,
        Blocks.DEEPSLATE_REDSTONE_ORE,

        com.xkingdark.bob.blocks.Blocks.STARDUST_ORE
    );

    private static RegistryKey<Enchantment> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Main.MOD_ID, id));
    }

    private static List<BlockPos> getVeinShape(BlockPos pos) {
        return List.of(
            pos.up(), pos.down(),
            pos.north(), pos.south(),
            pos.east(), pos.west()
        );
    }

    public static void applyVeinMiner(
        List<BlockPos> visitedBlocks,
        World world,
        PlayerEntity player,
        ItemStack itemStack,
        BlockState mainState,
        BlockPos pos
    ) {
        List<BlockPos> blocks = Enchantments.getVeinShape(pos);
        for (BlockPos blockPos : blocks) {
            if (visitedBlocks.size() >= 128
                || itemStack.getDamage() == itemStack.getMaxDamage())
                break;

            if (visitedBlocks.contains(blockPos))
                continue;

            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            if (!block.equals(mainState.getBlock())
                || !itemStack.isSuitableFor(blockState))
                continue;

            visitedBlocks.add(blockPos);
            world.breakBlock(blockPos, true, player);

            applyVeinMiner(visitedBlocks, world, player, itemStack, mainState, blockPos);
        }
    }
}
