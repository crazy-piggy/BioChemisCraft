package io.github.biochemiscraft.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static io.github.biochemiscraft.Main.ofModIdentifier;

public class Recipes {
    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, ofModIdentifier(GlassMelting.Serializer.ID), GlassMelting.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, ofModIdentifier(GlassMelting.Type.ID), GlassMelting.Type.INSTANCE);
    }
}
