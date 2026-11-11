package com.drmangotea.i_architecture.content.blocks.metal_window;

import com.drmangotea.i_architecture.base.IASpriteShifts;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class MetalWindowCTBehavior extends ConnectedTextureBehaviour.Base {

	public MetalWindowCTBehavior() {
	}

	@Override
	public boolean connectsTo(BlockState state, BlockState other, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {


		if(face.getAxis().isVertical())
			return false;

		if(!other.is(IABlocks.METAL_WINDOW.getNormal().get())&&
				!other.is(IABlocks.METAL_WINDOW.getSlightlyRusted().get())&&
				!other.is(IABlocks.METAL_WINDOW.getRusted().get()))
			return false;

		return true;
	}

	@Override
	public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {

		if(state.is(IABlocks.METAL_WINDOW.getNormal().get()))
			return IASpriteShifts.METAL_WINDOW;
		if(state.is(IABlocks.METAL_WINDOW.getSlightlyRusted().get()))
			return IASpriteShifts.SLIGHTLY_RUSTED_METAL_WINDOW;
		if(state.is(IABlocks.METAL_WINDOW.getRusted().get()))
			return IASpriteShifts.RUSTED_METAL_WINDOW;


		return null;

	}
}