package io.github.biochemiscraft.block.entity;

import io.github.biochemiscraft.recipe.GlassMelting;
import io.github.biochemiscraft.recipe.Recipes;
import io.github.biochemiscraft.screen.GlassMeltingFurnaceScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class GlassMeltingFurnaceEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public GlassMeltingFurnaceEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.GLASS_MELTING_FURNACE_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> GlassMeltingFurnaceEntity.this.progress;
                    case 1 -> GlassMeltingFurnaceEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GlassMeltingFurnaceEntity.this.progress = value;
                    case 1 -> GlassMeltingFurnaceEntity.this.maxProgress = value;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return ImplementedInventory.super.getAvailableSlots(side);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("display.screen.biochemiscraft.glass_melting_furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GlassMeltingFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("glass_melting_furnace.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("glass_melting_furnace.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, GlassMeltingFurnaceEntity entity) {
        if (world.isClient()) {
            return;
        }

        if (hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
            else {
                entity.resetProgress();
                markDirty(world, blockPos, state);
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(GlassMeltingFurnaceEntity entity) {
        SimpleInventory simpleInventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size();i++ ) {
            simpleInventory.setStack(i, entity.getStack(i));
        }
        Optional<GlassMelting> recipe = Objects.requireNonNull(entity.getWorld()).getRecipeManager().getFirstMatch(Recipes.GLASS_MELTING_TYPE, simpleInventory, entity.getWorld());

        if (hasRecipe(entity)) {
            entity.removeStack(1, 1);
            entity.setStack(2, new ItemStack(recipe.get().getOutput(null).getItem(), recipe.get().getOutput(null).getCount() + 1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(GlassMeltingFurnaceEntity entity) {
        SimpleInventory simpleInventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size();i++ ) {
            simpleInventory.setStack(i, entity.getStack(i));
        }
        Optional<GlassMelting> match = Objects.requireNonNull(entity.getWorld()).getRecipeManager().getFirstMatch(Recipes.GLASS_MELTING_TYPE, simpleInventory, entity.getWorld());
        return match.isPresent() && canInsertAmountIntoOutputSlot(simpleInventory) && canInsertItemIntoOutputSlot(simpleInventory, match.get().getOutput(null).getItem());
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory simpleInventory) {
        return simpleInventory.getStack(2).getMaxCount() > simpleInventory.getStack(2).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory simpleInventory, Item output) {
        return simpleInventory.getStack(2).getItem() == output || simpleInventory.getStack(2).isEmpty();
    }
}
