package yaboichips.crazycrew.common.entites;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.core.CCDamageSource;
import yaboichips.crazycrew.core.CCEntities;
import yaboichips.crazycrew.core.CCItems;

public class PieEntity extends ThrowableItemProjectile {
    public PieEntity(EntityType<? extends PieEntity> type, Level world) {
        super(type, world);
    }

    public PieEntity(Level world, LivingEntity entity){
        super(CCEntities.PIE, entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return CCItems.PIE;
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
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
        Entity entity = result.getEntity();
        super.onHitEntity(result);
        if (entity instanceof LivingEntity) {
            entity.hurt(CCDamageSource.PIE, 1.5F);
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
