package com.lapis.clipboard;

import com.lapis.clipboard.block.ModBlockEntities;
import com.lapis.clipboard.block.ModBlocks;
import com.lapis.clipboard.item.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClipBoardMod.MODID)
public class ClipBoardMod {
    public static final String MODID = "clipboard";

    public ClipBoardMod() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Регистрируем обработчик для добавления в креативные вкладки
        FMLJavaModLoadingContext.get()
                .getModEventBus()
                .addListener(ModItems::addCreative);
    }

    private void setup(final FMLCommonSetupEvent event) {
        System.out.println("ClipBoard mod is setting up!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        System.out.println("ClipBoard mod client setup complete!");
    }
}