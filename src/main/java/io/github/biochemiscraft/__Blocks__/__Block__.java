package io.github.biochemiscraft.__Blocks__;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
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

import static io.github.biochemiscraft.__Blocks__.VerticalSlabBlock.WATERLOGGED;
import static net.minecraft.block.FacingBlock.FACING;

public class __Block__ {
    public static class IronStand extends Block {
        public IronStand(Settings settings){
            super(settings.nonOpaque().mapColor(MapColor.IRON_GRAY).noCollision());
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
            stateManager.add(Properties.FACING);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            Direction dir = state.get(FACING);
            return switch (dir) {
                case NORTH, SOUTH, EAST, WEST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                default -> VoxelShapes.fullCube();
            };
        }

        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState()
                    .with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite())
                    .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
        }

        @Override
        public FluidState getFluidState(BlockState state) {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
        }

        @Override
        public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
            if (state.get(WATERLOGGED)) world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    public static class IronTrivet extends Block {
        public IronTrivet(Settings settings){
            super(settings.nonOpaque().mapColor(MapColor.IRON_GRAY).noCollision());
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
            stateManager.add(Properties.FACING);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            Direction dir = state.get(FACING);
            return switch (dir) {
                case NORTH, SOUTH, EAST, WEST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                default -> VoxelShapes.fullCube();
            };
        }

        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
        }
    }

    public static class PhosphorusBlock extends Block {
        public PhosphorusBlock(Settings settings){
            super(settings.nonOpaque());
        }
    }

    public static class SJOL extends Block {
        public SJOL(Settings settings){
            super(settings.luminance((state) -> 11).nonOpaque().mapColor(MapColor.ORANGE));
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
            stateManager.add(Properties.FACING);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
            Direction dir = state.get(FACING);
            return switch (dir) {
                case NORTH, SOUTH, EAST, WEST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                default -> VoxelShapes.fullCube();
            };
        }

        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
        }
    }
}
