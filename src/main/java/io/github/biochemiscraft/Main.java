package io.github.biochemiscraft;

import io.github.biochemiscraft.fluid.PhosphoricAcid;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
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

import static io.github.biochemiscraft.block.Blocks.*;
import static io.github.biochemiscraft.effect.Effects.*;
import static io.github.biochemiscraft.fluid.Fluids.*;
import static io.github.biochemiscraft.item.ItemGroups.*;
import static io.github.biochemiscraft.item.Items.*;

public class Main implements ModInitializer {
	public static final String MODID = "biochemiscraft";

	@Override
	public void onInitialize() {
		/*Block*/
		Registry.register(Registry.BLOCK, new Identifier(MODID, "iron_stand"), IRON_STAND);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand"), new BlockItem(IRON_STAND, new Item.Settings().group(EQUIPMENT)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "iron_trivet"), IRON_TRIVET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_trivet"), new BlockItem(IRON_TRIVET, new Item.Settings().group(EQUIPMENT)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "phosphorus_ore"), PHOSPHORUS_ORE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "phosphorus_ore"), new BlockItem(PHOSPHORUS_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "white_phosphorus_block"), WHITE_PHOSPHORUS_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "white_phosphorus_block"), new BlockItem(WHITE_PHOSPHORUS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "red_phosphorus_block"), RED_PHOSPHORUS_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "red_phosphorus_block"), new BlockItem(RED_PHOSPHORUS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "soul_jack_o_lantern"), SOUL_JACK_O_LANTERN);
		Registry.register(Registry.ITEM, new Identifier(MODID, "soul_jack_o_lantern"), new BlockItem(SOUL_JACK_O_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "text_block"), TEST);
		Registry.register(Registry.ITEM, new Identifier(MODID, "text_block"), new BlockItem(TEST, new Item.Settings()));
		/*Fluid*/
		Registry.register(Registry.FLUID, new Identifier(MODID, "phosphorus_acid"), new PhosphoricAcid.Still());
		Registry.register(Registry.FLUID, new Identifier(MODID, "flowing_phosphorus_acid"), new PhosphoricAcid.Flowing());
		Registry.register(Registry.ITEM, new Identifier(MODID, "phosphorus_acid_bucket"), new BucketItem(PHOSPHORICACID_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "phosphorus_acid"), new FluidBlock(PHOSPHORICACID_STILL, FabricBlockSettings.copy(Blocks.WATER)));
		/*Item*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "red_phosphorus"), RED_PHOSPHORUS);
		/*Equipment*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_ring"), IRON_STAND_RING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_base"), IRON_STAND_BASE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_clip"), IRON_STAND_CLIP);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_rod"), IRON_STAND_ROD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_ring"), IRON_RING);
		/*Hydrogen*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_1"), HYDROGEN_1);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_2"), HYDROGEN_2);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_3"), HYDROGEN_3);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_4"), HYDROGEN_4);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_5"), HYDROGEN_5);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_6"), HYDROGEN_6);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_7"), HYDROGEN_7);
		/*Helium*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_3"), HELIUM_3);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_4"), HELIUM_4);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_5"), HELIUM_5);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_6"), HELIUM_6);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_7"), HELIUM_7);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_8"), HELIUM_8);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_9"), HELIUM_9);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_10"), HELIUM_10);
		/*Food*/
		Registry.register(Registry.ITEM, new Identifier(MODID, "white_phosphorus"), WHITE_PHOSPHORUS);
		/*Effects*/
		Registry.register(Registry.STATUS_EFFECT, new Identifier(MODID, "acute_phosphorus_poisoning"), ACUTE_PHOSPHORUS_POISONING);
		/*Ores*/
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(MODID, "overworld_phosphorus_ore"), OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "overworld_phosphorus_ore"),
				OVERWORLD_PHOSPHORUS_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier(MODID, "overworld_phosphorus_ore")));
		/*Fuels*/
		FuelRegistry.INSTANCE.add(WHITE_PHOSPHORUS, 200);
		FuelRegistry.INSTANCE.add(WHITE_PHOSPHORUS_BLOCK, 2000);
		FuelRegistry.INSTANCE.add(RED_PHOSPHORUS, 200);
		FuelRegistry.INSTANCE.add(RED_PHOSPHORUS_BLOCK, 2000);
		FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
	}

	private static ConfiguredFeature<?, ?> OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
			(Feature.ORE, new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					PHOSPHORUS_ORE.getDefaultState(),
					9));

	public static PlacedFeature OVERWORLD_PHOSPHORUS_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_PHOSPHORUS_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(20),
					SquarePlacementModifier.of(),
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
			));
}
