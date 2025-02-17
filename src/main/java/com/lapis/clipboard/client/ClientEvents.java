package com.lapis.clipboard.client;

import com.lapis.clipboard.ClipBoardMod;
import com.lapis.clipboard.block.ModBlockEntities;
import com.lapis.clipboard.block.ClipboardBlockRenderer;
import com.lapis.clipboard.menu.ClipboardMenu;
import com.lapis.clipboard.menu.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = ClipBoardMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Регистрируем экран с явным указанием типов
        MenuScreens.register(
                ModMenuTypes.CLIPBOARD_MENU.get(),
                (MenuType<? extends ClipboardMenu> type, Inventory inv, Component title) ->
                        new ClipboardScreen((ClipboardMenu) type.create(0, inv), inv, title)
        );
    }
}