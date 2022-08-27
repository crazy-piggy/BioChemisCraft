package io.github.biochemiscraft.__Effects__;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class AcutePhosphorusPoisoning extends StatusEffect {
    public AcutePhosphorusPoisoning(){
        super(StatusEffectCategory.HARMFUL, 0x4E9331);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            entity.damage(DamageSource.MAGIC,15.0f);
        }
    }
}
