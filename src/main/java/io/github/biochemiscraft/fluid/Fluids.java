package io.github.biochemiscraft.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.registry.Registry;

import static io.github.biochemiscraft.Main.ofModIdentifier;

public class Fluids {
    public static final FlowableFluid PHOSPHORICACID_STILL = new PhosphoricAcid.Still();
    public static final FlowableFluid PHOSPHORICACID_FLOWING = new PhosphoricAcid.Flowing();

    public static void register() {
        Registry.register(Registry.FLUID, ofModIdentifier("phosphorus_acid"), PHOSPHORICACID_STILL);
        Registry.register(Registry.FLUID, ofModIdentifier("flowing_phosphorus_acid"), PHOSPHORICACID_FLOWING);
    }
}
