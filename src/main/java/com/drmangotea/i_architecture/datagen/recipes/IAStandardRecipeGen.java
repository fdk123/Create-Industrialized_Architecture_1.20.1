package com.drmangotea.i_architecture.datagen.recipes;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.drmangotea.i_architecture.registry.IAItems;
import com.google.common.base.Supplier;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static com.drmangotea.i_architecture.datagen.recipes.IARecipeProvider.I.*;

public class IAStandardRecipeGen extends IARecipeProvider {
    private Marker MATERIALS = enterFolder("materials");
    public static final Map<String, ItemLike> DYES_FROM_COLOR = new HashMap<>();


    static {
        DYES_FROM_COLOR.put("white", Items.WHITE_DYE);
        DYES_FROM_COLOR.put("blue", Items.BLUE_DYE);
        DYES_FROM_COLOR.put("light_blue", Items.LIGHT_BLUE_DYE);
        DYES_FROM_COLOR.put("red", Items.RED_DYE);
        DYES_FROM_COLOR.put("green", Items.GREEN_DYE);
        DYES_FROM_COLOR.put("lime", Items.LIME_DYE);
        DYES_FROM_COLOR.put("pink", Items.PINK_DYE);
        DYES_FROM_COLOR.put("magenta", Items.MAGENTA_DYE);
        DYES_FROM_COLOR.put("yellow", Items.YELLOW_DYE);
        DYES_FROM_COLOR.put("gray", Items.GRAY_DYE);
        DYES_FROM_COLOR.put("light_gray", Items.LIGHT_GRAY_DYE);
        DYES_FROM_COLOR.put("brown", Items.BROWN_DYE);
        DYES_FROM_COLOR.put("cyan", Items.CYAN_DYE);
        DYES_FROM_COLOR.put("purple", Items.PURPLE_DYE);
        DYES_FROM_COLOR.put("orange", Items.ORANGE_DYE);
        DYES_FROM_COLOR.put("black", Items.BLACK_DYE);


    }

    GeneratedRecipe
            DARK_BRICKS = create(IABlocks.DARK_BRICKS)
            .unlockedBy(IAItems.DARK_BRICK::get)
            .viaShaped(b -> b
                    .define('B', darkBrick())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("   ")),
            SANDY_BRICKS = create(IABlocks.SANDY_BRICKS)
                    .unlockedBy(IAItems.SANDY_BRICK::get)
                    .viaShaped(b -> b
                            .define('B', sandyBrick())
                            .pattern("BB ")
                            .pattern("BB ")
                            .pattern("   ")),
            ASH_BRICKS = create(IABlocks.ASH_BRICKS)
                    .unlockedBy(IAItems.ASH_BRICK::get)
                    .viaShaped(b -> b
                            .define('B', ashBrick())
                            .pattern("BB ")
                            .pattern("BB ")
                            .pattern("   ")),
            SOOT_BRICKS = create(IABlocks.SOOT_BRICKS)
                    .unlockedBy(IAItems.SOOT_BRICK::get)
                    .viaShaped(b -> b
                            .define('B', sootBrick())
                            .pattern("BB ")
                            .pattern("BB ")
                            .pattern("   ")),
            MUDDY_BRICKS = create(IABlocks.MUDDY_BRICKS)
                    .unlockedBy(IAItems.MUDDY_BRICK::get)
                    .viaShaped(b -> b
                            .define('B', muddyBrick())
                            .pattern("BB ")
                            .pattern("BB ")
                            .pattern("   ")),

    HALF_DARK_BRICKS = create(IABlocks.HALF_DARK_BRICKS)
            .unlockedBy(IAItems.DARK_BRICK::get)
            .viaShaped(b -> b
                    .define('B', IABlocks.DARK_BRICKS_SET.slab)
                    .define('G', IABlocks.CERAMIC_TILE_SET.slab)
                    .pattern("B  ")
                    .pattern("G  ")
                    .pattern("   ")),

    HALF_CERAMIC_TILE = create(IABlocks.HALF_CERAMIC_TILE)
            .unlockedBy(IAItems.DARK_BRICK::get)
            .viaShaped(b -> b
                    .define('B', IABlocks.DARK_BRICKS_SET.slab)
                    .define('G', IABlocks.CERAMIC_TILE_SET.slab)
                    .pattern("G  ")
                    .pattern("B  ")
                    .pattern("   ")),

    COMPOSITE_DARK_BRICKS = create(IABlocks.COMPOSITE_DARK_BRICKS)
            .unlockedBy(IAItems.DARK_BRICK::get)
            .viaShaped(b -> b
                    .define('B', darkBrick())
                    .define('C', ceramicTile())
                    .pattern("CB ")
                    .pattern("CB ")
                    .pattern("   ")),

    CERAMIC_TILES = create(IABlocks.CERAMIC_TILES).returns(2)
            .unlockedBy(IAItems.CERAMIC_TILE::get)
            .viaShaped(b -> b
                    .define('B', ceramicTile())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("   ")),

    ROOF_SHINGLES = create(IABlocks.ROOF_SHINGLES)
            .unlockedBy(IAItems.ROOF_SHINGLE::get)
            .viaShaped(b -> b
                    .define('B', roofShingle())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("   ")),

