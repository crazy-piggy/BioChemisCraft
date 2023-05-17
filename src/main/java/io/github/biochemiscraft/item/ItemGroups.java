package io.github.biochemiscraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;
import static io.github.biochemiscraft.block.Blocks.*;
import static io.github.biochemiscraft.item.Items.*;

public class ItemGroups {
    public static final ItemGroup ELEMENTAL = FabricItemGroup.builder(new Identifier(MODID, "elemental_group")).icon(() ->new ItemStack(WHITE_PHOSPHORUS)).build();
    public static final ItemGroup ELEMENTAL_BLOCK = FabricItemGroup.builder(new Identifier(MODID, "elemental_block_group")).icon(() ->new ItemStack(WHITE_PHOSPHORUS_BLOCK)).build();
    public static final ItemGroup EQUIPMENT = FabricItemGroup.builder(new Identifier(MODID, "equipment_group")).icon(() -> new ItemStack(IRON_STAND)).build();
    public static final ItemGroup NUCLIDE = FabricItemGroup.builder(new Identifier(MODID, "nuclide_group")).icon(() -> new ItemStack(HYDROGEN_1)).build();

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ELEMENTAL).register(content -> {
            content.add(WHITE_PHOSPHORUS);
            content.add(RED_PHOSPHORUS);
            content.add(ORTHORHOMBIC_SULPHUR);
            content.add(MONOCLINIC_SULPHUR);
            content.add(AMORPHOUS_SULPHUR);
            content.add(SULPHUR_POWDER);
        });
        ItemGroupEvents.modifyEntriesEvent(ELEMENTAL_BLOCK).register(content -> {
            content.add(WHITE_PHOSPHORUS_BLOCK);
            content.add(RED_PHOSPHORUS_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(EQUIPMENT).register(content -> {
            content.add(IRON_STAND);
            content.add(IRON_TRIVET);
            content.add(IRON_RING);
            content.add(IRON_STAND_BASE);
            content.add(IRON_STAND_CLIP);
            content.add(IRON_STAND_RING);
            content.add(IRON_STAND_ROD);
        });
        ItemGroupEvents.modifyEntriesEvent(NUCLIDE).register(content -> {
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
    }
}
