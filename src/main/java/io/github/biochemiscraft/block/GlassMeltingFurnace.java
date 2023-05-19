package io.github.biochemiscraft.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GlassMeltingFurnace extends AbstractFurnaceBlock {
    public static final BooleanProperty LIT = Properties.LIT;

    public GlassMeltingFurnace(AbstractBlock.Settings settings) {
        super(settings.nonOpaque().mapColor(MapColor.IRON_GRAY).noCollision());
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(LIT, false));
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FurnaceBlockEntity(pos, state);
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
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }


    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof FurnaceBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            player.incrementStat(Stats.INTERACT_WITH_STONECUTTER);
        }
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            double d = (double)pos.getX() + 0.5;
            double e = pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                world.playSound(d, e, f, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
            double j = random.nextDouble() * 6.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
            world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
            world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }
    }
}
