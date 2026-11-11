package com.drmangotea.i_architecture.content.blocks.metal_window;

import com.drmangotea.i_architecture.registry.IABlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MetalWindowBlock extends HalfTransparentBlock {
    public MetalWindowBlock(Properties p_309186_) {
        super(p_309186_);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(IABlocks.METAL_WINDOW.getNormal().get()) || adjacentBlockState.is(IABlocks.METAL_WINDOW.getSlightlyRusted().get()) || adjacentBlockState.is(IABlocks.METAL_WINDOW.getRusted().get()) || super.skipRendering(state, adjacentBlockState, side);
    }
}
