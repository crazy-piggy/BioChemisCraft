//todo: update package name to "io.github.crazypiggy.chemiscraft.item"
package io.github.chemiscraft.item;

import io.github.chemiscraft.Main;
import io.github.chemiscraft.block.Blocks;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
    /** Equipment */
    public static final BlockItem IRON_STAND = of("iron_stand", new BlockItem(Blocks.IRON_STAND, settingsEq()));
    public static final Item IRON_STAND_RING = of("iron_stand_ring", new Item(settingsEq()));
    public static final Item IRON_STAND_BASE = of("iron_stand_base", new Item(settingsEq()));
    public static final Item IRON_STAND_CLIP = of("iron_stand_clip", new Item(settingsEq()));
    public static final Item IRON_STAND_ROD = of("iron_stand_rod", new Item(settingsEq()));
    public static final Item IRON_RING = of("iron_ring", new Item(settingsEq()));
    /** Hydrogen */
    public static final Item HYDROGEN_1 = of("hydrogen_1", new Item(settings()));
    public static final Item HYDROGEN_2 = of("hydrogen_2", new Item(settings()));
    public static final Item HYDROGEN_3 = of("hydrogen_3", new Item(settings()));
    public static final Item HYDROGEN_4 = of("hydrogen_4", new Item(settings()));
    public static final Item HYDROGEN_5 = of("hydrogen_5", new Item(settings()));
    public static final Item HYDROGEN_6 = of("hydrogen_6", new Item(settings()));
    public static final Item HYDROGEN_7 = of("hydrogen_7", new Item(settings()));
    /** Helium */
    public static final Item HELIUM_3 = of("helium_3", new Item(settings()));
    public static final Item HELIUM_4 = of("helium_4", new Item(settings()));
    public static final Item HELIUM_5 = of("helium_5", new Item(settings()));
    public static final Item HELIUM_6 = of("helium_6", new Item(settings()));
    public static final Item HELIUM_7 = of("helium_7", new Item(settings()));
    public static final Item HELIUM_8 = of("helium_8", new Item(settings()));
    public static final Item HELIUM_9 = of("helium_9", new Item(settings()));
    public static final Item HELIUM_10 = of("helium_10", new Item(settings()));

    /**
     * Load this class
     */
    public static void register() { }

    private static Item.Settings settings() {
        return new Item.Settings().group(ItemGroups.ELEMENT);
    }

    private static Item.Settings settingsEq() {
        return new Item.Settings().group(ItemGroups.EQUIPMENT);
    }

    private static <T extends Item> T of(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(Main.MODID, name), item);
    }
}
