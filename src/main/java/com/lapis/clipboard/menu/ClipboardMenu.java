// ClipboardMenu.java
package com.lapis.clipboard.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class ClipboardMenu extends AbstractContainerMenu {
    private final ItemStack clipboardStack;

    public ClipboardMenu(int id, Inventory inv, ItemStack stack) {
        super(ModMenuTypes.CLIPBOARD_MENU.get(), id);
        this.clipboardStack = stack;
    }

    public ItemStack getClipboardStack() {
        return clipboardStack;
    }

    // Конструктор для клиента (через FriendlyByteBuf)
    public ClipboardMenu(int id, Inventory inv, FriendlyByteBuf data) {
        this(id, inv, data.readItem());
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}