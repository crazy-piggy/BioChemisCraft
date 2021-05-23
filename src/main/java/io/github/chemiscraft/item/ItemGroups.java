package io.github.chemiscraft.item;

import io.github.chemiscraft.Main;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup ELEMENT = FabricItemGroupBuilder.build(new Identifier(Main.MODID, "element_group"),
                                                                         () -> new ItemStack(Items.HYDROGEN_1));
    public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(new Identifier(Main.MODID, "equipment_group"),
                                                                           () -> new ItemStack(Items.HELIUM_3));
}
