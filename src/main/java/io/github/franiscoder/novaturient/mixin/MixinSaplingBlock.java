package io.github.franiscoder.novaturient.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(SaplingBlock.class)
public abstract class MixinSaplingBlock extends Block {

    @Shadow public abstract void generate(ServerWorld serverWorld, BlockPos blockPos, BlockState blockState, Random random);

    public MixinSaplingBlock(Settings settings) {
        super(settings);
    }

    /**
     * @author franiscoder
     * @reason mixin doesn't support flow control changes
     */
    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(5) == 0) {
            this.generate(world, pos, state, random);
            world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
        }
    }
}
