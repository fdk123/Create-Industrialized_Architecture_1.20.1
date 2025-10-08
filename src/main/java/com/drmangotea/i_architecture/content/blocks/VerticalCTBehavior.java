package com.drmangotea.i_architecture.content.blocks;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class VerticalCTBehavior extends ConnectedTextureBehaviour.Base {
	CTSpriteShiftEntry shift;
	public VerticalCTBehavior(CTSpriteShiftEntry shift) {
		this.shift = shift;
	}

	@Override
	public boolean connectsTo(BlockState state, BlockState other, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {


		if(face.getAxis().isVertical())
			return false;



		return other.is(state.getBlock());
	}

	@Override
	public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {

		return shift;

	}
}