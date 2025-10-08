package com.drmangotea.i_architecture.registry;

import com.drmangotea.i_architecture.base.IABuilderTransformers;
import com.drmangotea.i_architecture.base.IASpriteShifts;
import com.drmangotea.i_architecture.base.MaterialSet;
import com.drmangotea.i_architecture.base.RustedBlockVariants;
import com.drmangotea.i_architecture.content.blocks.*;
import com.drmangotea.i_architecture.content.blocks.catwalks.BaseCatwalkBlock;
import com.drmangotea.i_architecture.content.blocks.catwalks.CatwalkBlock;
import com.drmangotea.i_architecture.content.blocks.catwalks.CatwalkCTBehaviour;
import com.drmangotea.i_architecture.content.blocks.catwalks.CatwalkStairsBlock;
import com.drmangotea.i_architecture.content.blocks.doors.IASlidingDoorBlock;
import com.drmangotea.i_architecture.content.blocks.VerticalCTBehavior;
import com.drmangotea.i_architecture.content.blocks.metal_window.MetalWindowBlock;
import com.drmangotea.i_architecture.content.blocks.metal_window.MetalWindowCTBehavior;
import com.drmangotea.i_architecture.content.blocks.railings.RailingBlock;
import com.drmangotea.i_architecture.content.blocks.railings.RailingBlockItem;
import com.drmangotea.i_architecture.content.blocks.sheetmetal.IronSheetmetalCTBehavior;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;
import static com.drmangotea.i_architecture.base.IABuilderTransformers.createRustedRecipe;
import static com.drmangotea.i_architecture.base.IAUtils.*;
import static com.drmangotea.i_architecture.base.RustedBlockVariants.convertToFolder;
import static com.simibubi.create.AllTags.commonItemTag;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

@SuppressWarnings("removal")
public class IABlocks {
    //-----BRICKS-----//

