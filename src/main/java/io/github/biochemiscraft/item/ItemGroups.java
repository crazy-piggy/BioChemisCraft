package io.github.biochemiscraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;
import static io.github.biochemiscraft.block.Blocks.IRON_STAND;
import static io.github.biochemiscraft.item.Items.*;

public class ItemGroups {
    public static final ItemGroup ELEMENT = FabricItemGroup.builder(new Identifier(MODID, "element_group")).icon(() ->new ItemStack(HYDROGEN_1)).build();
    public static final ItemGroup EQUIPMENT = FabricItemGroup.builder(new Identifier(MODID, "equipment_group")).icon(() -> new ItemStack(IRON_STAND)).build();

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ELEMENT).register(content -> {
            content.add(HYDROGEN_1);
            content.add(HYDROGEN_2);
            content.add(HYDROGEN_3);
            content.add(HYDROGEN_4);
            content.add(HYDROGEN_5);
            content.add(HYDROGEN_6);
            content.add(HYDROGEN_7);
            content.add(HELIUM_3);
            content.add(HELIUM_4);
            content.add(HELIUM_5);
            content.add(HELIUM_6);
            content.add(HELIUM_7);
            content.add(HELIUM_8);
            content.add(HELIUM_9);
            content.add(HELIUM_10);
        });
        ItemGroupEvents.modifyEntriesEvent(EQUIPMENT).register(content -> {
            content.add(IRON_STAND);
        });
    }
}
