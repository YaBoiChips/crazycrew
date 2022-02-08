package yaboichips.crazycrew.common.entites;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import yaboichips.crazycrew.core.CCEntities;
import yaboichips.crazycrew.core.CCItems;

public class PieEntity extends Snowball {
    public PieEntity(EntityType<? extends PieEntity> type, Level world) {
        super(CCEntities.PIE, world);
    }

    @Override
    protected Item getDefaultItem() {
        return CCItems.PIE;
    }


    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return itemstack.isEmpty() ? ParticleTypes.CRIT : new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

    public void handleEntityEvent(byte j) {
        if (j == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (entity instanceof Player) {
            entity.hurt(DamageSource.thrown(this, this.getOwner()), 1.5F);
            ((Player) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
        }
    }
}
