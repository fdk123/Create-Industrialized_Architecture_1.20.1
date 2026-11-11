package com.drmangotea.i_architecture.content.blocks.catwalks;

import com.drmangotea.i_architecture.content.blocks.IAHorizontalDirectionalBlock;
import com.drmangotea.i_architecture.registry.IAShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CatwalkStairsBlock extends IAHorizontalDirectionalBlock {
    public CatwalkStairsBlock(Properties p_54120_) {
        super(p_54120_);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return IAShapes.CATWALK_STAIRS.get(state.getValue(FACING));
    }
}
