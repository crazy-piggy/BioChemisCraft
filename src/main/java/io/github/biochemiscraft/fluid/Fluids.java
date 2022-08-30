package io.github.biochemiscraft.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Fluids {
    public static final FlowableFluid PHOSPHORICACID_STILL = new PhosphoricAcid.Still();
    public static final FlowableFluid PHOSPHORICACID_FLOWING = new PhosphoricAcid.Flowing();
    public static final Item PHOSPHORICACID_BUCKET = new BucketItem(PHOSPHORICACID_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));
}
