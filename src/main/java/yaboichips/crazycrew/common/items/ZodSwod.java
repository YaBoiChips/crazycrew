package yaboichips.crazycrew.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ZodSwod extends SwordItem {

    private int damageTimer;

    public ZodSwod(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level world, final @NotNull Player player, final @NotNull InteractionHand hand) {
        player.getCooldowns().addCooldown(this, 600);
        Vec3 look = player.getLookAngle();
        player.push(look.x * 2.5, 0.1, look.z * 2.5);
        setDamageTimer(30);
        return super.use(world, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int p_41407_, boolean p_41408_) {
        if (getDamageTimer() > 0) {
            AABB aabb = new AABB(entity.blockPosition());
            for (LivingEntity victim : world.getEntitiesOfClass(LivingEntity.class, aabb)) {
                if (victim != entity) {
                    victim.hurt(DamageSource.playerAttack((Player) entity), 7);
                }
            }
            setDamageTimer(getDamageTimer() - 1);
        }
        super.inventoryTick(stack, world, entity, p_41407_, p_41408_);
    }

    public int getDamageTimer() {
        return damageTimer;
    }

    public void setDamageTimer(int damageTimer) {
        this.damageTimer = damageTimer;
    }
}
