package com.lapis.clipboard.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ClipBoardBlockEntity extends BlockEntity {
    private String text = "";

    public ClipBoardBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CLIPBOARD.get(), pos, state); // Used ModBlockEntities.CLIPBOARD
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}