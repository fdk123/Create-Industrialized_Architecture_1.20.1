package com.drmangotea.i_architecture.content.blocks;

import com.drmangotea.i_architecture.registry.IAShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OrnateBricksBlock extends IAHorizontalDirectionalBlock{
    public OrnateBricksBlock(Properties p_54120_) {
        super(p_54120_);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return IAShapes.ORNATE_BRICKS.get(state.getValue(FACING));
    }
}
