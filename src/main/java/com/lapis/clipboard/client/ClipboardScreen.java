package com.lapis.clipboard.client;

import com.lapis.clipboard.menu.ClipboardMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import com.lapis.clipboard.ClipBoardMod;

public class ClipboardScreen extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ClipBoardMod.MODID, "textures/gui/clipboard.png");

    // private final ItemStack clipboardStack; // Добавляем поле

    // Конструктор с параметром ItemStack
    private final ClipboardMenu menu; // Добавляем ссылку на меню
    private EditBox textField;

    // Конструктор, совместимый с MenuScreens
    public ClipboardScreen(ClipboardMenu menu, Inventory inv, Component title) {
        super(title);
        this.menu = menu;

        // инициализация текстового поля с правильными параметрами
        this.textField = new EditBox(
                this.font,                    // Шрифт
                this.width / 2 - 100,         // X
                this.height / 2 - 20,         // Y
                200,                          // Ширина
                20,                           // Высота
                Component.literal("")         // Заголовок (пустой)
        );

        // Загрузка текста из ItemStack
        ItemStack clipboardStack = menu.getClipboardStack();
        if (clipboardStack.hasTag()) {
            CompoundTag tag = clipboardStack.getTag();
            this.textField.setValue(tag.getString("Text"));
        }
    }

    @Override
    protected void init() {
        this.textField = new EditBox(this.font, this.width / 2 - 100, this.height / 2 - 20, 200, 40, Component.literal(""));
        this.addRenderableWidget(this.textField);

        // Загружаем текст из NBT, если он есть
        if (this.clipboardStack.hasTag()) {
            CompoundTag tag = this.clipboardStack.getTag();
            this.textField.setValue(tag.getString("Text"));
        }
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(gui);
        gui.drawCenteredString(this.font, this.title, this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        super.render(gui, mouseX, mouseY, partialTicks);
    }

    @Override
    public void onClose() {
        if (this.textField != null && !this.clipboardStack.isEmpty()) {
            CompoundTag tag = this.clipboardStack.getOrCreateTag();
            tag.putString("Text", this.textField.getValue());
        }
        super.onClose();
    }
}