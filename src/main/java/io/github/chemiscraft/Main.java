package io.github.chemiscraft;

import io.github.chemiscraft.Blocks.Blocks;
import io.github.chemiscraft.Items.Phosphorus;
import io.github.chemiscraft.Material.RodSword;
import io.github.chemiscraft.Effects.AcutePhosphorusPoisoning;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MODID = "chemiscraft";
	/*Item Group*/
	public static final ItemGroup ELEMENT = FabricItemGroupBuilder.build(new Identifier(MODID, "element_group"), () -> new ItemStack(Main.HYDROGEN_1));
	public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(new Identifier(MODID,"equipment_group"), () -> new ItemStack(Main.IRON_STAND));
	/*Item*/
	/*Equipment*/
	public static final Item IRON_STAND_RING = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_BASE = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_CLIP = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_ROD = new SwordItem (RodSword.INSTANCE,5,1,new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_RING = new Item (new Item.Settings().group(EQUIPMENT));
	/*Food*/
	public static final Phosphorus WHITE_PHOSPHORUS = new Phosphorus (new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).alwaysEdible().snack().statusEffect(new StatusEffectInstance(new AcutePhosphorusPoisoning(),300,1),100.0f).build()));
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
	public static final Blocks.IronTrivet IRON_TRIVET = new Blocks.IronTrivet(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
	public static final Blocks.IronStand IRON_STAND = new Blocks.IronStand(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
	/*Effects*/
	public static final StatusEffect ACUTE_PHOSPHORUS_POISONING = new AcutePhosphorusPoisoning();
	@Override
	public void onInitialize() {
		/*Block*/
		Registry.register(Registry.BLOCK, new Identifier(MODID, "iron_stand"), IRON_STAND);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand"), new BlockItem(IRON_STAND, new Item.Settings().group(EQUIPMENT)));
		Registry.register(Registry.BLOCK, new Identifier(MODID, "iron_trivet"), IRON_TRIVET);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_trivet"), new BlockItem(IRON_TRIVET, new Item.Settings().group(EQUIPMENT)));
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
	}
}
