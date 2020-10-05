package io.github.franiscoder.novaturient;

import io.github.franiscoder.novaturient.init.ModBlocks;
import io.github.franiscoder.novaturient.init.ModItems;

import net.fabricmc.api.ModInitializer;

public class NovaturientAgriculture implements ModInitializer {
    public static final String MODID = "novaagri";


    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
    }
}
