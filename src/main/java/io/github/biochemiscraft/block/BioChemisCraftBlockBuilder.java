package io.github.biochemiscraft.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;
import static net.minecraft.state.property.Properties.WATERLOGGED;

public class BioChemisCraftBlockBuilder {
    private double minX = 0.0;
    private double minY = 0.0;
    private double minZ = 0.0;
    private double maxX = 1.0;
    private double maxY = 1.0;
    private double maxZ = 1.0;

    public BioChemisCraftBlockBuilder minX(double minX) {
        this.minX = minX;
        return this;
    }

    public BioChemisCraftBlockBuilder minY(double minY) {
        this.minY = minY;
        return this;
    }

    public BioChemisCraftBlockBuilder minZ(double minZ) {
        this.minZ = minZ;
        return this;
    }

    public BioChemisCraftBlockBuilder maxX(double maxX) {
        this.maxX = maxX;
        return this;
    }

    public BioChemisCraftBlockBuilder maxY(double maxY) {
        this.maxY = maxY;
        return this;
    }

    public BioChemisCraftBlockBuilder maxZ(double maxZ) {
        this.maxZ = maxZ;
        return this;
    }

    public Builder build(Builder.Settings settings) {
        return new Builder(settings, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static class Builder extends HorizontalFacingBlock implements Waterloggable {
        private final double minX, minY, minZ;
        private final double maxX, maxY, maxZ;

        private Builder(Settings settings,
                        double minX, double minY, double minZ,
                        double maxX, double maxY, double maxZ) {
            super(settings.nonOpaque().noCollision());
            this.minX = minX;
            this.minY = minY;
            this.minZ = minZ;
            this.maxX = maxX;
            this.maxY = maxY;
            this.maxZ = maxZ;
            setDefaultState(stateManager.getDefaultState()
                    .with(HORIZONTAL_FACING, Direction.NORTH)
                    .with(WATERLOGGED, false));
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
            stateManager.add(HORIZONTAL_FACING, WATERLOGGED);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            Direction dir = state.get(FACING);
            return switch (dir) {
                case NORTH, SOUTH, EAST, WEST -> VoxelShapes.cuboid(minX, minY, minZ, maxX, maxY, maxZ);
                default -> VoxelShapes.fullCube();
            };
        }

        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState()
                    .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                    .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        }

        @Override
        public FluidState getFluidState(BlockState state) {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
        }

        @Override
        public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
            if (state.get(WATERLOGGED))
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }
}
