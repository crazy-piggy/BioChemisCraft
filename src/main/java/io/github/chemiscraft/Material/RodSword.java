package io.github.chemiscraft.Material;


import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RodSword implements ToolMaterial {

    public static final RodSword INSTANCE = new RodSword();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getAttackDamage() {
        return 5.0F;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_NUGGET);
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.0F;
    }

    @Override
    public int getEnchantability() {
        return 127;
    }

}
