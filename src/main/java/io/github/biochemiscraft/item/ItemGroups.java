package io.github.biochemiscraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;
import static io.github.biochemiscraft.block.Blocks.IRON_STAND;
import static io.github.biochemiscraft.item.Items.HYDROGEN_1;

public class ItemGroups {
    public static final ItemGroup ELEMENT = FabricItemGroup.builder(new Identifier(MODID, "element_group")).icon(() ->new ItemStack(HYDROGEN_1)).build();
    public static final ItemGroup EQUIPMENT = FabricItemGroup.builder(new Identifier(MODID, "equipment_group")).icon(() -> new ItemStack(IRON_STAND)).build();
}
