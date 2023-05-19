package io.github.biochemiscraft.recipe;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.item.Item;
import net.minecraft.text.Text;

import java.util.Set;

public class GlassMelting extends AbstractFurnaceRecipeBookScreen {
    private static final Text TOGGLE_GLASS_RECIPES_TEXT = Text.translatable("gui.recipebook.toggleRecipes.glass_melting");

    public GlassMelting() {
    }

    protected Text getToggleCraftableButtonText() {
        return TOGGLE_GLASS_RECIPES_TEXT;
    }

    protected Set<Item> getAllowedFuels() {
        return AbstractFurnaceBlockEntity.createFuelTimeMap().keySet();
    }
}
