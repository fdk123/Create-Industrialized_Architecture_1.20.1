package com.drmangotea.i_architecture;

import com.drmangotea.i_architecture.base.IACreativeTab;
import com.drmangotea.i_architecture.base.IASpriteShifts;
import com.drmangotea.i_architecture.datagen.IADatagen;
import com.drmangotea.i_architecture.registry.IABlockEntities;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.drmangotea.i_architecture.registry.IAItems;
import com.drmangotea.i_architecture.registry.IAPartialModels;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;


@Mod(IndustrializedArchitecture.MOD_ID)
public class IndustrializedArchitecture {

    public static final String MOD_ID = "i_architecture";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public IndustrializedArchitecture() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);
        IASpriteShifts.register();
        IACreativeTab.register(modEventBus);
        IAPartialModels.register();
        IAItems.register();
        IABlocks.register();
        IABlockEntities.register();

        modEventBus.addListener(IACreativeTab::addCreative);

        modEventBus.addListener(EventPriority.HIGHEST, IADatagen::gatherDataHighPriority);
        modEventBus.addListener(EventPriority.LOWEST, IADatagen::gatherData);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
