package com.drmangotea.i_architecture.content.blocks.railings;

import com.drmangotea.i_architecture.IndustrializedArchitecture;
import com.drmangotea.i_architecture.registry.IAShapes;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ModelFile;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static com.drmangotea.i_architecture.base.RustedBlockVariants.RustedVariants.NORMAL;

public class RailingBlock extends Block {


    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 2, 16, 16);
    public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 2);
    public static final VoxelShape SHAPE_EAST = Block.box(14, 0, 0, 16, 16, 16);
    public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 14, 16, 16, 16);

    public RailingBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(WATERLOGGED, false)
                        .setValue(NORTH, false)
                        .setValue(SOUTH, false)
                        .setValue(WEST, false)
                        .setValue(EAST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(NORTH, SOUTH, WEST, EAST, WATERLOGGED);
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {

        Direction facing = context.getNearestLookingDirection();


        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;


        BlockState state = this.defaultBlockState();

        state = state.setValue(WATERLOGGED, flag);

        Direction direction = context.getHorizontalDirection();

        BooleanProperty property = getPropertyFromFacing(facing);

        if (property == null)
            property = getPropertyFromFacing(context.getHorizontalDirection());

        return super.getStateForPlacement(context).setValue(property, true);
    }

    public BooleanProperty getPropertyFromFacing(Direction facing) {
        return switch (facing) {
            case DOWN -> null;
            case UP -> null;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
            case EAST -> EAST;
        };
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_54562_, BlockPos p_54563_, CollisionContext p_54564_) {

        VoxelShape shape = IAShapes.EMPTY;

        if (state.getValue(NORTH))
            shape = Shapes.or(shape, SHAPE_NORTH);

        if (state.getValue(SOUTH))
            shape = Shapes.or(shape, SHAPE_SOUTH);

        if (state.getValue(WEST))
            shape = Shapes.or(shape, SHAPE_WEST);

        if (state.getValue(EAST))
            shape = Shapes.or(shape, SHAPE_EAST);


        return shape;
    }

    @Override
    public FluidState getFluidState(BlockState p_51475_) {
        return p_51475_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51475_);
    }

    @Override
    public BlockState updateShape(BlockState p_54440_, Direction p_54441_, BlockState p_54442_, LevelAccessor p_54443_, BlockPos p_54444_, BlockPos p_54445_) {
        if (p_54440_.getValue(WATERLOGGED)) {
            p_54443_.scheduleTick(p_54444_, Fluids.WATER, Fluids.WATER.getTickDelay(p_54443_));
        }
        return p_54440_;
    }


    public static NonNullBiConsumer<DataGenContext<Block, RailingBlock>, RegistrateBlockstateProvider> railing(
            String name) {
        return (c, p) -> {


                ResourceLocation texture = IndustrializedArchitecture.asResource("block/metal/"+name+"_railing");

                p.models().withExistingParent("block/" + c.getName() + "/block_railing", IndustrializedArchitecture.asResource("block/metal_railing/block_railing"))
                        .texture("0", texture)
                        .texture("particle", texture);
                p.models().withExistingParent("block/" + c.getName() + "/block_railing_higher", IndustrializedArchitecture.asResource("block/metal_railing/block_railing_higher"))
                        .texture("0", texture)
                        .texture("particle", texture);
                p.models().withExistingParent("block/" + c.getName() + "/item", IndustrializedArchitecture.asResource("block/metal_railing/item"))
                        .texture("0", texture)
                        .texture("particle", texture);




            ModelFile side = AssetLookup.partialBaseModel(c, p, "railing");
            ModelFile side_higher = AssetLookup.partialBaseModel(c, p, "railing_higher");

            p.getMultipartBuilder(c.get())
                    .part()
                    .modelFile(side_higher)
                    .addModel()
                    .condition(RailingBlock.NORTH, true)
                    .end()
                    .part()
                    .modelFile(side)
                    .rotationY(90)
                    .addModel()
                    .condition(RailingBlock.EAST, true)
                    .end()
                    .part()
                    .modelFile(side_higher)
                    .rotationY(180)
                    .addModel()
                    .condition(RailingBlock.SOUTH, true)
                    .end()
                    .part()
                    .modelFile(side)
                    .rotationY(270)
                    .addModel()
                    .condition(RailingBlock.WEST, true)
                    .end()


            ;
        };
    }




    public static NonNullBiConsumer<DataGenContext<Block, RailingBlock>, RegistrateBlockstateProvider> metalRailing(
            String variant) {
        return (c, p) -> {

            if (!Objects.equals(variant, NORMAL.getName())) {

                String variantWithoutUnderscore = variant.isEmpty() ? variant : variant.substring(0, variant.length() - 1);

                ResourceLocation texture = IndustrializedArchitecture.asResource("block/metal/"+variantWithoutUnderscore+"/"+variant+"metal_railing");

                p.models().withExistingParent("block/" + c.getName() + "/block_railing", IndustrializedArchitecture.asResource("block/metal_railing/block_railing"))
                        .texture("0", texture)
                        .texture("particle", texture);
                p.models().withExistingParent("block/" + c.getName() + "/block_railing_higher", IndustrializedArchitecture.asResource("block/metal_railing/block_railing_higher"))
                        .texture("0", texture)
                        .texture("particle", texture);
                p.models().withExistingParent("block/" + c.getName() + "/item", IndustrializedArchitecture.asResource("block/metal_railing/item"))
                        .texture("0", texture)
                        .texture("particle", texture);

            }


            ModelFile side = AssetLookup.partialBaseModel(c, p, "railing");
            ModelFile side_higher = AssetLookup.partialBaseModel(c, p, "railing_higher");

            p.getMultipartBuilder(c.get())
                    .part()
                    .modelFile(side_higher)
                    .addModel()
                    .condition(RailingBlock.NORTH, true)
                    .end()
                    .part()
                    .modelFile(side)
                    .rotationY(90)
                    .addModel()
                    .condition(RailingBlock.EAST, true)
                    .end()
                    .part()
                    .modelFile(side_higher)
                    .rotationY(180)
                    .addModel()
                    .condition(RailingBlock.SOUTH, true)
                    .end()
                    .part()
                    .modelFile(side)
                    .rotationY(270)
                    .addModel()
                    .condition(RailingBlock.WEST, true)
                    .end()


            ;
        };
    }

}
