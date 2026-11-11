package com.drmangotea.i_architecture.datagen.recipes;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.drmangotea.i_architecture.registry.IAItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.drmangotea.i_architecture.base.IAUtils.commonItemTag;

public class IARecipeProvider extends RecipeProvider {
    protected final List<GeneratedRecipe> all = new ArrayList<>();

    public IARecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        all.forEach(recipe -> recipe.register(consumer));
        IndustrializedArchitecture.LOGGER.info("{} registered {} recipes", getName(), all.size());
    }

    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(Consumer<FinishedRecipe> consumer);
    }

    public static class Marker {}

    public static class I {
        public static ItemLike darkBrick() { return IAItems.DARK_BRICK.get(); }
        public static ItemLike sootBrick() { return IAItems.SOOT_BRICK.get(); }
        public static ItemLike ashBrick() { return IAItems.ASH_BRICK.get(); }
        public static ItemLike sandyBrick() { return IAItems.SANDY_BRICK.get(); }
        public static ItemLike muddyBrick() { return IAItems.MUDDY_BRICK.get(); }
        public static ItemLike roofShingle() { return IAItems.ROOF_SHINGLE.get(); }
        public static ItemLike foggyGlassTiles() { return IAItems.FOGGY_GLASS_TILE.get(); }
        public static ItemLike ceramicTile() { return IAItems.CERAMIC_TILE.get(); }
        public static ItemLike metalPlateBlock() { return IABlocks.METAL_PLATE_BLOCK.getNormal(); }
        public static ItemLike brassPlating() { return IABlocks.BRASS_PLATING.get(); }
        public static TagKey<Item> industrialIron() { return commonItemTag("ingots/industrial_iron"); }
    }
}
