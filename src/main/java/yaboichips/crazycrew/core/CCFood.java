package yaboichips.crazycrew.core;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public final class CCFood {

    public static final FoodProperties CELERY = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().effect(new MobEffectInstance(MobEffects.JUMP, 300, 4), 1.0F).alwaysEat().build();
    public static final FoodProperties MACARON = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties GOLDEN_CHEEZE_ITS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 500, 0), 1.0F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties KETCHUP_CHIPS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2), 1.0F).effect(new MobEffectInstance(MobEffects.CONFUSION, 250, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.6F).effect(new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0F).build();
    public static final FoodProperties STIMPACK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).fast().effect(new MobEffectInstance(MobEffects.HEAL, 3, 1), 1.0F).build();
    public static final FoodProperties COFFEE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 3), 1.0F).build();
    public static final FoodProperties CHICKEN_STRIPS = (new FoodProperties.Builder()).nutrition(7).saturationMod(1.4F).effect(new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0F).build();
    public static final FoodProperties FREEZE_DRIED_ICE_CREAM = (new FoodProperties.Builder()).nutrition(7).saturationMod(1.4F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 3), 1.0F).build();
    public static final FoodProperties ONIGIRI = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties CHOCKOLATE_MILK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), 1.0F).build();

}
