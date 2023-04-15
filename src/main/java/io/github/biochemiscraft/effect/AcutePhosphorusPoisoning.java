package io.github.biochemiscraft.effect;

import com.mojang.datafixers.util.Either;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AcutePhosphorusPoisoning extends StatusEffect {
    public AcutePhosphorusPoisoning() {
        super(StatusEffectCategory.HARMFUL, 0x4E9331);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) entity.damage(new DamageSource(new RegistryEntry<>() {
            @Override
            public DamageType value() {
                return null;
            }

            @Override
            public boolean hasKeyAndValue() {
                return false;
            }

            @Override
            public boolean matchesId(Identifier id) {
                return false;
            }

            @Override
            public boolean matchesKey(RegistryKey<DamageType> key) {
                return false;
            }

            @Override
            public boolean matches(Predicate<RegistryKey<DamageType>> predicate) {
                return false;
            }

            @Override
            public boolean isIn(TagKey<DamageType> tag) {
                return false;
            }

            @Override
            public Stream<TagKey<DamageType>> streamTags() {
                return null;
            }

            @Override
            public Either<RegistryKey<DamageType>, DamageType> getKeyOrValue() {
                return null;
            }

            @Override
            public Optional<RegistryKey<DamageType>> getKey() {
                return Optional.empty();
            }

            @Override
            public Type getType() {
                return null;
            }

            @Override
            public boolean ownerEquals(RegistryEntryOwner<DamageType> owner) {
                return false;
            }
        }), 15.0f)/*entity.damage(new DamageSource(DamageEffects.POKING), 15.0f + amplifier)*/;
    }
}
