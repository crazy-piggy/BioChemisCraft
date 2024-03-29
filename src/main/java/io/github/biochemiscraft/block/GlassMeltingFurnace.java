package io.github.biochemiscraft.block;

import io.github.biochemiscraft.block.entity.GlassMeltingFurnaceEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static io.github.biochemiscraft.block.entity.BlockEntities.GLASS_MELTING_FURNACE_ENTITY;
import static net.minecraft.block.HorizontalFacingBlock.FACING;

public class GlassMeltingFurnace extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty LIT = Properties.LIT;

    protected GlassMeltingFurnace(Settings settings) {
        super(settings.nonOpaque().mapColor(MapColor.IRON_GRAY).noCollision());
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, LIT);
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

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GlassMeltingFurnaceEntity(pos, state);
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory) GLASS_MELTING_FURNACE_ENTITY;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, GLASS_MELTING_FURNACE_ENTITY, GlassMeltingFurnaceEntity::tick);
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GlassMeltingFurnaceEntity entity) {
                player.openHandledScreen(entity);
            }
        }
        return ActionResult.SUCCESS;
    }

    /*
     *100   @Override
     *101   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
     *102       if (!world.isClient) {
     *103           BlockEntity blockEntity = world.getBlockEntity(pos);
     *104           if (blockEntity instanceof GlassMeltingFurnaceEntity) {
     *105               player.openHandledScreen((ExtendedScreenHandlerFactory) blockEntity);
     *106           }
     *107       }
     *108       return ActionResult.SUCCESS;
     *109   }
     *      //  When player tries to use this block, player can use the block, but the game can't open the screen and throw
     *      //  an exception:
     *      //  [Server thread/ERROR] (Minecraft) Failed to handle packet net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket@79bd9201, suppressing error
     *      //  java.lang.ClassCastException: class io.github.biochemiscraft.block.entity.GlassMeltingFurnaceEntity cannot be cast to class net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory (io.github.biochemiscraft.block.entity.GlassMeltingFurnaceEntity and net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory are in unnamed module of loader net.fabricmc.loader.impl.launch.knot.KnotClassLoader @4667ae56)
	 *      //  at io.github.biochemiscraft.block.GlassMeltingFurnace.onUse(GlassMeltingFurnace.java:105) ~[main/:?]
     */
}
