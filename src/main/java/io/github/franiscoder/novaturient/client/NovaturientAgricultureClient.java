package io.github.franiscoder.novaturient.client;

import io.github.franiscoder.novaturient.init.ModBlocks;
import io.github.franiscoder.novaturient.init.ModItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class NovaturientAgricultureClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(ModBlocks.MORTAR_BE, MortarBlockEntityRenderer::new);
        ColorProviderRegistry.ITEM.register((stack, layer) -> stack.getOrCreateTag().getInt("Color"), ModItems.RENDERED_PASTE);
    }
}
