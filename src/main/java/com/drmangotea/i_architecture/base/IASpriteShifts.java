package com.drmangotea.i_architecture.base;


import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.createmod.catnip.render.SpriteShiftEntry;
import net.createmod.catnip.render.SpriteShifter;

import static com.drmangotea.i_architecture.base.IAUtils.*;

public class IASpriteShifts {

    public static final CTSpriteShiftEntry CATWALK = omni(METAL,"catwalk");
    public static final CTSpriteShiftEntry SLIGHTLY_RUSTED_CATWALK = omni(SLIGHTLY_RUSTED_METAL,"slightly_rusted_catwalk");
    public static final CTSpriteShiftEntry RUSTED_CATWALK = omni(RUSTED_METAL,"rusted_catwalk");

    public static final CTSpriteShiftEntry METAL_WINDOW = vertical(METAL,"metal_window");
    public static final CTSpriteShiftEntry SLIGHTLY_RUSTED_METAL_WINDOW = vertical(SLIGHTLY_RUSTED_METAL,"slightly_rusted_metal_window");
    public static final CTSpriteShiftEntry RUSTED_METAL_WINDOW = vertical(RUSTED_METAL,"rusted_metal_window");

    public static final CTSpriteShiftEntry SHEETMETAL = vertical(METAL,"iron_sheetmetal");
    public static final CTSpriteShiftEntry SLIGHTLY_RUSTED_SHEETMETAL = vertical(SLIGHTLY_RUSTED_METAL,"slightly_rusted_iron_sheetmetal");
    public static final CTSpriteShiftEntry RUSTED_SHEETMETAL = vertical(RUSTED_METAL,"rusted_iron_sheetmetal");
    /////////

    public static final CTSpriteShiftEntry BRASS_SHEETMETAL = vertical(METAL,"brass_sheetmetal");
    public static final CTSpriteShiftEntry BRASS_WINDOW = vertical(METAL,"brass_window");

    public static final CTSpriteShiftEntry LONG_FOGGY_GLASS = vertical("long_foggy_glass");

    ///////////////////////
    public static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    public static CTSpriteShiftEntry omni(String variant,String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, variant+"/"+name);
    }


    public static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL_KRYPPERS, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }

    private static CTSpriteShiftEntry vertical(String variant,String name) {
        return getCT(AllCTTypes.VERTICAL, variant+"/"+name);
    }



    /////

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, IndustrializedArchitecture.asResource("block/" + blockTextureName), IndustrializedArchitecture.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get(IndustrializedArchitecture.asResource(originalLocation), IndustrializedArchitecture.asResource(targetLocation));
    }

    public static void register(){}

}
