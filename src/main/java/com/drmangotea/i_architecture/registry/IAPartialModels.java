package com.drmangotea.i_architecture.registry;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.data.Couple;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class IAPartialModels {


    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();

    static {

        putFoldingDoor("folding_metal_door");
        putFoldingDoor("slightly_rusted_folding_metal_door");
        putFoldingDoor("rusted_folding_metal_door");

        putFoldingDoor("folding_brass_door");
    }
    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(IndustrializedArchitecture.asResource(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }
    private static PartialModel block(String path) {
        return PartialModel.of(IndustrializedArchitecture.asResource("block/" + path));
    }
    public static void register() {
    }
}
