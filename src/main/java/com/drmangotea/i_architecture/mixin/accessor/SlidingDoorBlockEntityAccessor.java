package com.drmangotea.i_architecture.mixin.accessor;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlockEntity;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import net.createmod.catnip.animation.LerpedFloat;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SlidingDoorBlockEntity.class)
public interface SlidingDoorBlockEntityAccessor {

    @Accessor("animation")
    LerpedFloat i_architecture$getAnimation();

    @Invoker("shouldRenderSpecial")
    boolean i_architecture$shouldRenderSpecial(BlockState state);
}
