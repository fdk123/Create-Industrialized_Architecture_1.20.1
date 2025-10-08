package com.drmangotea.i_architecture.datagen.recipes;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.drmangotea.i_architecture.registry.IAItems;
import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.simibubi.create.AllTags.commonItemTag;

@ParametersAreNonnullByDefault
public class IARecipeProvider extends RecipeProvider {

    static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();

    protected final List<GeneratedRecipe> all = new ArrayList<>();

    public IARecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        all.forEach(c -> c.register(pRecipeOutput));
        IndustrializedArchitecture.LOGGER.info("{} registered {} recipe{}", getName(), all.size(), all.size() == 1 ? "" : "s");
    }


    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(RecipeOutput output);
    }

    public static class Marker {
    }


    public static class I {


        public static ItemLike darkBrick() {
            return IAItems.DARK_BRICK.get();
        }
        public static ItemLike sootBrick() {
            return IAItems.SOOT_BRICK.get();
        }
        public static ItemLike ashBrick() {
            return IAItems.ASH_BRICK.get();
        }
        public static ItemLike sandyBrick() {
            return IAItems.SANDY_BRICK.get();
        }
        public static ItemLike muddyBrick() {
            return IAItems.MUDDY_BRICK.get();
        }

        public static ItemLike roofShingle() {
            return IAItems.ROOF_SHINGLE.get();
        }

        public static ItemLike foggyGlassTiles() {
            return IAItems.FOGGY_GLASS_TILE.get();
        }

        public static ItemLike ceramicTile() {
            return IAItems.CERAMIC_TILE.get();
        }

        public static ItemLike metalPlateBlock() {
            return IABlocks.METAL_PLATE_BLOCK.getNormal();
        }

        public static ItemLike brassPlating() {
            return IABlocks.BRASS_PLATING;
        }

        public static TagKey<Item> industrialIron(){
            return commonItemTag("ingots/industrial_iron");
        }


    }


}