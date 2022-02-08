package yaboichips.crazycrew.common.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ZoomyBoots extends ArmorItem {
    public ZoomyBoots(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }


    @Override
    public void inventoryTick(@NotNull final ItemStack stack, @NotNull final Level world, @NotNull final Entity entity, int smthn, boolean bool) {
        if (entity instanceof Player) {
            if (((Player) entity).getItemBySlot(EquipmentSlot.FEET) == stack) {
                ((Player) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 2, false, false));
                if (entity.isSprinting()) {
                    world.addParticle(ParticleTypes.ELECTRIC_SPARK, entity.getX(), entity.getY(), entity.getZ(), 0D, 1D, 0D);
                    entity.maxUpStep = 1.0f;
                } else {
                    entity.maxUpStep = 0f;
                }
            }
        }
        super.inventoryTick(stack, world, entity, smthn, bool);
    }
}
