package com.lapis.clipboard.item;

import com.lapis.clipboard.block.ClipBoardBlockEntity;
import com.lapis.clipboard.block.ModBlocks;
import com.lapis.clipboard.menu.ClipboardMenu;
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class ClipBoardItem extends Item {
    public ClipBoardItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && !level.isClientSide) {
            // Если клик не по блоку - открыть GUI
            if (player.isShiftKeyDown()) {
                // Логика размещения на стене (ваш текущий код)
            } else {
                // Открыть GUI для ввода текста
                NetworkHooks.openScreen((ServerPlayer) player, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Edit ClipBoard");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
                        return new ClipboardMenu(id, inv, stack);
                    }
                });
            }
        }
        return InteractionResult.SUCCESS;
    }
}