package com.drmangotea.i_architecture.content.blocks.metal_window;

import com.drmangotea.i_architecture.registry.IABlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MetalWindowBlock extends TransparentBlock {
    public MetalWindowBlock(Properties p_309186_) {
        super(p_309186_);
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(IABlocks.METAL_WINDOW.getNormal()) || adjacentBlockState.is(IABlocks.METAL_WINDOW.getSlightlyRusted()) || adjacentBlockState.is(IABlocks.METAL_WINDOW.getRusted()) || super.skipRendering(state, adjacentBlockState, side);
    }
}
