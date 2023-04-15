package io.github.biochemiscraft.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static io.github.biochemiscraft.Main.ofModIdentifier;

public class Fluids {
    public static final FlowableFluid PHOSPHORICACID_STILL = new PhosphoricAcid.Still();
    public static final FlowableFluid PHOSPHORICACID_FLOWING = new PhosphoricAcid.Flowing();

    public static void register() {
        Registry.register(Registries.FLUID, ofModIdentifier("phosphorus_acid"), PHOSPHORICACID_STILL);
        Registry.register(Registries.FLUID, ofModIdentifier("flowing_phosphorus_acid"), PHOSPHORICACID_FLOWING);
    }
}
