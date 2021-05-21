package io.github.chemiscraft;

import io.github.chemiscraft.block.Blocks;
import io.github.chemiscraft.item.Items;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    public static final String MODID = "chemiscraft";

    @Override
    public void onInitialize() {
        Blocks.register();
        Items.register();
    }
}
