package com.drmangotea.i_architecture.datagen.recipes;


import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.registry.IABlocks;
import com.drmangotea.i_architecture.registry.IAItems;
import com.google.common.base.Supplier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import com.simibubi.create.foundation.data.recipe.CompatMetals;
import com.simibubi.create.foundation.data.recipe.Mods;
import com.simibubi.create.foundation.mixin.accessor.MappedRegistryAccessor;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
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
    /// ////////////////////

    String currentFolder = "";

    Marker enterFolder(String folder) {
        currentFolder = folder;
        return new Marker();
    }

    GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
        return new GeneratedRecipeBuilder(currentFolder, result);
    }

    GeneratedRecipeBuilder create(ResourceLocation result) {
        return new GeneratedRecipeBuilder(currentFolder, result);
    }

    GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike, ? extends ItemLike> result) {
        return create(result::get);
    }

    GeneratedRecipe createSpecial(Function<CraftingBookCategory, Recipe<?>> builder, String recipeType,
                                  String path) {
        ResourceLocation location = IndustrializedArchitecture.asResource(recipeType + "/" + currentFolder + "/" + path);
        return register(consumer -> {
            SpecialRecipeBuilder b = SpecialRecipeBuilder.special(builder);
            b.save(consumer, location.toString());
        });
    }

    GeneratedRecipe blastCrushedMetal(Supplier<? extends ItemLike> result, Supplier<? extends ItemLike> ingredient) {
        return create(result::get).withSuffix("_from_crushed")
                .viaCooking(ingredient)
                .rewardXP(.1f)
                .inBlastFurnace();
    }

    GeneratedRecipe blastModdedCrushedMetal(ItemEntry<? extends Item> ingredient, CompatMetals metal) {
        for (Mods mod : metal.getMods()) {
            String metalName = metal.getName(mod);
            ResourceLocation ingot = mod.ingotOf(metalName);
            String modId = mod.getId();
            create(ingot).withSuffix("_compat_" + modId)
                    .whenModLoaded(modId)
                    .viaCooking(ingredient::get)
                    .rewardXP(.1f)
                    .inBlastFurnace();
        }
        return null;
    }

    GeneratedRecipe recycleGlass(BlockEntry<? extends Block> ingredient) {
        return create(() -> Blocks.GLASS).withSuffix("_from_" + ingredient.getId()
                        .getPath())
                .viaCooking(ingredient::get)
                .forDuration(50)
                .inFurnace();
    }

    GeneratedRecipe recycleGlassPane(BlockEntry<? extends Block> ingredient) {
        return create(() -> Blocks.GLASS_PANE).withSuffix("_from_" + ingredient.getId()
                        .getPath())
                .viaCooking(ingredient::get)
                .forDuration(50)
                .inFurnace();
    }

    GeneratedRecipe metalCompacting(List<ItemProviderEntry<? extends ItemLike, ? extends ItemLike>> variants,
                                    List<Supplier<TagKey<Item>>> ingredients) {
        GeneratedRecipe result = null;
        for (int i = 0; i + 1 < variants.size(); i++) {
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> currentEntry = variants.get(i);
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> nextEntry = variants.get(i + 1);
            Supplier<TagKey<Item>> currentIngredient = ingredients.get(i);
            Supplier<TagKey<Item>> nextIngredient = ingredients.get(i + 1);

            result = create(nextEntry).withSuffix("_from_compacting")
                    .unlockedBy(currentEntry::get)
                    .viaShaped(b -> b.pattern("###")
                            .pattern("###")
                            .pattern("###")
                            .define('#', currentIngredient.get()));

            result = create(currentEntry).returns(9)
                    .withSuffix("_from_decompacting")
                    .unlockedBy(nextEntry::get)
                    .viaShapeless(b -> b.requires(nextIngredient.get()));
        }
        return result;
    }

    GeneratedRecipe conversionCycle(List<ItemProviderEntry<? extends ItemLike, ? extends ItemLike>> cycle) {
        GeneratedRecipe result = null;
        for (int i = 0; i < cycle.size(); i++) {
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> currentEntry = cycle.get(i);
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> nextEntry = cycle.get((i + 1) % cycle.size());
            result = create(nextEntry).withSuffix("_from_conversion")
                    .unlockedBy(currentEntry::get)
                    .viaShapeless(b -> b.requires(currentEntry.get()));
        }
        return result;
    }

    GeneratedRecipe clearData(ItemProviderEntry<? extends ItemLike, ? extends ItemLike> item) {
        return create(item).withSuffix("_clear")
                .unlockedBy(item::get)
                .viaShapeless(b -> b.requires(item.get()));
    }

    class GeneratedRecipeBuilder {

        private String path;
        private String suffix;
        private Supplier<? extends ItemLike> result;
        private ResourceLocation compatDatagenOutput;
        List<ICondition> recipeConditions;

        private Supplier<ItemPredicate> unlockedBy;
        private int amount;

        private GeneratedRecipeBuilder(String path) {
            this.path = path;
            this.recipeConditions = new ArrayList<>();
            this.suffix = "";
            this.amount = 1;
        }

        public GeneratedRecipeBuilder(String path, Supplier<? extends ItemLike> result) {
            this(path);
            this.result = result;
        }

        public GeneratedRecipeBuilder(String path, ResourceLocation result) {
            this(path);
            this.compatDatagenOutput = result;
        }

        GeneratedRecipeBuilder returns(int amount) {
            this.amount = amount;
            return this;
        }

        GeneratedRecipeBuilder unlockedBy(Supplier<? extends ItemLike> item) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(item.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder unlockedByTag(Supplier<TagKey<Item>> tag) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(tag.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder whenModLoaded(String modid) {
            return withCondition(new ModLoadedCondition(modid));
        }

        GeneratedRecipeBuilder whenModMissing(String modid) {
            return withCondition(new NotCondition(new ModLoadedCondition(modid)));
        }

        GeneratedRecipeBuilder withCondition(ICondition condition) {
            recipeConditions.add(condition);
            return this;
        }

        GeneratedRecipeBuilder withSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        // FIXME 5.1 refactor - recipe categories as markers instead of sections?
        GeneratedRecipe viaShaped(UnaryOperator<ShapedRecipeBuilder> builder) {
            return register(consumer -> {
                ShapedRecipeBuilder b =
                        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaShapeless(UnaryOperator<ShapelessRecipeBuilder> builder) {
            return register(recipeOutput -> {
                ShapelessRecipeBuilder b =
                        builder.apply(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));

                RecipeOutput conditionalOutput = recipeOutput.withConditions(recipeConditions.toArray(new ICondition[0]));

                b.save(recipeOutput, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaNetheriteSmithing(Supplier<? extends Item> base, Supplier<Ingredient> upgradeMaterial) {
            return register(consumer -> {
                SmithingTransformRecipeBuilder b =
                        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(base.get()), upgradeMaterial.get(), RecipeCategory.COMBAT, result.get()
                                        .asItem());
                b.unlocks("has_item", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(base.get())
                        .build()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        private ResourceLocation createSimpleLocation(String recipeType) {
            return IndustrializedArchitecture.asResource(recipeType + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation createLocation(String recipeType) {
            return IndustrializedArchitecture.asResource(recipeType + "/" + path + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation getRegistryName() {
            return compatDatagenOutput == null ? RegisteredObjectsHelper.getKeyOrThrow(result.get()
                    .asItem()) : compatDatagenOutput;
        }

        GeneratedCookingRecipeBuilder viaCooking(Supplier<? extends ItemLike> item) {
            return unlockedBy(item).viaCookingIngredient(() -> Ingredient.of(item.get()));
        }

        GeneratedCookingRecipeBuilder viaCookingTag(Supplier<TagKey<Item>> tag) {
            return unlockedByTag(tag).viaCookingIngredient(() -> Ingredient.of(tag.get()));
        }

        GeneratedCookingRecipeBuilder viaCookingIngredient(Supplier<Ingredient> ingredient) {
            return new GeneratedCookingRecipeBuilder(ingredient);
        }

        class GeneratedCookingRecipeBuilder {

            private Supplier<Ingredient> ingredient;
            private float exp;
            private int cookingTime;

            GeneratedCookingRecipeBuilder(Supplier<Ingredient> ingredient) {
                this.ingredient = ingredient;
                cookingTime = 200;
                exp = 0;
            }

            GeneratedCookingRecipeBuilder forDuration(int duration) {
                cookingTime = duration;
                return this;
            }

            GeneratedCookingRecipeBuilder rewardXP(float xp) {
                exp = xp;
                return this;
            }

            GeneratedRecipe inFurnace() {
                return inFurnace(b -> b);
            }

            GeneratedRecipe inFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                return create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
            }

            GeneratedRecipe inSmoker() {
                return inSmoker(b -> b);
            }

            GeneratedRecipe inSmoker(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
                create(RecipeSerializer.CAMPFIRE_COOKING_RECIPE, builder, CampfireCookingRecipe::new, 3);
                return create(RecipeSerializer.SMOKING_RECIPE, builder, SmokingRecipe::new, .5f);
            }

            GeneratedRecipe inBlastFurnace() {
                return inBlastFurnace(b -> b);
            }

            GeneratedRecipe inBlastFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
                return create(RecipeSerializer.BLASTING_RECIPE, builder, BlastingRecipe::new, .5f);
            }

            private <T extends AbstractCookingRecipe> GeneratedRecipe create(RecipeSerializer<T> serializer,
                                                                             UnaryOperator<SimpleCookingRecipeBuilder> builder, AbstractCookingRecipe.Factory<T> factory, float cookingTimeModifier) {
                return register(recipeOutput -> {
                    boolean isOtherMod = compatDatagenOutput != null;

                    SimpleCookingRecipeBuilder b = builder.apply(SimpleCookingRecipeBuilder.generic(ingredient.get(),
                            RecipeCategory.MISC, isOtherMod ? Items.DIRT : result.get(), exp,
                            (int) (cookingTime * cookingTimeModifier), serializer, factory));
                    if (unlockedBy != null)
                        b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));

                    RecipeOutput conditionalOutput = recipeOutput.withConditions(recipeConditions.toArray(new ICondition[0]));

                    b.save(
                            isOtherMod ? new ModdedCookingRecipeOutput(conditionalOutput, compatDatagenOutput) : conditionalOutput,
                            createSimpleLocation(RegisteredObjectsHelper.getKeyOrThrow(serializer).getPath())
                    );
                });
            }
        }
    }


    public IAStandardRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    private static class ModdedCookingRecipeOutputShim implements Recipe<RecipeInput> {

        private static final Map<RecipeType<?>, Serializer> serializers = new ConcurrentHashMap<>();

        private final Recipe<?> wrapped;
        private final ResourceLocation overrideID;

        private ModdedCookingRecipeOutputShim(Recipe<?> wrapped, ResourceLocation overrideID) {
            this.wrapped = wrapped;
            this.overrideID = overrideID;
        }

        @Override
        public boolean matches(RecipeInput recipeInput, Level level) {
            throw new AssertionError("Only for datagen output");
        }

        @Override
        public ItemStack assemble(RecipeInput input, HolderLookup.Provider registries) {
            throw new AssertionError("Only for datagen output");
        }

        @Override
        public boolean canCraftInDimensions(int pWidth, int pHeight) {
            throw new AssertionError("Only for datagen output");
        }

        @Override
        public ItemStack getResultItem(HolderLookup.Provider registries) {
            throw new AssertionError("Only for datagen output");
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return serializers.computeIfAbsent(
                    getType(),
                    t -> Serializer.create(wrapped)
            );
        }

        @Override
        public RecipeType<?> getType() {
            return wrapped.getType();
        }

        private record Serializer(
                MapCodec<Recipe<?>> wrappedCodec) implements RecipeSerializer<ModdedCookingRecipeOutputShim> {
            private static Serializer create(Recipe<?> wrapped) {
                RecipeSerializer<?> wrappedSerializer = wrapped.getSerializer();
                @SuppressWarnings("unchecked")
                Serializer serializer = new Serializer((MapCodec<Recipe<?>>) wrappedSerializer.codec());

                // Need to do some registry injection to get the Recipe/Registry#byNameCodec to encode the right type for this
                // getResourceKey and getId
                // byValue and toId
                // Holder.Reference: key
                if (BuiltInRegistries.RECIPE_SERIALIZER instanceof MappedRegistryAccessor<?> mra) {
                    @SuppressWarnings("unchecked")
                    MappedRegistryAccessor<RecipeSerializer<?>> mra$ = (MappedRegistryAccessor<RecipeSerializer<?>>) mra;

                    int wrappedId = mra$.getToId().getOrDefault(wrappedSerializer, -1);
                    ResourceKey<RecipeSerializer<?>> wrappedKey = mra$.getByValue().get(wrappedSerializer).key();

                    mra$.getToId().put(serializer, wrappedId);
                    //noinspection DataFlowIssue - it is ok to pass null as the owner, because this is only being used for serialization
                    mra$.getByValue().put(serializer, Holder.Reference.createStandAlone(null, wrappedKey));
                } else {
                    throw new AssertionError("ModdedCookingRecipeOutputShim will not be able to" +
                            " serialize without injecting into a registry. Expected" +
                            " BuiltInRegistries.RECIPE_SERIALIZER to be of class MappedRegistry, is of class " +
                            BuiltInRegistries.RECIPE_SERIALIZER.getClass()
                    );
                }
                return serializer;
            }

            @Override
            public MapCodec<ModdedCookingRecipeOutputShim> codec() {
                return RecordCodecBuilder.mapCodec(instance -> instance.group(
                        wrappedCodec.forGetter(i -> i.wrapped),
                        FakeItemStack.CODEC.fieldOf("result").forGetter(i -> new FakeItemStack(i.overrideID))
                ).apply(instance, (wrappedRecipe, fakeItemStack) -> {
                    throw new AssertionError("Only for datagen output");
                }));
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, ModdedCookingRecipeOutputShim> streamCodec() {
                throw new AssertionError("Only for datagen output");
            }
        }

        private record FakeItemStack(ResourceLocation id) {
            public static Codec<FakeItemStack> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("id").forGetter(FakeItemStack::id)
            ).apply(instance, FakeItemStack::new));
        }
    }

    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    private record ModdedCookingRecipeOutput(RecipeOutput wrapped,
                                             ResourceLocation outputOverride) implements RecipeOutput {

        @Override
        public Advancement.Builder advancement() {
            return wrapped.advancement();
        }

        @Override
        public void accept(ResourceLocation id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition... conditions) {
            wrapped.accept(id, new ModdedCookingRecipeOutputShim(recipe, outputOverride), advancement, conditions);
        }
    }
}
