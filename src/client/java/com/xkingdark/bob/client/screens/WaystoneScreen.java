package com.xkingdark.bob.client.screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ElementListWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class WaystoneScreen extends Screen {
    public WaystoneScreen() {
        super(Text.literal("Waystone"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(
                ButtonWidget.builder(Text.literal("Button 1"), button -> {
                    if (client == null || client.player == null)
                        return;


                    client.setScreen(null);
                }).build()
        );
    }
}
