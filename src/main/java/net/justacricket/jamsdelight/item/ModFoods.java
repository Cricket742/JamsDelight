package net.justacricket.jamsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;
import static vectorwing.farmersdelight.common.FoodValues.*;

public class ModFoods {

    public static final FoodProperties MELON_JAM = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();


}
