package io.github.biochemiscraft.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;

public class Recipes {
    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MODID, GlassMelting.Serializer.ID), GlassMelting.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MODID, GlassMelting.Type.ID), GlassMelting.Type.INSTANCE);
    }
}
