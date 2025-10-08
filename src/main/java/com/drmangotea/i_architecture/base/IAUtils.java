package com.drmangotea.i_architecture.base;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

public class IAUtils {

    public static final String BRICKS = "bricks";
    public static final String METAL = "metal";
    public static final String SLIGHTLY_RUSTED_METAL = "metal/slightly_rusted";
    public static final String RUSTED_METAL = "metal/rusted";
    public static final String CERAMIC = "ceramic";

    public static void makeVariants(RustedBlockVariants<?> variants) {
        for (int i = 0; i < 3; i++) {
            makeVariants(variants.getValues()[i], i == 0 ? METAL : i == 1 ? SLIGHTLY_RUSTED_METAL : RUSTED_METAL);
        }
    }

    public static MaterialSet makeVariants(BlockEntry<?> blockEntry, String category) {
        MaterialSet materialSet = new MaterialSet();

        materialSet.block = blockEntry;

        String name = blockEntry.getId().toString().replace("i_architecture:", "");


        materialSet.wall = REGISTRATE.block(name + "_wall", WallBlock::new)
                .initialProperties(() -> blockEntry.get())
                .transform(pickaxeOnly())
                .blockstate((c, p) -> IAVanillaBlockStates.generateWallBlockState(c, p, category.isEmpty() ? name : category + "/" + name))
                .tag(BlockTags.NEEDS_STONE_TOOL)
                .tag(BlockTags.WALLS)
                .recipe((c, p) -> {
                    p.stonecutting(DataIngredient.items(blockEntry.asItem()), RecipeCategory.BUILDING_BLOCKS, c::get, 6);
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 6)
                            .pattern("   ")
                            .pattern("AAA")
                            .pattern("AAA")
                            .define('A', blockEntry)
                            .unlockedBy("has_" + c.getName(), has(c.get()))
                            .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                })
                .item()
                .transform(b -> IAVanillaBlockStates.transformWallItem(b, category.isEmpty() ? name : category + "/" + name))
                .build()
                .register();

        materialSet.slab = REGISTRATE.block(name + "_slab", SlabBlock::new)
                .initialProperties(() -> blockEntry.get())
                .properties(p -> p.requiresCorrectToolForDrops())
                .transform(pickaxeOnly())
                .blockstate((ctx, p) -> IAVanillaBlockStates.generateSlabBlockState(ctx, p, name, category))
                .tag(BlockTags.NEEDS_STONE_TOOL)
                .tag(BlockTags.SLABS)
                .recipe((c, p) -> {
                    p.stonecutting(DataIngredient.items(blockEntry.asItem()), RecipeCategory.BUILDING_BLOCKS, c::get, 2);
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 6)
                            .pattern("   ")
                            .pattern("AAA")
                            .pattern("   ")
                            .define('A', blockEntry)
                            .unlockedBy("has_" + c.getName(), has(c.get()))
                            .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                })
                .item()
                .transform(customItemModel(name + "_bottom"))
                .register();

        materialSet.stairs = REGISTRATE.block(name + "_stairs", p -> new StairBlock((blockEntry.getDefaultState()), p))
                .initialProperties(() -> Blocks.STONE)
                .transform(pickaxeOnly())
                .blockstate((c, p) -> IAVanillaBlockStates.generateStairBlockState(c, p, name, category))
                .tag(BlockTags.NEEDS_STONE_TOOL)
                .tag(BlockTags.STAIRS)
                .recipe((c, p) -> {
                    p.stonecutting(DataIngredient.items(blockEntry.asItem()), RecipeCategory.BUILDING_BLOCKS, c::get, 1);
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 3)
                            .pattern("A  ")
                            .pattern("AA ")
                            .pattern("AAA")
                            .define('A', blockEntry)
                            .unlockedBy("has_" + c.getName(), has(c.get()))
                            .save(p, IndustrializedArchitecture.asResource("crafting/" + c.getName()));
                })
                .item()
                .transform(customItemModel(name + "_stairs"))
                .register();

        return materialSet;
    }


    public static <T extends Block> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> iASimpleBlockState(String category) {

        return (ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(ctx.getName(), IndustrializedArchitecture.asResource("block/" + category + "/" + ctx.getName())));
    }


    public static String getPath(String name, String category) {
        return category + "/" + name;

    }


}
