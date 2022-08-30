package io.github.biochemiscraft.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static io.github.biochemiscraft.fluid.Fluids.*;
import static io.github.biochemiscraft.block.Blocks.*;

public abstract class PhosphoricAcid extends FlowableFluid {
    @Override
    public boolean matchesType(Fluid fluid)
    {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected boolean isInfinite()
    {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        Block.dropStacks(state, world, pos, state.getBlock().canMobSpawnInside() ? world.getBlockEntity(pos) : null);
    }


    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction)
    {
        return false;
    }

    @Override
    protected int getFlowSpeed(WorldView worldView)
    {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView)
    {
        return 1;
    }

    @Override
    public int getTickRate(WorldView worldView)
    {
        return 5;
    }

    @Override
    protected float getBlastResistance()
    {
        return 100.0F;
    }

    @Override
    public Fluid getStill()
    {
        return PHOSPHORICACID_STILL;
    }

    @Override
    public Fluid getFlowing()
    {
        return PHOSPHORICACID_FLOWING;
    }

    @Override
    public Item getBucketItem()
    {
        return PHOSPHORICACID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState)
    {
        return PHOSPHORICACID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends PhosphoricAcid
    {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends PhosphoricAcid
    {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
