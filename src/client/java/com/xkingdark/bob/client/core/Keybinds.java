package com.xkingdark.bob.client.core;

import com.xkingdark.bob.Main;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyBinding.Category KEYBINDS = new KeyBinding.Category(categoryKey("keybinds"));

    public static final KeyBinding WAYSTONE;
    public static final KeyBinding TOAST_1;
    public static final KeyBinding TOAST_2;
    public static final KeyBinding TOAST_3;

    static {
        TOAST_3 = register("toast_3", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_3, KEYBINDS);
        TOAST_2 = register("toast_2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_2, KEYBINDS);
        TOAST_1 = register("toast_1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_1, KEYBINDS);
        WAYSTONE = register("waystone", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_4, KEYBINDS);
    };

    private static Identifier categoryKey(String name) {
        return Identifier.of(Main.MOD_ID, name);
    };

    private static String keyName(String name) {
        return Util.createTranslationKey("key", Identifier.of(Main.MOD_ID, name));
    };

    private static KeyBinding register(String name, InputUtil.Type inputType, int key, KeyBinding.Category category) {
        KeyBinding keyBinding = new KeyBinding(keyName(name), inputType, key, category);
        return KeyBindingHelper.registerKeyBinding(keyBinding);
    };
};