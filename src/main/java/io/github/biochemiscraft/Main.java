package io.github.biochemiscraft;

import io.github.biochemiscraft.block.Blocks;
import io.github.biochemiscraft.fluid.Fluids;
import io.github.biochemiscraft.item.ItemGroups;
import io.github.biochemiscraft.item.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static io.github.biochemiscraft.effect.Effects.ACUTE_PHOSPHORUS_POISONING;

public class Main implements ModInitializer {
    public static final String MODID = "biochemiscraft";

    /**
     * Creates identifier for the mod.
     *
     * @param path the path
     * @return the identifier
     */
    public static Identifier ofModIdentifier(String path) {
        return new Identifier(MODID, path);
    }

    public static final RegistryKey<PlacedFeature> PHOSPHORUS_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MODID,"ore_phosphorus"));

    @Override
    public void onInitialize() {
        Fluids.register();
        Blocks.register();
        Items.register();
        Items.FuelRegister();
        ItemGroups.register();
        /*Effects*/
        Registry.register(Registries.STATUS_EFFECT, ofModIdentifier("acute_phosphorus_poisoning"), ACUTE_PHOSPHORUS_POISONING);
        /*Ores*/
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PHOSPHORUS_ORE_PLACED_KEY);
    }
}
