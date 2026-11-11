package com.drmangotea.i_architecture.registry;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.base.IAUtils;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

public class IAItems {
    public static final ItemEntry<Item>
            INDUSTRIAL_IRON_INGOT = taggedIngredient("industrial_iron_ingot", IAUtils.commonItemTag("ingots/industrial_iron"))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.items(Items.IRON_INGOT), RecipeCategory.MISC, c, 2))
            .register();

    public static final ItemEntry<Item>
            DARK_BRICK = REGISTRATE.item("dark_brick", Item::new)
            .recipe((c, p) -> {
                        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),4)
                                .pattern("CG ")
                                .pattern("GC ")
                                .pattern("   ")
                                .define('G', Items.BRICK)
                                .define('C', AllItems.CINDER_FLOUR)
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),8)
                                .pattern("GGG")
                                .pattern("GBG")
                                .pattern("GGG")
                                .define('G', Items.BRICK)
                                .define('B', Items.BLACK_DYE)
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()+"_from_black_dye"));
                    }
            )
            .register(),
            SANDY_BRICK = REGISTRATE.item("sandy_brick", Item::new)
                    .recipe((c, p) -> {
                                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),4)
                                        .pattern("CG ")
                                        .pattern("GC ")
                                        .pattern("   ")
                                        .define('G', Items.BRICK)
                                        .define('C', Blocks.SAND)
                                        .unlockedBy("has_" + c.getName(), has(c.get()))
                                        .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                            }
                    )
                    .register(),
            SOOT_BRICK = REGISTRATE.item("soot_brick", Item::new)
                    .recipe((c, p) -> {
                                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),4)
                                        .pattern("CG ")
                                        .pattern("GC ")
                                        .pattern("   ")
                                        .define('G', Items.BRICK)
                                        .define('C', ItemTags.COALS)
                                        .unlockedBy("has_" + c.getName(), has(c.get()))
                                        .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                                }
                    )
                    .register(),
            ASH_BRICK = REGISTRATE.item("ash_brick", Item::new)
                    .recipe((c, p) -> {
                                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),4)
                                        .pattern("CG ")
                                        .pattern("GC ")
                                        .pattern("   ")
                                        .define('G', Items.BRICK)
                                        .define('C', Blocks.BASALT)
                                        .unlockedBy("has_" + c.getName(), has(c.get()))
                                        .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),8)
                                .pattern("GGG")
                                .pattern("GBG")
                                .pattern("GGG")
                                .define('G', Items.BRICK)
                                .define('B', Items.GRAY_DYE)
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()+"_from_black_dye"));
                                }
                    )
                    .register(),
            MUDDY_BRICK = REGISTRATE.item("muddy_brick", Item::new)
                    .recipe((c, p) -> {
                                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(),4)
                                        .pattern("CG ")
                                        .pattern("GC ")
                                        .pattern("   ")
                                        .define('G', Items.BRICK)
                                        .define('C', Blocks.MUD)
                                        .unlockedBy("has_" + c.getName(), has(c.get()))
                                        .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                                }
                    )
                    .register(),

            ROOF_SHINGLE = REGISTRATE.item("roof_shingle", Item::new)
                    .recipe((c, p) ->
                            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 8)
                                    .pattern(" D ")
                                    .pattern("BBB")
                                    .pattern("   ")
                                    .define('B', Items.BRICK)
                                    .define('D', Items.BLACK_DYE)
                                    .unlockedBy("has_" + c.getName(), has(c.get()))
                                    .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()))
                    )
                    .register(),
            FOGGY_GLASS_TILE = REGISTRATE.item("foggy_glass_tile", Item::new)
                    .recipe((c, p) ->
                            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 4)
                                    .pattern("GG ")
                                    .pattern("GG ")
                                    .pattern("   ")
                                    .define('G', Blocks.GLASS_PANE)
                                    .unlockedBy("has_" + c.getName(), has(c.get()))
                                    .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()))
                    )
                    .register(),
            UNFIRED_CERAMIC_BALL = REGISTRATE.item("unfired_ceramic_ball", Item::new)
                    .recipe((c, p) ->
                            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, c.get(), 2)
                                    .requires(Items.CLAY_BALL)
                                    .requires(Blocks.SAND)
                                    .unlockedBy("has_" + c.getName(), has(c.get()))
                                    .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()))
                    )
                    .register(),
            CERAMIC_TILE = REGISTRATE.item("ceramic_tile", Item::new)
                    .recipe((c, p) -> {
                        SimpleCookingRecipeBuilder.smelting(
                                Ingredient.of(IAItems.UNFIRED_CERAMIC_BALL.get()), RecipeCategory.MISC, c.get(), 0.1F, 200)
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, IndustrializedArchitecture.asResource("smelting/" + c.getName()));


                        SimpleCookingRecipeBuilder.blasting(
                                Ingredient.of(IAItems.UNFIRED_CERAMIC_BALL.get()), RecipeCategory.MISC, c.get(), 0.1F, 100)
                                .unlockedBy("has_" + c.getName(), has(c.get()))
                                .save(p, IndustrializedArchitecture.asResource("blasting/" + c.getName()));
                    })
                    .register();


    @SafeVarargs
    private static ItemBuilder<Item, CreateRegistrate> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags);
    }

    public static void register() {
    }
}
