package com.xkingdark.bob.client.core;

import com.xkingdark.bob.Main;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final KeyBinding WAYSTONE;
    public static final KeyBinding TOAST_1;

    static {
        WAYSTONE = register("waystone", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_1, "keybinds");
        TOAST_1 = register("toast_1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_2, "keybinds");
    };

    private static String categoryKey(String name) {
        return Util.createTranslationKey("category", Identifier.of(Main.MOD_ID, name));
    };

    private static String keyName(String name) {
        return Util.createTranslationKey("key", Identifier.of(Main.MOD_ID, name));
    };

    private static KeyBinding register(String name, InputUtil.Type inputType, int key, String category) {
        KeyBinding keyBinding = new KeyBinding(keyName(name), inputType, key, categoryKey(category));
        return KeyBindingHelper.registerKeyBinding(keyBinding);
    };
};
