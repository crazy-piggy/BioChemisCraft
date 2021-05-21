package io.github.chemiscraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MODID = "chemiscraft";
	//Item Group
	public static final ItemGroup ELEMENT = FabricItemGroupBuilder.build(new Identifier("chemiscraft", "element_group"), () -> new ItemStack(Main.HYDROGEN_1));
	public static final ItemGroup EQUIPMENT = FabricItemGroupBuilder.build(new Identifier("chemiscraft","equipment_group"), () -> new ItemStack(Main.HELIUM_3));
	//Item
	//Equipment
	public static final Item IRON_STAND_RING = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_BASE = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_CLIP = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_STAND_ROD = new Item (new Item.Settings().group(EQUIPMENT));
	public static final Item IRON_RING = new Item (new Item.Settings().group(EQUIPMENT));
	//Hydrogen
	public static final Item HYDROGEN_1 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_2 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_3 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_4 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_5 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_6 = new Item(new Item.Settings().group(ELEMENT));
	public static final Item HYDROGEN_7 = new Item(new Item.Settings().group(ELEMENT));
	//Helium
	public static final Item HELIUM_3 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_4 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_5 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_6 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_7 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_8 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_9 = new Item (new Item.Settings().group(ELEMENT));
	public static final Item HELIUM_10 = new Item (new Item.Settings().group(ELEMENT));

	//Block
	public static final Block IRON_STAND = new Block(FabricBlockSettings.of(Material.METAL).hardness(0.0f));

	@Override
	public void onInitialize() {
		//Block
		Registry.register(Registry.BLOCK, new Identifier(MODID, "iron_stand"), IRON_STAND);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand"), new BlockItem(IRON_STAND, new Item.Settings().group(EQUIPMENT)));
		//Equipment

		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_ring"), IRON_STAND_RING);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_base"), IRON_STAND_BASE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_clip"), IRON_STAND_CLIP);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_stand_rod"), IRON_STAND_ROD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "iron_ring"), IRON_RING);
		//Hydrogen
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_1"), HYDROGEN_1);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_2"), HYDROGEN_2);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_3"), HYDROGEN_3);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_4"), HYDROGEN_4);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_5"), HYDROGEN_5);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_6"), HYDROGEN_6);
		Registry.register(Registry.ITEM, new Identifier(MODID, "hydrogen_7"), HYDROGEN_7);
		//Helium
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_3"), HELIUM_3);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_4"), HELIUM_4);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_5"), HELIUM_5);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_6"), HELIUM_6);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_7"), HELIUM_7);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_8"), HELIUM_8);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_9"), HELIUM_9);
		Registry.register(Registry.ITEM, new Identifier(MODID, "helium_10"), HELIUM_10);

	}
}
