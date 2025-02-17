package com.lapis.clipboard.block;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font; // Добавьте этот импорт
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ClipboardBlockRenderer implements BlockEntityRenderer<ClipBoardBlockEntity> {
    private final Font font; // Объявляем поле font

    public ClipboardBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont(); // инициализируем font из контекста
    }

    @Override
    public void render(ClipBoardBlockEntity entity, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        // Проверяем, что текст не пустой
        if (entity.getText().isEmpty()) return;

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);
        this.font.drawInBatch(
                entity.getText(),
                -this.font.width(entity.getText()) / 2f, // используем this.font
                0,
                0xFFFFFF,
                false,
                poseStack.last().pose(),
                buffer,
                Font.DisplayMode.NORMAL,
                0,
                packedLight
        );
        poseStack.popPose();
    }
}