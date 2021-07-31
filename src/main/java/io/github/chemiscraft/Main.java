package io.github.chemiscraft;

import io.github.chemiscraft.__Blocks__.__Block__;
import io.github.chemiscraft.__Items__.Phosphorus;
import io.github.chemiscraft.Materials.RodSword;
import io.github.chemiscraft.__Effects__.AcutePhosphorusPoisoning;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class Main implements ModInitializer {
	public static final String MODID = "chemiscraft";
	/*Item Group*/
	public static final ItemGroup ELEMENT = FabricItemGroupBuilder.build(new Identifier(MODID, "element_group"), () -> new ItemStack(Main.HYDROGEN_1));
	public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(new Identifier(MODID,"equipment_group"), () -> new ItemStack(Main.IRON_STAND));
	/*Item*/
	public static final Item RED_PHOSPHORUS = new Item (new Item.Settings().group(ItemGroup.MISC));
	/*Equipment*/
	public static final Item IRON_STAND_RING = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_BASE = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_CLIP = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_ROD = new SwordItem (RodSword.INSTANCE,5,1,new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_RING = new Item (new Item.Settings().group(EQUIPMENT));
	/*Food*/
	public static final Phosphorus WHITE_PHOSPHORUS = new Phosphorus (new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).alwaysEdible().snack().statusEffect(new StatusEffectInstance(new AcutePhosphorusPoisoning(),50,1/*175伤害!*/),100.0f).build()));
	/*Hydrogen*/
	public static final Item HYDROGEN_1 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_2 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_3 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_4 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_5 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_6 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_7 = new Item(new Item.Settings().group(ELEMENT));
	/*Helium*/
	public static final Item HELIUM_3 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_4 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_5 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_6 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_7 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_8 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_9 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	public static final Item HELIUM_10 = new Item (new Item.Settings().fireproof().group(ELEMENT));
	/*Block*/
	public static final __Block__.IronTrivet IRON_TRIVET = new __Block__.IronTrivet(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
	public static final __Block__.IronStand IRON_STAND = new __Block__.IronStand(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
	public static final Block PHOSPHORUS_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(2.0f));
	public static final __Block__.PhosphorusBlock WHITE_PHOSPHORUS_BLOCK = new __Block__.PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
	public static final __Block__.PhosphorusBlock RED_PHOSPHORUS_BLOCK = new __Block__.PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
	public static final __Block__.SJOL SOUL_JACK_O_LANTERN = new __Block__.SJOL(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
	/*Effects*/
	public static final StatusEffect ACUTE_PHOSPHORUS_POISONING = new AcutePhosphorusPoisoning();
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
		Registry.register(Registry.BLOCK,new Identifier(MODID, "red_phosphorus_block"),RED_PHOSPHORUS_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "red_phosphorus_block"), new BlockItem(RED_PHOSPHORUS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK,new Identifier(MODID, "soul_jack_o_lantern"),SOUL_JACK_O_LANTERN);
		Registry.register(Registry.ITEM, new Identifier(MODID, "soul_jack_o_lantern"), new BlockItem(SOUL_JACK_O_LANTERN, new Item.Settings().group(ItemGroup.DECORATIONS)));
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
		RegistryKey<ConfiguredFeature<?, ?>> orePhosphorusOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MODID, "ore_phosphorus_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, orePhosphorusOverworld.getValue(), ORE_PHOSPHORUS_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, orePhosphorusOverworld);
		/*Fuels*/
		FuelRegistry.INSTANCE.add(WHITE_PHOSPHORUS,200);
		FuelRegistry.INSTANCE.add(WHITE_PHOSPHORUS_BLOCK,2000);
		FuelRegistry.INSTANCE.add(RED_PHOSPHORUS, 200);
		FuelRegistry.INSTANCE.add(RED_PHOSPHORUS_BLOCK,2000);
		FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 1200);
	}

	private static final ConfiguredFeature<?, ?> ORE_PHOSPHORUS_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Main.PHOSPHORUS_ORE.getDefaultState(), 9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))).spreadHorizontally().repeat(128);
}
