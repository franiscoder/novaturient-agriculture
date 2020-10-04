package io.github.franiscoder.novaturient.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

public class MixinSaplingBlock extends SaplingBlock {

    public MixinSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(5) == 0) {
            this.generate(world, pos, state, random);
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
        }
    }
}