    FOGGY_GLASS_TILES = create(IABlocks.FOGGY_GLASS_TILES)
            .unlockedBy(IAItems.FOGGY_GLASS_TILE::get)
            .viaShaped(b -> b
                    .define('B', foggyGlassTiles())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("   ")),


    METAL_PLATE_BLOCK = create(IABlocks.METAL_PLATE_BLOCK.getNormal()).returns(8)
            .unlockedBy(IAItems.INDUSTRIAL_IRON_INGOT::get)
            .viaShaped(b -> b
                    .define('B', industrialIron())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("   ")),

    METAL_PLATE_LIGHT = create(IABlocks.METAL_PLATE_LIGHT.getNormal()).returns(2)
            .unlockedBy(IABlocks.METAL_PLATE_BLOCK::getNormal)
            .viaShaped(b -> b
                    .define('B', metalPlateBlock())
                    .define('G', Items.GLOWSTONE_DUST)
                    .pattern("BG ")
                    .pattern("GB ")
                    .pattern("   ")),

    BRASS_LIGHT = create(IABlocks.BRASS_LIGHT).returns(2)
            .unlockedBy(AllItems.BRASS_INGOT::get)
            .viaShaped(b -> b
                    .define('B', brassPlating())
                    .define('G', Items.GLOWSTONE_DUST)
                    .pattern("BG ")
                    .pattern("GB ")
                    .pattern("   ")),

    METAL_VENT = create(IABlocks.METAL_VENT.getNormal()).returns(2)
            .unlockedBy(IABlocks.METAL_PLATE_BLOCK::getNormal)
            .viaShaped(b -> b
                    .define('B', metalPlateBlock())
                    .define('G', Blocks.IRON_BARS)
                    .pattern("BG ")
                    .pattern("GB ")
                    .pattern("   ")),

    METAL_WINDOW = create(IABlocks.METAL_WINDOW.getNormal()).returns(2)
            .unlockedBy(IABlocks.METAL_PLATE_BLOCK::getNormal)
            .viaShaped(b -> b
                    .define('B', metalPlateBlock())
                    .define('G', AllPaletteBlocks.FRAMED_GLASS.get())
                    .pattern("BG ")
                    .pattern("GB ")
                    .pattern("   ")),

    BRASS_WINDOW = create(IABlocks.BRASS_WINDOW).returns(2)
            .unlockedBy(AllItems.BRASS_INGOT::get)
            .viaShaped(b -> b
                    .define('B', brassPlating())
                    .define('G', AllPaletteBlocks.FRAMED_GLASS.get())
                    .pattern("BG ")
                    .pattern("GB ")
                    .pattern("   ")),

    METAL_DOOR = create(IABlocks.METAL_DOOR.getNormal())
            .unlockedBy(IABlocks.METAL_PLATE_BLOCK::getNormal)
            .viaShaped(b -> b
                    .define('B', metalPlateBlock())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("BB ")),

    FOLDING_METAL_DOOR = create(IABlocks.FOLDING_METAL_DOOR.getNormal())
            .unlockedBy(IABlocks.METAL_PLATE_BLOCK::getRusted)
            .viaShaped(b -> b
                    .define('B', metalPlateBlock())
                    .pattern("B B")
                    .pattern("B B")
                    .pattern("B B")),

    BRASS_DOOR = create(IABlocks.BRASS_DOOR)
            .unlockedBy(IABlocks.BRASS_PLATING::get)
            .viaShaped(b -> b
                    .define('B', brassPlating())
                    .pattern("BB ")
                    .pattern("BB ")
                    .pattern("BB ")),

    FOLDING_BRASS_DOOR = create(IABlocks.FOLDING_BRASS_DOOR)
            .unlockedBy(IABlocks.BRASS_PLATING::get)
            .viaShaped(b -> b
                    .define('B', brassPlating())
                    .pattern("B B")
                    .pattern("B B")
                    .pattern("B B"));
    private String currentFolder = "";

    private Marker enterFolder(String folder) {
        currentFolder = folder;
        return new Marker();
    }

    private GeneratedRecipeBuilder create(Supplier<? extends ItemLike> result) {
        return new GeneratedRecipeBuilder(currentFolder, result);
    }

    private GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike> result) {
        return create(result::get);
    }

    private class GeneratedRecipeBuilder {
        private final String folder;
        private final Supplier<? extends ItemLike> result;
        private Supplier<? extends ItemLike> unlock;
        private int amount = 1;

        private GeneratedRecipeBuilder(String folder, Supplier<? extends ItemLike> result) {
            this.folder = folder;
            this.result = result;
        }

        private GeneratedRecipeBuilder returns(int count) {
            amount = count;
            return this;
        }

        private GeneratedRecipeBuilder unlockedBy(Supplier<? extends ItemLike> item) {
            unlock = item;
            return this;
        }

        private GeneratedRecipe viaShaped(UnaryOperator<ShapedRecipeBuilder> builder) {
            return register(consumer -> {
                ShapedRecipeBuilder recipe = builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), amount));
                if (unlock != null)
                    recipe.unlockedBy("has_item", has(unlock.get()));
                ResourceLocation key = BuiltInRegistries.ITEM.getKey(result.get().asItem());
                recipe.save(consumer, IndustrializedArchitecture.asResource("crafting/" + folder + "/" + key.getPath()));
            });
        }
    }

    public IAStandardRecipeGen(PackOutput output) {
        super(output);
    }
}
