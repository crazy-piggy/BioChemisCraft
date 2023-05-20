package io.github.biochemiscraft.block.entity;

import io.github.biochemiscraft.screen.GlassMeltingFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GlassMeltingFurnaceEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public GlassMeltingFurnaceEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.GLASS_MELTING_FURNACE_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return GlassMeltingFurnaceEntity.this.progress;
                    case 1: return GlassMeltingFurnaceEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:  GlassMeltingFurnaceEntity.this.progress = value; break;
                    case 1:  GlassMeltingFurnaceEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
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

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof GlassMeltingFurnaceEntity) {
            player.openHandledScreen((GlassMeltingFurnaceEntity) blockEntity);
        }
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
        if (hasRecipe(entity)) {
            entity.removeStack(1, 1);
            entity.setStack(2, new ItemStack(Items.GLASS, entity.getStack(2).getCount() + 1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(GlassMeltingFurnaceEntity entity) {
        SimpleInventory simpleInventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size();i++ ) {
            simpleInventory.setStack(i, entity.getStack(i));
        }
        boolean hasFuelInFirstSlot = entity.getStack(1).getItem() == Items.SAND;
        return hasFuelInFirstSlot && canInsertAmountIntoOutputSlot(simpleInventory) && canInsertItemIntoOutputSlot(simpleInventory, Items.GLASS);
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory simpleInventory) {
        return simpleInventory.getStack(2).getMaxCount() > simpleInventory.getStack(2).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory simpleInventory, Item output) {
        return simpleInventory.getStack(2).getItem() == output || simpleInventory.getStack(2).isEmpty();
    }
}
