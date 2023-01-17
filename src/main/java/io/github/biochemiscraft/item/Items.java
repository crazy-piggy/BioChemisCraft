package io.github.biochemiscraft.item;

import io.github.biochemiscraft.material.RodSword;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

import static io.github.biochemiscraft.Main.ofModIdentifier;
import static io.github.biochemiscraft.block.Blocks.*;
import static io.github.biochemiscraft.effect.Effects.ACUTE_PHOSPHORUS_POISONING;
import static io.github.biochemiscraft.fluid.Fluids.PHOSPHORICACID_STILL;
import static io.github.biochemiscraft.item.ItemGroups.ELEMENT;
import static io.github.biochemiscraft.item.ItemGroups.EQUIPMENT;
import static net.minecraft.item.Items.BUCKET;

public class Items {
    public static final Item RED_PHOSPHORUS = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item PHOSPHORICACID_BUCKET = new BucketItem(PHOSPHORICACID_STILL, new Item.Settings().recipeRemainder(BUCKET).maxCount(1));

    ///////////////////////////////////////////////////////////////////////////
    // Equipment
    ///////////////////////////////////////////////////////////////////////////

    public static final Item IRON_STAND_RING = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_BASE = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_CLIP = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_ROD = new SwordItem(RodSword.INSTANCE, 5, 1, new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_RING = new Item(new Item.Settings().group(EQUIPMENT));

    ///////////////////////////////////////////////////////////////////////////
    // "Food"
    ///////////////////////////////////////////////////////////////////////////

    public static final Phosphorus WHITE_PHOSPHORUS = new Phosphorus(new Item
            .Settings()
            .group(ItemGroup.MISC)
            .food(new FoodComponent.Builder()
                    .hunger(1)
                    .saturationModifier(1)
                    .alwaysEdible()
                    .snack()
                    .statusEffect(new StatusEffectInstance(ACUTE_PHOSPHORUS_POISONING, 50, 1), 100.0f)
                    .build()));

    ///////////////////////////////////////////////////////////////////////////
    // Hydrogen
    ///////////////////////////////////////////////////////////////////////////

    public static final Item HYDROGEN_1 = new Item(elementSettings());
    public static final Item HYDROGEN_2 = new Item(elementSettings());
    public static final Item HYDROGEN_3 = new Item(elementSettings());
    public static final Item HYDROGEN_4 = new Item(elementSettings());
    public static final Item HYDROGEN_5 = new Item(elementSettings());
    public static final Item HYDROGEN_6 = new Item(elementSettings());
    public static final Item HYDROGEN_7 = new Item(elementSettings());

    ///////////////////////////////////////////////////////////////////////////
    // Helium
    ///////////////////////////////////////////////////////////////////////////

    public static final Item HELIUM_3 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_4 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_5 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_6 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_7 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_8 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_9 = new Item(elementSettings().fireproof());
    public static final Item HELIUM_10 = new Item(elementSettings().fireproof());

    private static Item.Settings elementSettings() {
        return new Item.Settings().group(ELEMENT);
    }

    public static void register() {
        register("iron_stand", new BlockItem(IRON_STAND, new Item.Settings().group(EQUIPMENT)));
        register("iron_trivet", new BlockItem(IRON_TRIVET, new Item.Settings().group(EQUIPMENT)));
        register("phosphorus_ore", new BlockItem(PHOSPHORUS_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        register("white_phosphorus_block", new BlockItem(WHITE_PHOSPHORUS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        register("red_phosphorus_block", new BlockItem(RED_PHOSPHORUS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        register("soul_jack_o_lantern", new BlockItem(SOUL_JACK_O_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS)));
        register("text_block", new BlockItem(TEST, new Item.Settings()));
        /* Fluid */
        register("phosphorus_acid_bucket", PHOSPHORICACID_BUCKET);
        /* Item */
        register("red_phosphorus", RED_PHOSPHORUS);
        /* Equipment */
        register("iron_stand_ring", IRON_STAND_RING);
        register("iron_stand_base", IRON_STAND_BASE);
        register("iron_stand_clip", IRON_STAND_CLIP);
        register("iron_stand_rod", IRON_STAND_ROD);
        register("iron_ring", IRON_RING);
        /* Hydrogen */
        register("hydrogen_1", HYDROGEN_1);
        register("hydrogen_2", HYDROGEN_2);
        register("hydrogen_3", HYDROGEN_3);
        register("hydrogen_4", HYDROGEN_4);
        register("hydrogen_5", HYDROGEN_5);
        register("hydrogen_6", HYDROGEN_6);
        register("hydrogen_7", HYDROGEN_7);
        /* Helium */
        register("helium_3", HELIUM_3);
        register("helium_4", HELIUM_4);
        register("helium_5", HELIUM_5);
        register("helium_6", HELIUM_6);
        register("helium_7", HELIUM_7);
        register("helium_8", HELIUM_8);
        register("helium_9", HELIUM_9);
        register("helium_10", HELIUM_10);
        /* Food */
        register("white_phosphorus", WHITE_PHOSPHORUS);
    }

    private static void register(String path, Item item) {
        Registry.register(Registry.ITEM, ofModIdentifier(path), item);
    }
}