package io.github.biochemiscraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static io.github.biochemiscraft.Main.MODID;

public class ScreenHandlers {
    public static ScreenHandlerType<GlassMeltingFurnaceScreenHandler> GLASS_MELTING_FURNACE_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(GlassMeltingFurnaceScreenHandler::new);

    public static void register() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MODID, "glass_melting_furnace"), GLASS_MELTING_FURNACE_SCREEN_HANDLER);
    }
}
