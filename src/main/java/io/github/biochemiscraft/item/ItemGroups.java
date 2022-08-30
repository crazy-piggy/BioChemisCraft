package io.github.biochemiscraft.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;
import static io.github.biochemiscraft.block.Blocks.IRON_STAND;
import static io.github.biochemiscraft.item.Items.HYDROGEN_1;

public class ItemGroups {
    public static final ItemGroup ELEMENT = FabricItemGroupBuilder.build(new Identifier(MODID, "element_group"), () -> new ItemStack(HYDROGEN_1));
    public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(new Identifier(MODID, "equipment_group"), () -> new ItemStack(IRON_STAND));
}
