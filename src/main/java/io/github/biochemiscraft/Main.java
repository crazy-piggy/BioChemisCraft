package io.github.biochemiscraft;

import io.github.biochemiscraft.block.Blocks;
import io.github.biochemiscraft.fluid.Fluids;
import io.github.biochemiscraft.item.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

import static io.github.biochemiscraft.effect.Effects.ACUTE_PHOSPHORUS_POISONING;
import static net.minecraft.item.Items.BLAZE_POWDER;

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

    @Override
    public void onInitialize() {
        Fluids.register();
        Blocks.register();
        Items.register();
        /*Effects*/
        Registry.register(Registry.STATUS_EFFECT, ofModIdentifier("acute_phosphorus_poisoning"), ACUTE_PHOSPHORUS_POISONING);
        /*Ores*/
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                ofModIdentifier("overworld_phosphorus_ore"), OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, ofModIdentifier("overworld_phosphorus_ore"),
                OVERWORLD_PHOSPHORUS_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        ofModIdentifier("overworld_phosphorus_ore")));
        /*Fuels*/
        FuelRegistry.INSTANCE.add(Items.WHITE_PHOSPHORUS, 200);
        FuelRegistry.INSTANCE.add(Blocks.WHITE_PHOSPHORUS_BLOCK, 2000);
        FuelRegistry.INSTANCE.add(Items.RED_PHOSPHORUS, 200);
        FuelRegistry.INSTANCE.add(Blocks.RED_PHOSPHORUS_BLOCK, 2000);
        FuelRegistry.INSTANCE.add(BLAZE_POWDER, 1200);
    }

    private static final ConfiguredFeature<?, ?> OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
            Feature.ORE, new OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            Blocks.PHOSPHORUS_ORE.getDefaultState(),
            9)
    );

    public static final PlacedFeature OVERWORLD_PHOSPHORUS_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            ));
}
