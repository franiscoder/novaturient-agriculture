package io.github.franiscoder.novaturient.init;

import io.github.franiscoder.novaturient.NovaturientAgriculture;
import io.github.franiscoder.novaturient.item.YouShouldNotHaveThisItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //TODO: set up properly when it's not just testing
    public static final Item MORTAR = Registry.register(Registry.ITEM, new Identifier(NovaturientAgriculture.MODID, "mortar"), new BlockItem(ModBlocks.MORTAR, new Item.Settings().group(ItemGroup.MISC)));

    //TODO: less hacky way to still use json models?
    public static final Item RENDERED_PESTLE = Registry.register(Registry.ITEM, new Identifier(NovaturientAgriculture.MODID, "rendered_pestle"), new YouShouldNotHaveThisItem());
    public static final Item RENDERED_PASTE = Registry.register(Registry.ITEM, new Identifier(NovaturientAgriculture.MODID, "rendered_paste"), new YouShouldNotHaveThisItem());

    public static void register() {

    }
}
