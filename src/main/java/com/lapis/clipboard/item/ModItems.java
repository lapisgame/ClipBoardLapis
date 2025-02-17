package com.lapis.clipboard.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.lapis.clipboard.ClipBoardMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ClipBoardMod.MODID);

    public static final RegistryObject<Item> CLIPBOARD = ITEMS.register("clipboard",
            () -> new ClipBoardItem(new Item.Properties().stacksTo(1)));

    // Добавляем предмет в креативную вкладку через событие
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(CLIPBOARD.get());
        }
    }
}