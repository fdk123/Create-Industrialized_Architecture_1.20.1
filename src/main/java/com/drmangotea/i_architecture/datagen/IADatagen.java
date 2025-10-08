package com.drmangotea.i_architecture.datagen;


import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.datagen.recipes.IARecipeProvider;
import com.drmangotea.i_architecture.datagen.recipes.IAStandardRecipeGen;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;


public class IADatagen {
    public static void gatherDataHighPriority(GatherDataEvent event) {
        if (event.getMods().contains(IndustrializedArchitecture.MOD_ID))
            addExtraRegistrateData();
    }
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
       CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();



        generator.addProvider(event.includeServer(),new IAStandardRecipeGen(output,lookupProvider));




    }

    private static void addExtraRegistrateData() {

        REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;

            provideDefaultLang("interface", langConsumer);
            provideDefaultLang("tooltips", langConsumer);


        });
    }




    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/i_architecture/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }

}
