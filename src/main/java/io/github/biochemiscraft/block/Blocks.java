package io.github.biochemiscraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

import static net.minecraft.block.Blocks.WATER;
import static io.github.biochemiscraft.fluid.Fluids.*;

public class Blocks {
    public static final Block TEST = new BioChemisCraftBlockBuilder()
            .minX(0.0)
            .minY(0.0)
            .minZ(0.0)
            .maxX(1.0)
            .maxY(0.5)
            .maxZ(1.0)
            .build(AbstractBlock.Settings.of(Material.BAMBOO, MapColor.BLACK));
    public static final IronTrivet IRON_TRIVET = new IronTrivet(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
    public static final IronStand IRON_STAND = new IronStand(FabricBlockSettings.of(Material.METAL).hardness(0.1f));
    public static final Block PHOSPHORUS_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final PhosphorusBlock WHITE_PHOSPHORUS_BLOCK = new PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static final PhosphorusBlock RED_PHOSPHORUS_BLOCK = new PhosphorusBlock(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static final SJOL SOUL_JACK_O_LANTERN = new SJOL(FabricBlockSettings.of(Material.METAL).hardness(1.5f));
    public static Block PHOSPHORICACID = new FluidBlock(PHOSPHORICACID_STILL, FabricBlockSettings.copy(WATER));
}
