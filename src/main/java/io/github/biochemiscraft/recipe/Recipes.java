package io.github.biochemiscraft.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Recipes {
    public static final RecipeType<GlassMelting> GLASS_MELTING_TYPE = register(GlassMelting.ID);

    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, GlassMelting.ID, GlassMelting.Serializer.INSTANCE);
    }

    private static <T extends Recipe<?>> RecipeType<T> register(Identifier id) {
        return Registry.register(Registries.RECIPE_TYPE, id, new RecipeType<T>() {
            @Override
            public String toString() {
                return id.toString();
            }
        });
    }
}
