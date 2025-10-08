package com.drmangotea.i_architecture.content.blocks.doors;

import com.drmangotea.i_architecture.registry.IABlockEntities;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlockEntity;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockSetType;


public class IASlidingDoorBlock extends SlidingDoorBlock implements IWrenchable, IBE<SlidingDoorBlockEntity> {

	public IASlidingDoorBlock(Properties properties, BlockSetType type, boolean folds) {
		super(properties, type, folds);
	}

	@Override
	public Class<SlidingDoorBlockEntity> getBlockEntityClass() {
		return SlidingDoorBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends SlidingDoorBlockEntity> getBlockEntityType() {
		return IABlockEntities.SLIDING_DOOR.get();
	}

}
