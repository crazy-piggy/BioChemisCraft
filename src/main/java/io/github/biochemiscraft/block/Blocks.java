package io.github.biochemiscraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static io.github.biochemiscraft.Main.ofModIdentifier;
import static io.github.biochemiscraft.fluid.Fluids.PHOSPHORICACID_STILL;
import static net.minecraft.block.Blocks.WATER;

public class Blocks {
    public static final IronTrivet IRON_TRIVET = new IronTrivet(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
    public static final IronStand IRON_STAND = new IronStand(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
    public static final Block PHOSPHORUS_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final PhosphorusBlock WHITE_PHOSPHORUS_BLOCK = new PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static final PhosphorusBlock RED_PHOSPHORUS_BLOCK = new PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static final SJOL SOUL_JACK_O_LANTERN = new SJOL(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static final Block PHOSPHORICACID = new FluidBlock(PHOSPHORICACID_STILL, FabricBlockSettings.copy(WATER));
//    public static final SoulFurnace SOUL_FURNACE = new SoulFurnace(FabricBlockSettings.of(Material.STONE));

    public static void register() {
        register("iron_stand", IRON_STAND);
        register("iron_trivet", IRON_TRIVET);
        register("phosphorus_ore", PHOSPHORUS_ORE);
        register("white_phosphorus_block", WHITE_PHOSPHORUS_BLOCK);
        register("red_phosphorus_block", RED_PHOSPHORUS_BLOCK);
        register("soul_jack_o_lantern", SOUL_JACK_O_LANTERN);
        register("phosphorus_acid", PHOSPHORICACID);
//        register("soul_furnace", SOUL_FURNACE);
    }

    private static void register(String path, Block block) {
        Registry.register(Registries.BLOCK, ofModIdentifier(path), block);
    }
}