    public static final BlockEntry<IAHorizontalDirectionalBlock> COMPOSITE_DARK_BRICKS =
            REGISTRATE.block("composite_dark_bricks", IAHorizontalDirectionalBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> HALF_DARK_BRICKS =
            REGISTRATE.block("half_dark_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> HALF_CERAMIC_TILE =
            REGISTRATE.block("half_ceramic_tile", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    /// //////////////////////////////
    public static final BlockEntry<OrnateBricksBlock> ORNATE_DARK_BRICKS =
            REGISTRATE.block("ornate_dark_bricks", OrnateBricksBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.DARK_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();


    public static final BlockEntry<Block> DARK_BRICKS =
            REGISTRATE.block("dark_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .blockstate(iASimpleBlockState(BRICKS))
                    .simpleItem()
                    .register();
    public static final MaterialSet DARK_BRICKS_SET = makeVariants(DARK_BRICKS, BRICKS);


    public static final BlockEntry<Block> DARK_BRICK_TILES =
            REGISTRATE.block("dark_brick_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.DARK_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet DARK_BRICK_TILES_SET = makeVariants(DARK_BRICK_TILES, BRICKS);

    public static final BlockEntry<Block> HORIZONTAL_DARK_BRICKS =
            REGISTRATE.block("horizontal_dark_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.DARK_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet HORIZONTAL_DARK_BRICKS_SET = makeVariants(HORIZONTAL_DARK_BRICKS, BRICKS);
    ///   ////////////////////
    public static final BlockEntry<OrnateBricksBlock> ORNATE_SANDY_BRICKS =
            REGISTRATE.block("ornate_sandy_bricks", OrnateBricksBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SANDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();


    public static final BlockEntry<Block> SANDY_BRICKS =
            REGISTRATE.block("sandy_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .blockstate(iASimpleBlockState(BRICKS))
                    .simpleItem()
                    .register();
    public static final MaterialSet SANDY_BRICKS_SET = makeVariants(SANDY_BRICKS, BRICKS);


    public static final BlockEntry<Block> SANDY_BRICK_TILES =
            REGISTRATE.block("sandy_brick_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SANDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet SANDY_BRICK_TILES_SET = makeVariants(SANDY_BRICK_TILES, BRICKS);

    public static final BlockEntry<Block> HORIZONTAL_SANDY_BRICKS =
            REGISTRATE.block("horizontal_sandy_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SANDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet HORIZONTAL_SANDY_BRICKS_SET = makeVariants(HORIZONTAL_SANDY_BRICKS, BRICKS);
    ///   ////////////////////
    public static final BlockEntry<OrnateBricksBlock> ORNATE_ASH_BRICKS =
            REGISTRATE.block("ornate_ash_bricks", OrnateBricksBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.ASH_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();


    public static final BlockEntry<Block> ASH_BRICKS =
            REGISTRATE.block("ash_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .blockstate(iASimpleBlockState(BRICKS))
                    .simpleItem()
                    .register();
    public static final MaterialSet ASH_BRICKS_SET = makeVariants(ASH_BRICKS, BRICKS);


    public static final BlockEntry<Block> ASH_BRICK_TILES =
            REGISTRATE.block("ash_brick_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.ASH_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet ASH_BRICK_TILES_SET = makeVariants(ASH_BRICK_TILES, BRICKS);

    public static final BlockEntry<Block> HORIZONTAL_ASH_BRICKS =
            REGISTRATE.block("horizontal_ash_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.ASH_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet HORIZONTAL_ASH_BRICKS_SET = makeVariants(HORIZONTAL_ASH_BRICKS, BRICKS);
    ///   ////////////////////
    public static final BlockEntry<OrnateBricksBlock> ORNATE_SOOT_BRICKS =
            REGISTRATE.block("ornate_soot_bricks", OrnateBricksBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SOOT_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();


    public static final BlockEntry<Block> SOOT_BRICKS =
            REGISTRATE.block("soot_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .blockstate(iASimpleBlockState(BRICKS))
                    .simpleItem()
                    .register();
    public static final MaterialSet SOOT_BRICKS_SET = makeVariants(SOOT_BRICKS, BRICKS);


    public static final BlockEntry<Block> SOOT_BRICK_TILES =
            REGISTRATE.block("soot_brick_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SOOT_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet SOOT_BRICK_TILES_SET = makeVariants(SOOT_BRICK_TILES, BRICKS);

    public static final BlockEntry<Block> HORIZONTAL_SOOT_BRICKS =
            REGISTRATE.block("horizontal_soot_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.SOOT_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet HORIZONTAL_SOOT_BRICKS_SET = makeVariants(HORIZONTAL_SOOT_BRICKS, BRICKS);
    ///   ////////////////////
    public static final BlockEntry<OrnateBricksBlock> ORNATE_MUDDY_BRICKS =
            REGISTRATE.block("ornate_muddy_bricks", OrnateBricksBlock::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.MUDDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();


    public static final BlockEntry<Block> MUDDY_BRICKS =
            REGISTRATE.block("muddy_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .transform(pickaxeOnly())
                    .blockstate(iASimpleBlockState(BRICKS))
                    .simpleItem()
                    .register();
    public static final MaterialSet MUDDY_BRICKS_SET = makeVariants(MUDDY_BRICKS, BRICKS);


    public static final BlockEntry<Block> MUDDY_BRICK_TILES =
            REGISTRATE.block("muddy_brick_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.MUDDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet MUDDY_BRICK_TILES_SET = makeVariants(MUDDY_BRICK_TILES, BRICKS);

    public static final BlockEntry<Block> HORIZONTAL_MUDDY_BRICKS =
            REGISTRATE.block("horizontal_muddy_bricks", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.TUFF))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.MUDDY_BRICKS.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(BRICKS))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet HORIZONTAL_MUDDY_BRICKS_SET = makeVariants(HORIZONTAL_MUDDY_BRICKS, BRICKS);
    ///   ////////////////////

    //-----CERAMIC-----//

    public static final BlockEntry<Block> CERAMIC_FLOORTILES =
            REGISTRATE.block("ceramic_floortiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                    )
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.CERAMIC_TILES.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(CERAMIC))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet CERAMIC_FLOORTILES_SET = makeVariants(CERAMIC_FLOORTILES, CERAMIC);

    public static final BlockEntry<Block> CERAMIC_TILES =
            REGISTRATE.block("ceramic_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                    )
                    .blockstate(iASimpleBlockState(CERAMIC))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet CERAMIC_TILES_SET = makeVariants(CERAMIC_TILES, CERAMIC);

    public static final BlockEntry<Block> CERAMIC_TILE =
            REGISTRATE.block("large_ceramic_tile", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                    )
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.CERAMIC_TILES.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .blockstate(iASimpleBlockState(CERAMIC))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet CERAMIC_TILE_SET = makeVariants(CERAMIC_TILE, CERAMIC);

    public static final BlockEntry<Block> LARGE_CERAMIC_TILES =
            REGISTRATE.block("large_ceramic_tiles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops()
                    )
                    .blockstate(iASimpleBlockState(CERAMIC))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.CERAMIC_TILES.asItem()), RecipeCategory.DECORATIONS, c, 1))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet LARGE_CERAMIC_TILES_SET = makeVariants(LARGE_CERAMIC_TILES, CERAMIC);

    //-----ROOFS-----//
    public static final BlockEntry<Block> ROOF_SHINGLES =
            REGISTRATE.block("roof_shingles", Block::new)
                    .properties(p -> p
                            .strength(3.0F)
                            .requiresCorrectToolForDrops())
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();
    public static final MaterialSet ROOF_SHINGLES_SET = makeVariants(ROOF_SHINGLES, "");


    //-----WINDOWS-----//
    public static final BlockEntry<TransparentBlock> FOGGY_GLASS_TILES =
            REGISTRATE.block("foggy_glass_tiles", TransparentBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .addLayer(() -> RenderType::translucent)
                    .simpleItem()
                    .register();
    public static final BlockEntry<FoggyGlassTilesPaneBlock> FOGGY_GLASS_TILES_PANE =
            REGISTRATE.block("foggy_glass_tiles_pane", FoggyGlassTilesPaneBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .addLayer(() -> RenderType::translucent)
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.FOGGY_GLASS_TILES.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .simpleItem()
                    .register();

    public static final BlockEntry<TransparentBlock> TALL_FOGGY_GLASS_TILES =
            REGISTRATE.block("tall_foggy_glass", TransparentBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.FOGGY_GLASS_TILES.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .addLayer(() -> RenderType::translucent)
                    .simpleItem()
                    .register();
    public static final BlockEntry<FoggyGlassTilesPaneBlock> TALL_FOGGY_GLASS_TILES_PANE =
            REGISTRATE.block("tall_foggy_glass_pane", FoggyGlassTilesPaneBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .addLayer(() -> RenderType::translucent)
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.TALL_FOGGY_GLASS_TILES.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .simpleItem()
                    .register();

    public static final BlockEntry<TransparentBlock> LONG_FOGGY_GLASS_TILES =
            REGISTRATE.block("long_foggy_glass", TransparentBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .onRegister(CreateRegistrate.connectedTextures(() -> new VerticalCTBehavior(IASpriteShifts.LONG_FOGGY_GLASS)))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.FOGGY_GLASS_TILES.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .addLayer(() -> RenderType::translucent)
                    .simpleItem()
                    .register();
    public static final BlockEntry<FoggyGlassTilesPaneBlock> LONG_FOGGY_GLASS_TILES_PANE =
            REGISTRATE.block("long_foggy_glass_pane", FoggyGlassTilesPaneBlock::new)
                    .initialProperties(() -> Blocks.GLASS)
                    .properties(p -> p.noOcclusion())
                    .addLayer(() -> RenderType::translucent)
                    .onRegister(CreateRegistrate.connectedTextures(() -> new VerticalCTBehavior(IASpriteShifts.LONG_FOGGY_GLASS)))
                    .recipe((c, p) ->
                            p.stonecutting(DataIngredient.items(IABlocks.TALL_FOGGY_GLASS_TILES.asItem()), RecipeCategory.DECORATIONS, c, 2))
                    .blockstate(BlockStateGen.horizontalBlockProvider(false))
                    .simpleItem()
                    .register();



    public static final RustedBlockVariants<MetalWindowBlock> METAL_WINDOW = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_window", MetalWindowBlock::new)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p
                        .noOcclusion()
                        .strength(3)
                        .requiresCorrectToolForDrops()
                )
                .transform(createRustedRecipe())
                .blockstate(iASimpleBlockState(convertToFolder(name)))
                .transform(pickaxeOnly())
                .onRegister(CreateRegistrate.connectedTextures(MetalWindowCTBehavior::new))
                .addLayer(() -> RenderType::translucent)
                .simpleItem()
                .register();
    });

    //-----LIGHTS-----//
    public static final RustedBlockVariants<Block> METAL_PLATE_LIGHT = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_plate_light", Block::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p
                        .sound(SoundType.NETHERITE_BLOCK)
                        .lightLevel(s -> 15)
                )
                .transform(createRustedRecipe())
                .blockstate(iASimpleBlockState(convertToFolder(name)))
                .transform(pickaxeOnly())
                .addLayer(() -> RenderType::cutoutMipped)
                .item()
                .build()
                .register();
    });

    //-----METAL-----//


    //IRON
    public static final RustedBlockVariants<Block> METAL_PLATE_BLOCK = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_plate_block", Block::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(createRustedRecipe())
                .transform(pickaxeOnly())
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(iASimpleBlockState(convertToFolder(name)))
                .item()
                .build()
                .register();
    });

    static {
        makeVariants(METAL_PLATE_BLOCK);
    }

    /// /////
    public static final RustedBlockVariants<Block> METAL_VENT = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_vent", Block::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe())
                .blockstate(iASimpleBlockState(convertToFolder(name)))
                .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
                .item()
                .build()
                .register();
    });

    /// /////////
    public static final RustedBlockVariants<Block> IRON_SHEETMETAL = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "iron_sheetmetal", Block::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.items(IABlocks.METAL_PLATE_BLOCK.getNormal().asItem()), RecipeCategory.DECORATIONS, c, 1)))
                .blockstate(iASimpleBlockState(convertToFolder(name)))
                .onRegister(CreateRegistrate.connectedTextures(IronSheetmetalCTBehavior::new))
                .item()
                .build()
                .register();
    });


    /// /////////

    public static final RustedBlockVariants<RotatedPillarBlock> METAL_PILLAR = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_pillar", RotatedPillarBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.items(IABlocks.METAL_PLATE_BLOCK.getNormal().asItem()), RecipeCategory.DECORATIONS, c, 1)))
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .item()
                .build()
                .register();
    });

    /// //////

    public static final RustedBlockVariants<TrussBlock> METAL_TRUSS = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_truss", TrussBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.noOcclusion())
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.tag(commonItemTag("ingots/industrial_iron")), RecipeCategory.DECORATIONS, c, 2)))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .item()
                .build()
                .register();
    });


    /// ////////
    public static final RustedBlockVariants<FrameBlock> METAL_FRAME = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_frame", FrameBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(p -> p.strength(3))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.tag(commonItemTag("ingots/industrial_iron")), RecipeCategory.DECORATIONS, c, 2)))
                .addLayer(() -> RenderType::cutoutMipped)
                .properties(BlockBehaviour.Properties::noOcclusion)
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
                .simpleItem()
                .register();
    });

    /// ///////


    public static final RustedBlockVariants<RailingBlock> METAL_RAILING = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_railing", RailingBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.noOcclusion())
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .blockstate(RailingBlock.metalRailing(name))
                .addLayer(() -> RenderType::cutoutMipped)
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.items(IAItems.INDUSTRIAL_IRON_INGOT.asItem()), RecipeCategory.DECORATIONS, c, 4)))
                .loot((lt, block) -> {
                    LootTable.Builder builder = LootTable.lootTable();
                    LootItemCondition.Builder hasNorthProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.NORTH, true));
                    LootItemCondition.Builder hasSouthProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.SOUTH, true));
                    LootItemCondition.Builder hasWestProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.WEST, true));
                    LootItemCondition.Builder hasEastProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.EAST, true));
                    lt.add(block, builder.withPool(LootPool.lootPool()
                            .when(hasNorthProperty)
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(block.asItem()))));
                    lt.add(block, builder.withPool(LootPool.lootPool()
                            .when(hasSouthProperty)
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(block.asItem()))));
                    lt.add(block, builder.withPool(LootPool.lootPool()
                            .when(hasWestProperty)
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(block.asItem()))));
                    lt.add(block, builder.withPool(LootPool.lootPool()
                            .when(hasEastProperty)
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(block.asItem()))));
                })
                .item(RailingBlockItem::new)
                .model(AssetLookup::customItemModel)
                .build()
                .register();

    });

    /// ////////////////

    public static final RustedBlockVariants<CatwalkBlock> METAL_CATWALK = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_catwalk", CatwalkBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.noOcclusion())
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .onRegister(CreateRegistrate.connectedTextures(CatwalkCTBehaviour::new))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
                .addLayer(() -> RenderType::cutoutMipped)
                .transform(createRustedRecipe((c, p) -> p.stonecutting(DataIngredient.items(IABlocks.METAL_FRAME.getNormal().asItem()), RecipeCategory.DECORATIONS, c, 2)))
                .item()
                .build()
                .register();
    });


    /// ///////////
    public static final RustedBlockVariants<BaseCatwalkBlock> TALL_METAL_CATWALK = new RustedBlockVariants<>(variant -> {

        String name = variant.getName();
        return REGISTRATE.block(name + "tall_metal_catwalk", BaseCatwalkBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.noOcclusion())
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .transform(pickaxeOnly())
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.items(IABlocks.METAL_FRAME.getNormal().asItem()), RecipeCategory.DECORATIONS, c, 1)))
                .onRegister(connectedTextures(CatwalkCTBehaviour::new))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
                .addLayer(() -> RenderType::cutoutMipped)
                .item()
                .build()
                .register();
    });


    public static final RustedBlockVariants<CatwalkStairsBlock> CATWALK_STAIRS = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "catwalk_stairs", CatwalkStairsBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p
                        .strength(3.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK))
                .transform(createRustedRecipe((c, p) ->
                        p.stonecutting(DataIngredient.items(IABlocks.METAL_FRAME.getNormal().asItem()), RecipeCategory.DECORATIONS, c, 2)))
                .blockstate(BlockStateGen.horizontalBlockProvider(false))
                .addLayer(() -> RenderType::cutoutMipped)
                .transform(pickaxeOnly())
                .simpleItem()
                .register();
    });
    //BRASS
    public static final BlockEntry<Block> BRASS_PLATING = REGISTRATE.block("brass_plating", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.tag(AllTags.commonItemTag("ingots/brass")), RecipeCategory.DECORATIONS, c, 4))
            .item()
            .build()
            .register();

    static {
        makeVariants(BRASS_PLATING, METAL);
    }

    public static final BlockEntry<Block> SHINY_BRASS_PLATING = REGISTRATE.block("shiny_brass_plating", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.items(IABlocks.BRASS_PLATING.asItem()), RecipeCategory.DECORATIONS, c, 1))
            .item()
            .build()
            .register();

    static {
        makeVariants(SHINY_BRASS_PLATING, METAL);
    }

    public static final BlockEntry<Block> BRASS_TILES = REGISTRATE.block("brass_tiles", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.items(IABlocks.BRASS_PLATING.asItem()), RecipeCategory.DECORATIONS, c, 1))
            .item()
            .build()
            .register();

    static {
        makeVariants(BRASS_TILES, METAL);
    }

    public static final BlockEntry<Block> ORNATE_BRASS_PLATING = REGISTRATE.block("ornate_brass_plating", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.items(IABlocks.BRASS_PLATING.asItem()), RecipeCategory.DECORATIONS, c, 1))
            .item()
            .build()
            .register();
    public static final BlockEntry<Block> BRASS_LIGHT = REGISTRATE.block("brass_light", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .properties(p -> p
                    .lightLevel(s -> 15)
            )
            .blockstate(iASimpleBlockState(METAL))
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .build()
            .register();
    public static final BlockEntry<MetalWindowBlock> BRASS_WINDOW = REGISTRATE.block("brass_window", MetalWindowBlock::new)
            .initialProperties(() -> Blocks.GLASS)
            .properties(p -> p
                    .noOcclusion()
                    .strength(3)
                    .requiresCorrectToolForDrops()
            )
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new VerticalCTBehavior(IASpriteShifts.BRASS_WINDOW)))
            .addLayer(() -> RenderType::translucent)
            .simpleItem()
            .register();
    public static final BlockEntry<Block> BRASS_SHEETMETAL = REGISTRATE.block("brass_sheetmetal", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .blockstate(iASimpleBlockState(METAL))
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.items(IABlocks.BRASS_PLATING.asItem()), RecipeCategory.DECORATIONS, c, 1))
            .onRegister(CreateRegistrate.connectedTextures(()->new VerticalCTBehavior(IASpriteShifts.BRASS_SHEETMETAL)))
            .item()
            .build()
            .register();

    public static final BlockEntry<RailingBlock> BRASS_RAILING = REGISTRATE.block("brass_railing", RailingBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.noOcclusion())
            .properties(p -> p.sound(SoundType.METAL))
            .transform(pickaxeOnly())
            .recipe((c, p) ->
                    p.stonecutting(DataIngredient.tag(AllTags.commonItemTag("ingots/brass")), RecipeCategory.DECORATIONS, c, 4))
            .addLayer(() -> RenderType::cutoutMipped)
            .transform(createRustedRecipe((c, p) ->
                    p.stonecutting(DataIngredient.tag(AllTags.commonItemTag("ingots/brass")), RecipeCategory.DECORATIONS, c, 4)))
            .blockstate(RailingBlock.railing("brass"))
            .loot((lt, block) -> {
                LootTable.Builder builder = LootTable.lootTable();
                LootItemCondition.Builder hasNorthProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.NORTH, true));
                LootItemCondition.Builder hasSouthProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.SOUTH, true));
                LootItemCondition.Builder hasWestProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.WEST, true));
                LootItemCondition.Builder hasEastProperty = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RailingBlock.EAST, true));
                lt.add(block, builder.withPool(LootPool.lootPool()
                        .when(hasNorthProperty)
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(block.asItem()))));
                lt.add(block, builder.withPool(LootPool.lootPool()
                        .when(hasSouthProperty)
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(block.asItem()))));
                lt.add(block, builder.withPool(LootPool.lootPool()
                        .when(hasWestProperty)
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(block.asItem()))));
                lt.add(block, builder.withPool(LootPool.lootPool()
                        .when(hasEastProperty)
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(block.asItem()))));
            })
            .item(RailingBlockItem::new)
            .model(AssetLookup::customItemModel)
            .build()
            .register();


    //-----DOORS-----//
    public static final RustedBlockVariants<IASlidingDoorBlock> METAL_DOOR = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "metal_door", p -> new IASlidingDoorBlock(p, SlidingDoorBlock.GLASS_SET_TYPE.get(), false))
                .transform(IABuilderTransformers.slidingDoor(name + "metal"))
                .transform(createRustedRecipe((c, p) -> {
                }))
                .properties(p -> p
                        .sound(SoundType.NETHERITE_BLOCK)
                        .noOcclusion())
                .register();
    });
    public static final RustedBlockVariants<IASlidingDoorBlock> FOLDING_METAL_DOOR = new RustedBlockVariants<>(variant -> {
        String name = variant.getName();
        return REGISTRATE.block(name + "folding_metal_door", p -> new IASlidingDoorBlock(p, SlidingDoorBlock.GLASS_SET_TYPE.get(), true))
                .transform(IABuilderTransformers.slidingDoor(name + "folding_metal"))
                .transform(createRustedRecipe((c, p) -> {
                }))
                .properties(p -> p
                        .sound(SoundType.NETHERITE_BLOCK)
                        .noOcclusion())
                .register();
    });

    public static final BlockEntry<IASlidingDoorBlock> BRASS_DOOR = REGISTRATE.block("brass_door", p -> new IASlidingDoorBlock(p, SlidingDoorBlock.GLASS_SET_TYPE.get(), false))
                .transform(IABuilderTransformers.slidingDoor("brass"))
                .properties(p -> p
                        .sound(SoundType.METAL)
                        .noOcclusion())
                .register();

    public static final BlockEntry<IASlidingDoorBlock> FOLDING_BRASS_DOOR = REGISTRATE.block("folding_brass_door", p -> new IASlidingDoorBlock(p, SlidingDoorBlock.GLASS_SET_TYPE.get(), true))
                .transform(IABuilderTransformers.slidingDoor("folding_brass"))
                .properties(p -> p
                        .sound(SoundType.METAL)
                        .noOcclusion())
                .register();


    public static void register() {
    }
}
