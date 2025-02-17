package com.lapis.clipboard.item;

import com.lapis.clipboard.client.ClipboardScreen;
import com.lapis.clipboard.menu.ClipboardMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class ClipBoardItem extends Item {
    public ClipBoardItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && !player.level().isClientSide()) {
            NetworkHooks.openScreen((ServerPlayer) player, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Edit Clipboard");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
                    // Передаем stack через FriendlyByteBuf
                    FriendlyByteBuf data = new FriendlyByteBuf(Unpooled.buffer());
                    data.writeItem(stack);
                    return new ClipboardMenu(id, inv, data);
                }
            }, buf -> buf.writeItem(stack)); // Передача данных клиенту
        }
        return InteractionResult.SUCCESS;
    }
}