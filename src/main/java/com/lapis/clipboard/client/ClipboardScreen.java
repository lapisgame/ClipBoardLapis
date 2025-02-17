// ClipboardScreen.java
package com.lapis.clipboard.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import com.lapis.clipboard.ClipBoardMod;

public class ClipboardScreen extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ClipBoardMod.MODID, "textures/gui/clipboard.png");
    private EditBox textField;

    public ClipboardScreen() {
        super(Component.literal("ClipBoard Editor"));
    }

    @Override
    protected void init() {
        this.textField = new EditBox(this.font, this.width / 2 - 100, this.height / 2 - 20, 200, 40, Component.literal(""));
        this.addRenderableWidget(this.textField);
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(gui);
        gui.drawCenteredString(this.font, this.title, this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        super.render(gui, mouseX, mouseY, partialTicks);
    }

    @Override
    public void onClose() {
        // Сохранить текст при закрытии
        super.onClose();
    }
}