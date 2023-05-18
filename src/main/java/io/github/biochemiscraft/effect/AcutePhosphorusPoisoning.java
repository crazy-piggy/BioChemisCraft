package io.github.biochemiscraft.effect;

import io.github.biochemiscraft.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class AcutePhosphorusPoisoning extends StatusEffect {
    public AcutePhosphorusPoisoning() {
        super(StatusEffectCategory.HARMFUL, 0x4E9331);
    }

    public static final RegistryKey<DamageType> DT_ACUTE_PHOSPHORUS_POISONING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Main.ofModIdentifier("acute_phosphorus_poisoning"));

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {//data pack

        float amount = 15.0f + amplifier;

        Registry<DamageType> registry = entity.world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE);
        entity.damage(new DamageSource(registry.entryOf(DT_ACUTE_PHOSPHORUS_POISONING)), amount);
        /*
          baka4n
         */
        super.applyUpdateEffect(entity, amplifier);
    }
}
