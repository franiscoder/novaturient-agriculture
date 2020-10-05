package io.github.franiscoder.novaturient.client;

import io.github.franiscoder.novaturient.blockentity.MortarBlockEntity;
import io.github.franiscoder.novaturient.init.ModItems;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;

public class MortarBlockEntityRenderer extends BlockEntityRenderer<MortarBlockEntity> {
    private static final ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
    private float rotationTicks = 0;

    private static final ItemStack PESTLE_STACK = new ItemStack(ModItems.RENDERED_PESTLE);
    private final ItemStack PASTE_STACK = new ItemStack(ModItems.RENDERED_PASTE);

    public MortarBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    /*
    DISCLAIMER: This is ugly hacks!
    Because I don't get how direct baked model rendering works, I registered two new items - one for the pestle and one
    for the paste! The `Color` tag on the paste stack is used to tint the paste. There is *definitely* a better way to
    do this, but I sure as hell don't know it.
     */
    @Override
    public void render(MortarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5F, 0.5F, 0.5F);
        int surfaceLight = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        //Update the position of rotation! When it's not rotating, make it stay in the place it stopped.
        if (entity.isSpinning()) {
            rotationTicks += tickDelta * 2; //Change me to adjust the speed of rotation!
            rotationTicks %= 360;
        }
        matrices.push();
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(rotationTicks));
        itemRenderer.renderItem(PESTLE_STACK, ModelTransformation.Mode.NONE, surfaceLight, overlay, matrices, vertexConsumers);
        matrices.pop();
        //Only show if there's currently paste!
        if (entity.hasPaste()) {
            //Set the local stack to have the right color of paste, handled through color providers.
            PASTE_STACK.getOrCreateTag().putInt("Color", entity.getPasteColor());
            itemRenderer.renderItem(PASTE_STACK, ModelTransformation.Mode.NONE, surfaceLight, overlay, matrices, vertexConsumers);
        }
        matrices.pop();
        //TODO: items once the BE has an inventory
    }
}
