package net.justacricket.jamsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;
import static vectorwing.farmersdelight.common.FoodValues.*;

public class ModFoods {

    public static final FoodProperties MELON_JAM = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();

    public static final FoodProperties MELON_JAM_BOTTLE = (new FoodProperties.Builder())
            .nutrition(3).fast()
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, BRIEF_DURATION, 0), 1.0F).build();
}
