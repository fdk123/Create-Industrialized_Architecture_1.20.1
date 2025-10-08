package com.drmangotea.i_architecture.registry;

import com.drmangotea.i_architecture.content.blocks.doors.IASlidingDoorRenderer;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;

public class IABlockEntities {


    public static final BlockEntityEntry<SlidingDoorBlockEntity> SLIDING_DOOR =
            REGISTRATE.blockEntity("sliding_door", SlidingDoorBlockEntity::new)
                    .renderer(() -> IASlidingDoorRenderer::new)
                    .validBlocks(
                            IABlocks.FOLDING_METAL_DOOR.getNormal(),
                            IABlocks.METAL_DOOR.getNormal(),
                            IABlocks.FOLDING_METAL_DOOR.getSlightlyRusted(),
                            IABlocks.METAL_DOOR.getSlightlyRusted(),
                            IABlocks.FOLDING_METAL_DOOR.getRusted(),
                            IABlocks.METAL_DOOR.getRusted(),

                            IABlocks.FOLDING_BRASS_DOOR,
                            IABlocks.BRASS_DOOR
                    )
                    .register();


    public static void register() {
    }
}
