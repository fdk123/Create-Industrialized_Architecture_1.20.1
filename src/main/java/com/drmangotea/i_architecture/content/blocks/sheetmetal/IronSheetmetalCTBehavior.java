package com.drmangotea.i_architecture.content.blocks.sheetmetal;

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

public class IronSheetmetalCTBehavior extends ConnectedTextureBehaviour.Base {

	public IronSheetmetalCTBehavior() {
	}

	@Override
	public boolean connectsTo(BlockState state, BlockState other, BlockAndTintGetter reader, BlockPos pos, BlockPos otherPos, Direction face) {


		if(face.getAxis().isVertical())
			return false;

		if(!other.is(IABlocks.IRON_SHEETMETAL.getNormal())&&!other.is(IABlocks.IRON_SHEETMETAL.getSlightlyRusted())&&!other.is(IABlocks.IRON_SHEETMETAL.getRusted()))
			return false;

		return true;
	}

	@Override
	public CTSpriteShiftEntry getShift(BlockState state, Direction direction, @Nullable TextureAtlasSprite sprite) {

		if(state.is(IABlocks.IRON_SHEETMETAL.getNormal()))
			return IASpriteShifts.SHEETMETAL;
		if(state.is(IABlocks.IRON_SHEETMETAL.getSlightlyRusted()))
			return IASpriteShifts.SLIGHTLY_RUSTED_SHEETMETAL;
		if(state.is(IABlocks.IRON_SHEETMETAL.getRusted()))
			return IASpriteShifts.RUSTED_SHEETMETAL;


		return null;

	}
}