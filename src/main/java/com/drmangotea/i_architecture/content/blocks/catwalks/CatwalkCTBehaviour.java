package com.drmangotea.i_architecture.content.blocks.catwalks;

import com.drmangotea.i_architecture.base.IASpriteShifts;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CatwalkCTBehaviour extends ConnectedTextureBehaviour.Base {
    @Override
    public @Nullable CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {

        if(state.is(IABlocks.METAL_CATWALK.getNormal())||state.is(IABlocks.TALL_METAL_CATWALK.getNormal()))
            return IASpriteShifts.CATWALK;
        if(state.is(IABlocks.METAL_CATWALK.getSlightlyRusted())||state.is(IABlocks.TALL_METAL_CATWALK.getSlightlyRusted()))
            return IASpriteShifts.SLIGHTLY_RUSTED_CATWALK;
        if(state.is(IABlocks.METAL_CATWALK.getRusted())||state.is(IABlocks.TALL_METAL_CATWALK.getRusted()))
            return IASpriteShifts.RUSTED_CATWALK;

       return null;
    }


    @Override
    public boolean connectsTo(BlockState state, BlockState other, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {



        if(pos.getY()!=otherPos.getY())
            return false;

        if(!(other.getBlock() instanceof BaseCatwalkBlock))
            return false;

        return true;
    }
}
