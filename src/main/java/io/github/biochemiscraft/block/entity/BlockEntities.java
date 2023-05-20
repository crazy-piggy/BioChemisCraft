package io.github.biochemiscraft.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;
import static io.github.biochemiscraft.block.Blocks.GLASS_MELTING_FURNACE;

public class BlockEntities {
    public static BlockEntityType<GlassMeltingFurnaceEntity> GLASS_MELTING_FURNACE_ENTITY;

    public static void register() {
        GLASS_MELTING_FURNACE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MODID, "glass_melting_furnace"), FabricBlockEntityTypeBuilder.create(GlassMeltingFurnaceEntity::new, GLASS_MELTING_FURNACE).build(null));
    }
}
