package com.lapis.clipboard.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.lapis.clipboard.ClipBoardMod;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ClipBoardMod.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ClipBoardMod.MODID);

    public static final RegistryObject<Block> CLIPBOARD = BLOCKS.register("clipboard",
            () -> new ClipBoardBlock(Block.Properties.of().strength(0.5f)));

    public static final RegistryObject<BlockEntityType<ClipBoardBlockEntity>> CLIPBOARD_BLOCK_ENTITY = BLOCK_ENTITIES.register("clipboard",
            () -> BlockEntityType.Builder.of(ClipBoardBlockEntity::new, CLIPBOARD.get()).build(null));
}