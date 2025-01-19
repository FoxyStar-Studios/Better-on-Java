package com.xkingdark.bob.items.components;

import net.minecraft.component.type.FoodComponent;

public class FoodComponents {
    public static final FoodComponent MUTTON_CHOPS_RAW = (new FoodComponent.Builder()).nutrition(3).saturationModifier(0.3F).build();
    public static final FoodComponent MUTTON_CHOPS_COOKED = (new FoodComponent.Builder()).nutrition(8).saturationModifier(0.8F).build();

    public FoodComponents() {}
}