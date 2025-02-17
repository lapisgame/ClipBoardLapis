// ClipboardMenu.java
package com.lapis.clipboard.menu;

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

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}