// ModMenuTypes.java
package com.lapis.clipboard.menu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;
import com.lapis.clipboard.ClipBoardMod;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ClipBoardMod.MODID);

    public static final RegistryObject<MenuType<ClipboardMenu>> CLIPBOARD_MENU =
            MENUS.register("clipboard", () -> new MenuType<>(ClipboardMenu::new));
}