package io.github.chemiscraft.__Blocks__;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import static net.minecraft.block.FacingBlock.FACING;

public class __Block__ {
    public static class IronStand extends net.minecraft.block.Block {
        public IronStand(Settings settings){
            super(settings.nonOpaque());
        }

        @Override
        protected void appendProperties(StateManager.Builder<net.minecraft.block.Block, BlockState> stateManager) {
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

    public static class IronTrivet extends net.minecraft.block.Block {
        public IronTrivet(Settings settings){
            super(settings.nonOpaque());
        }

        @Override
        protected void appendProperties(StateManager.Builder<net.minecraft.block.Block, BlockState> stateManager) {
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

    public static class PhosphorusBlock extends net.minecraft.block.Block {
        public PhosphorusBlock(Settings settings){
            super(settings);
        }
    }
}
