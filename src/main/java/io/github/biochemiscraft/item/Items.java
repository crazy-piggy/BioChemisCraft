package io.github.biochemiscraft.item;

import io.github.biochemiscraft.material.RodSword;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

import static io.github.biochemiscraft.effect.Effects.*;
import static io.github.biochemiscraft.item.ItemGroups.*;

public class Items {
    public static final Item RED_PHOSPHORUS = new Item(new Item.Settings().group(ItemGroup.MISC));
    /*Equipment*/
    public static final Item IRON_STAND_RING = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_BASE = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_CLIP = new Item(new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_STAND_ROD = new SwordItem(RodSword.INSTANCE, 5, 1, new Item.Settings().group(EQUIPMENT));
    public static final Item IRON_RING = new Item(new Item.Settings().group(EQUIPMENT));
    /*Food*/
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
    /*Hydrogen*/
    public static final Item HYDROGEN_1 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_2 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_3 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_4 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_5 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_6 = new Item(new Item.Settings().group(ELEMENT));
    public static final Item HYDROGEN_7 = new Item(new Item.Settings().group(ELEMENT));
    /*Helium*/
    public static final Item HELIUM_3 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_4 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_5 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_6 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_7 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_8 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_9 = new Item(new Item.Settings().fireproof().group(ELEMENT));
    public static final Item HELIUM_10 = new Item(new Item.Settings().fireproof().group(ELEMENT));

}
