package io.github.chemiscraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Settings;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.chemiscraft.Main.MODID;

public class Blocks {
	public static final Block IRON_STAND = of(new Block("iron_stand", Settings.of(Material.METAL).hardness(0)));

    private static <T extends Block> T of(String name, T block) {
        return Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
    }

    /** Load class */
    public static void register() { }
}
