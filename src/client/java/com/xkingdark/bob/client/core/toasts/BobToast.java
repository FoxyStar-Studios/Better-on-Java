package com.xkingdark.bob.client.core.toasts;

import com.xkingdark.bob.Main;
import com.xkingdark.bob.items.Items;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BobToast implements Toast {
    private final Type type;
    private final Text title;
    private final Text toastText;
    private final ItemStack icon;
    private final boolean isChallenge;
    private Toast.Visibility visibility;

    public BobToast(Type type, Text title, Text toastText, ItemStack icon, boolean isChallenge) {
        this.type = type;
        this.title = title;
        this.toastText = toastText;
        this.icon = icon;
        this.isChallenge = true;
        this.visibility = Visibility.HIDE;
    };

    @Override
    public Toast.Visibility getVisibility() {
        return this.visibility;
    };

    @Override
    public void update(ToastManager manager, long time) {
        this.visibility = (double)time >= (double)5000.0F * manager.getNotificationDisplayTimeMultiplier() ? Visibility.HIDE : Visibility.SHOW;
    };

    @Nullable
    public SoundEvent getSoundEvent() {
        return this.isChallenge() ? SoundEvents.UI_TOAST_CHALLENGE_COMPLETE : null;
    };

    private boolean isChallenge() {
        return this.isChallenge;
    };

    @Override
    public void draw(DrawContext context, TextRenderer textRenderer, long startTime) {
        context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, this.type.texture, 0, 0, this.getWidth(), this.getHeight());

        Style style = this.title.getStyle();
        Style textStyle = this.toastText.getStyle();
        int color = style.getColor() != null ? style.getColor().getRgb() : Colors.WHITE;
        int textColor = textStyle.getColor() != null ? textStyle.getColor().getRgb() : Colors.LIGHT_GRAY;

        List<OrderedText> list = textRenderer.wrapLines(this.toastText, 125);
        if (list.size() == 1) {
            context.drawText(textRenderer, this.title, 38, 7, color, true);
            context.drawText(textRenderer, list.getFirst(), 38, 18, textColor, true);
        }
        else {
            if (startTime < 1500L) {
                int k = MathHelper.floor(MathHelper.clamp((float)(1500L - startTime) / 300.0F, 0.0F, 1.0F) * 255.0F) << 24 | 67108864;
                context.drawText(textRenderer, this.title, 38, 11, color | k, true);
            } else {
                int k = MathHelper.floor(MathHelper.clamp((float)(startTime - 1500L) / 300.0F, 0.0F, 1.0F) * 252.0F) << 24 | 67108864;
                int halfHeight = this.getHeight() / 2;
                int size = list.size();
                int l = halfHeight - size * 9 / 2;

                for(OrderedText orderedText : list) {
                    context.drawText(textRenderer, orderedText, 38, l, textColor | k, true);
                    l += 9;
                };
            };
        };

        context.drawItemWithoutEntity(this.icon, 16, 8);
    };

    public enum Type {
        GOAL(Identifier.ofVanilla("toast/advancement")),
        QUEST(Identifier.of(Main.MOD_ID, "toast/quest")),
        BOUNTY(Identifier.of(Main.MOD_ID, "toast/bounty"));

        public final Identifier texture;
        Type(final Identifier texture) {
            this.texture = texture;
        };
    };
};