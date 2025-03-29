package com.xkingdark.bob.mixin;

import net.minecraft.block.DecoratedPotPattern;
import net.minecraft.block.DecoratedPotPatterns;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.xkingdark.bob.blocks.DecoratedPotPatterns.fromSherd;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPattersMixin {
    @Inject(method = "fromSherd", at = @At("HEAD"), cancellable = true)
    private static void bob$fromSherd(Item item, CallbackInfoReturnable<RegistryKey<DecoratedPotPattern>> returnable) {
        RegistryKey<DecoratedPotPattern> pattern = fromSherd(item);
        if (pattern == null)
            return;

        returnable.setReturnValue(pattern);
    }
}
