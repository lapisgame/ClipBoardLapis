package com.lapis.clipboard.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock; // Добавьте этот импорт
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ClipBoardBlock extends Block implements EntityBlock { // Реализуем EntityBlock
    public ClipBoardBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClipBoardBlockEntity(pos, state);
    }
}