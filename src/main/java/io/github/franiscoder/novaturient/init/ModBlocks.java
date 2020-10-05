package io.github.franiscoder.novaturient.init;

import io.github.franiscoder.novaturient.NovaturientAgriculture;
import io.github.franiscoder.novaturient.block.MortarBlock;
import io.github.franiscoder.novaturient.blockentity.MortarBlockEntity;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class ModBlocks {
    //public static IvybushBlock IVYBUSH_BLOCK =

    //TODO: set up properly when it's not just testing
    public static final Block MORTAR = Registry.register(Registry.BLOCK, new Identifier(NovaturientAgriculture.MODID, "mortar"), new MortarBlock(FabricBlockSettings.of(Material.STONE).nonOpaque()));
    public static final BlockEntityType<MortarBlockEntity> MORTAR_BE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(NovaturientAgriculture.MODID, "mortar"),
            BlockEntityType.Builder.create(MortarBlockEntity::new, MORTAR).build(null));

    public static void register() {

    }
}
