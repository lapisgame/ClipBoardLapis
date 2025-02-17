package com.lapis.clipboard.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.lapis.clipboard.ClipBoardMod;

public class ModBlockEntities {
    // Регистрируем BlockEntityType
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ClipBoardMod.MODID);

    // Регистрируем BlockEntity для ClipBoard
    public static final RegistryObject<BlockEntityType<ClipBoardBlockEntity>> CLIPBOARD =
            BLOCK_ENTITIES.register("clipboard",
                    () -> BlockEntityType.Builder.of(ClipBoardBlockEntity::new, ModBlocks.CLIPBOARD.get()).build(null));
}