package com.xkingdark.bob.client.screens;

/*import net.minecraft.client.gui.EditBox;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Collection;
import java.util.List;

public class WaystoneScreen extends GenericContainerScreen {
    private ButtonWidget btnPrevPage;
    private ButtonWidget btnNextPage;
    private TextFieldWidget searchBox;
    private int pageOffset;
    private int headerY;
    private boolean isLocationHeaderHovered;
    private int buttonsPerPage;
    private final Collection<String> waystones = List.of("Test");

    private static final int headerHeight = 64;
    private static final int footerHeight = 25;
    private static final int entryHeight = 25;

    public WaystoneScreen(GenericContainerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    };

    @Override
    public void init() {
        final int maxContentHeight = (int) (height * 0.6f);
        final int maxButtonsPerPage = (maxContentHeight - headerHeight - footerHeight) / entryHeight;
        buttonsPerPage = Math.max(4, Math.min(maxButtonsPerPage, waystones.size()));
        final int contentHeight = headerHeight + buttonsPerPage * entryHeight + footerHeight;

        super.init();

        btnPrevPage = ButtonWidget.builder(Text.literal("Previous"), button -> {
            pageOffset = Screen.hasShiftDown() ? 0 : pageOffset - 1;
        }).position(width / 2 - 100, height / 2 + 40).size(95, 20).build();
        this.addDrawableChild(btnPrevPage);

        btnNextPage = ButtonWidget.builder(Text.literal("Next"), button -> {
            pageOffset = Screen.hasShiftDown() ? (waystones.size() - 1) / buttonsPerPage : pageOffset + 1;
        }).position(width / 2 + 5, height / 2 + 40).size(95, 20).build();
        this.addDrawableChild(btnNextPage);

        TextFieldWidget searchBox = new TextFieldWidget(this.textRenderer, width / 2 - 99, this.y + headerHeight - 24, 198, 20, Text.literal(""));
        searchBox.setVisible(true);
        searchBox.setPlaceholder(
            Text.literal("Search...").formatted(Formatting.ITALIC).formatted(Formatting.GRAY)
        );
        searchBox.setChangedListener((text) -> {
            pageOffset = 0;
            //searchText = text;
            //updateList();
        });
        this.addDrawableChild(searchBox);
        /*searchBox = new EditBox(this.textRenderer, );
        searchBox.setChangeListener();

        this.addDrawableChild(searchBox);*/
    /*}
};*/

import com.xkingdark.bob.network.packets.WaystoneHandlePacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.SocialInteractionsScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class WaystoneScreen extends Screen {
    private static final Identifier BACKGROUND_TEXTURE = Identifier.ofVanilla("social_interactions/background");
    private static final Identifier SEARCH_ICON_TEXTURE = Identifier.ofVanilla("icon/search");
    @Nullable
    private final Screen parent;
    public final Boolean isFromBlock;
    public final BlockPos blockPos;

    public WaystoneScreen(Boolean isFromBlock, BlockPos blockPos) {
        this(null, isFromBlock, blockPos);
    };

    public WaystoneScreen(@Nullable Screen parent, Boolean isFromBlock, BlockPos blockPos) {
        super(Text.literal("Waystone"));
        this.parent = parent;
        this.isFromBlock = isFromBlock;
        this.blockPos = blockPos;
    };

    @Override
    public void close() {
        if (this.client == null)
            return;
        
        this.client.setScreen(this.parent);
    };

    @Override
    public boolean shouldPause() {
        return false;
    };

    @Override
    protected void init() {
        this.addContent();
    };

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.renderBackground(context, mouseX, mouseY, deltaTicks);
        int i = this.getSearchBoxX() + 3;
        context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, BACKGROUND_TEXTURE, i, 64, 236, this.getScreenHeight() + 16);
        context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, SEARCH_ICON_TEXTURE, i + 10, 76, 12, 12);
    };

    protected void addTitle() {
        Text title = Text.literal("Waystone");
        //this.layout.add(new TextWidget(title, this.textRenderer));
    };

    protected void addContent() {
        TextFieldWidget searchBox = new TextFieldWidget(this.textRenderer, this.getSearchBoxX() + 28, 74, 200, 15, Text.literal(""));
        searchBox.setVisible(true);
        searchBox.setPlaceholder(
            Text.literal("Search...").formatted(Formatting.ITALIC).formatted(Formatting.GRAY)
        );
        searchBox.setChangedListener(this::onSearchChange);
        this.addDrawableChild(searchBox);

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Button 1"), button -> {
            if (client == null || client.player == null)
                return;

            client.player.sendMessage(
                Text.literal("Input: ").append(searchBox.getText()), false);

            client.setScreen(null);
            ClientPlayNetworking.send(
                new WaystoneHandlePacket(this.isFromBlock, this.blockPos, 0)
            );
        }).position(this.getSearchBoxX() + 20, 96).build());
    };

    private void onSearchChange(String currentSearch) {
        currentSearch = currentSearch.toLowerCase(Locale.ROOT);
        if (this.client == null || this.client.player == null)
            return;

        this.client.player.sendMessage(
            Text.literal("Message: " + currentSearch), false
        );
        /*if (!currentSearch.equals(this.currentSearch)) {
            this.playerList.setCurrentSearch(currentSearch);
            this.currentSearch = currentSearch;
            this.setCurrentTab(this.currentTab);
        }*/
    };

    private int getScreenHeight() {
        return Math.max(52, this.height - 128 - 16);
    };

    private int getSearchBoxX() {
        return (this.width - 238) / 2;
    };
};