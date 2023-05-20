package io.github.biochemiscraft;

import io.github.biochemiscraft.screen.GlassMeltingFurnaceScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

import static io.github.biochemiscraft.screen.ScreenHandlers.GLASS_MELTING_FURNACE_SCREEN_HANDLER;

public class ClientMain implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(GLASS_MELTING_FURNACE_SCREEN_HANDLER, GlassMeltingFurnaceScreen::new);
    }
}
