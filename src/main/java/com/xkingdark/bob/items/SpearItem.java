package com.xkingdark.bob.items;

import com.xkingdark.bob.entities.EntityTypes;
import com.xkingdark.bob.entities.SpearEntity;
import net.minecraft.block.BlockState;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.List;

public class SpearItem extends Item implements ProjectileItem {
    public SpearItem(Item.Settings settings) {
        super(settings);
    }

    public static AttributeModifiersComponent createAttributeModifiers(double damage) {
        return AttributeModifiersComponent.builder()
            .add(
                EntityAttributes.ATTACK_DAMAGE,
                new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, damage - 1, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .add(
                EntityAttributes.ATTACK_SPEED,
                new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.9F, EntityAttributeModifier.Operation.ADD_VALUE),
                AttributeModifierSlot.MAINHAND
            )
            .build();
    };

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2, false);
    };

    @Override
    public boolean canMine(ItemStack stack, BlockState state, World world, BlockPos pos, LivingEntity miner) {
        if (!(miner instanceof PlayerEntity))
            return false;

        return !((PlayerEntity) miner).isCreative();
    };

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    };

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    };

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (i < 10 || stack.willBreakNextUse())
                return false;

            RegistryEntry<SoundEvent> registryEntry = EnchantmentHelper.getEffect(stack, EnchantmentEffectComponentTypes.TRIDENT_SOUND)
                .orElse(SoundEvents.ITEM_TRIDENT_THROW);
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));

            if (world instanceof ServerWorld serverWorld) {
                stack.damage(1, playerEntity);

                EntityType<? extends SpearEntity> spearType = getEntityType(stack);
                SpearEntity spearEntity = ProjectileEntity.spawnWithVelocity((entityWorld, owner, itemStack) ->
                    new SpearEntity(spearType, entityWorld, owner, itemStack),
                    serverWorld, stack, playerEntity, 0.0F, 2.5F, 1.0F);

                if (playerEntity.isInCreativeMode()) {
                    spearEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                }
                else playerEntity.getInventory().removeOne(stack);

                world.playSoundFromEntity(null, spearEntity, registryEntry.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                return true;
            };
        };

        return false;
    };

    private static EntityType<? extends SpearEntity> getEntityType(ItemStack stack) {
        EntityType<? extends SpearEntity> spearType;
        if (stack.isOf(Items.STONE_SPEAR)) {
            spearType = EntityTypes.STONE_SPEAR;
        }
        else if (stack.isOf(Items.GOLDEN_SPEAR)) {
            spearType = EntityTypes.GOLDEN_SPEAR;
        }
        else if (stack.isOf(Items.IRON_SPEAR)) {
            spearType = EntityTypes.IRON_SPEAR;
        }
        else if (stack.isOf(Items.DIAMOND_SPEAR)) {
            spearType = EntityTypes.DIAMOND_SPEAR;
        }
        else if (stack.isOf(Items.AMETHYST_SPEAR)) {
            spearType = EntityTypes.AMETHYST_SPEAR;
        }
        else if (stack.isOf(Items.STARDUST_SPEAR)) {
            spearType = EntityTypes.STARDUST_SPEAR;
        } else {
            spearType = EntityTypes.WOODEN_SPEAR;
        };

        return spearType;
    };

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.willBreakNextUse())
            return ActionResult.FAIL;

        user.setCurrentHand(hand);
        return ActionResult.CONSUME;
    };

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {};

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    };

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        SpearEntity spearEntity = new SpearEntity(getEntityType(stack), world, pos, stack.copyWithCount(1));
        spearEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return spearEntity;
    };
};