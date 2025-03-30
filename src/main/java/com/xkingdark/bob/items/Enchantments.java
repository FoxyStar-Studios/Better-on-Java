package com.xkingdark.bob.items;

import com.xkingdark.bob.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Enchantments {
    public static final RegistryKey<Enchantment> VEIN_MINER = keyOf("vein_miner");
    public static final RegistryKey<Enchantment> TREE_CAPITATOR = keyOf("tree_capitator");

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
    public static final List<Block> LOGS = List.of(
        Blocks.OAK_LOG,
        Blocks.OAK_WOOD,
        Blocks.STRIPPED_OAK_LOG,
        Blocks.STRIPPED_OAK_WOOD,
        Blocks.SPRUCE_LOG,
        Blocks.SPRUCE_WOOD,
        Blocks.STRIPPED_SPRUCE_LOG,
        Blocks.STRIPPED_SPRUCE_WOOD,
        Blocks.BIRCH_LOG,
        Blocks.BIRCH_WOOD,
        Blocks.STRIPPED_BIRCH_LOG,
        Blocks.STRIPPED_BIRCH_WOOD,
        Blocks.JUNGLE_LOG,
        Blocks.JUNGLE_WOOD,
        Blocks.STRIPPED_JUNGLE_LOG,
        Blocks.STRIPPED_JUNGLE_WOOD,
        Blocks.ACACIA_LOG,
        Blocks.ACACIA_WOOD,
        Blocks.STRIPPED_ACACIA_LOG,
        Blocks.STRIPPED_ACACIA_WOOD,
        Blocks.DARK_OAK_LOG,
        Blocks.DARK_OAK_WOOD,
        Blocks.STRIPPED_DARK_OAK_LOG,
        Blocks.STRIPPED_DARK_OAK_WOOD,
        Blocks.MANGROVE_LOG,
        Blocks.MANGROVE_WOOD,
        Blocks.STRIPPED_MANGROVE_LOG,
        Blocks.STRIPPED_MANGROVE_WOOD,
        Blocks.CHERRY_LOG,
        Blocks.CHERRY_WOOD,
        Blocks.STRIPPED_CHERRY_LOG,
        Blocks.STRIPPED_CHERRY_WOOD,
        Blocks.PALE_OAK_LOG,
        Blocks.PALE_OAK_WOOD,
        Blocks.STRIPPED_PALE_OAK_LOG,
        Blocks.STRIPPED_PALE_OAK_WOOD,
        Blocks.BAMBOO_BLOCK,
        Blocks.STRIPPED_BAMBOO_BLOCK,
        Blocks.CRIMSON_STEM,
        Blocks.CRIMSON_HYPHAE,
        Blocks.STRIPPED_CRIMSON_STEM,
        Blocks.STRIPPED_CRIMSON_HYPHAE,
        Blocks.WARPED_STEM,
        Blocks.WARPED_HYPHAE,
        Blocks.STRIPPED_WARPED_STEM,
        Blocks.STRIPPED_WARPED_HYPHAE,

        com.xkingdark.bob.blocks.Blocks.CHORUS_LOG,
        com.xkingdark.bob.blocks.Blocks.CHORUS_WOOD,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_CHORUS_LOG,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_CHORUS_WOOD,
        com.xkingdark.bob.blocks.Blocks.VACANT_LOG,
        com.xkingdark.bob.blocks.Blocks.VACANT_WOOD,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_VACANT_LOG,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_VACANT_WOOD,
        com.xkingdark.bob.blocks.Blocks.VOIDING_LOG,
        com.xkingdark.bob.blocks.Blocks.VOIDING_WOOD,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_VOIDING_LOG,
        com.xkingdark.bob.blocks.Blocks.STRIPPED_VOIDING_WOOD
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
                || itemStack.getDamage() + visitedBlocks.size() == itemStack.getMaxDamage())
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

    public static boolean hasEnchantment(World world, ItemStack itemStack, RegistryKey<Enchantment> key) {
        Registry<Enchantment> registry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> enchantment = registry.getOrThrow(key);

        return EnchantmentHelper.getLevel(enchantment, itemStack) > 0;
    }

    public static boolean checkMinerEnchantment(World world, ItemStack itemStack, BlockState state) {
        if (Enchantments.hasEnchantment(world, itemStack, Enchantments.VEIN_MINER)) {
            return Enchantments.ORES.contains(state.getBlock());
        }
        else if (Enchantments.hasEnchantment(world, itemStack, Enchantments.TREE_CAPITATOR)) {
            return Enchantments.LOGS.contains(state.getBlock());
        };

        return false;
    }
}
