package io.github.franiscoder.novaturient.blockentity;

import io.github.franiscoder.novaturient.init.ModBlocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class MortarBlockEntity extends BlockEntity {
    public MortarBlockEntity() {
        super(ModBlocks.MORTAR_BE);
    }

    //TODO: implement me in when you write the logic! I'm for the BER!
    public boolean isSpinning() {
        return true;
    }

    //TODO: implement me when you write the logic! I'm for the BER!
    public boolean hasPaste() {
        return true;
    }

    //TODO: implement me when you write the logic! I'm for the bER!
    public int getPasteColor() {
        return 0x5FEC94;
    }
}
