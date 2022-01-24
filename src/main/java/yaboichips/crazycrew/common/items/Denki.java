package yaboichips.crazycrew.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static net.minecraft.util.Mth.*;

public class Denki extends SwordItem {

    private static final Logger LOGGER = LogManager.getLogger();

    public Denki(final @NotNull Tier tier,
                 final int attackDamageIn,
                 final float attackSpeedIn,
                 final @NotNull Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(final @NotNull ItemStack stack,
                             final @NotNull LivingEntity target,
                             final @NotNull LivingEntity attacker) {
        final Random rng = new Random();
        final int i = rng.nextInt(10);
        final Level world = attacker.getLevel();
        final BlockPos blockpos = target.blockPosition();
        final LightningBolt lightningBoltEntity = EntityType.LIGHTNING_BOLT.create(world);
        if (i >= 9) {
            try {
                lightningBoltEntity.setPos(Vec3.atCenterOf(blockpos));
                world.addFreshEntity(lightningBoltEntity);
            } catch (final NullPointerException e) {
                LOGGER.error("CrazyCrew: Error summoning lightning bolt: \n");
                LOGGER.error(e.getStackTrace());
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
    

    @Override
    public @NotNull InteractionResultHolder<ItemStack>
            use(final @NotNull Level worldIn,
                final @NotNull Player playerIn,
                final @NotNull InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
            final float f7 = playerIn.getYRot();
            final float f = playerIn.getXRot();
            float f1 = -sin(f7 * ((float) Math.PI / 180F)) * cos(f * ((float)Math.PI / 180F));
            float f2 = -sin(f * ((float) Math.PI / 180F));
            float f3 = cos(f7 * ((float) Math.PI / 180F)) * cos(f * ((float)Math.PI / 180F));
            final float f4 = sqrt((f1 * f1) + (f2 * f2) + (f3 * f3));
            f1 *= 4.0 / f4;
            f2 *= 4.0 / f4;
            f3 *= 4.0 / f4;
            playerIn.push(f1 , 0, f3);
            
            final Level world = playerIn.level;
            
            final LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
            final LightningBolt lightningboltentity2 = EntityType.LIGHTNING_BOLT.create(world);
            final LightningBolt lightningboltentity3 = EntityType.LIGHTNING_BOLT.create(world);
            final LightningBolt lightningboltentity4 = EntityType.LIGHTNING_BOLT.create(world);
            final LightningBolt lightningboltentity5 = EntityType.LIGHTNING_BOLT.create(world);
            
            lightningboltentity.setPos(Vec3.atCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity);
            lightningboltentity2.setPos(Vec3.atCenterOf(new BlockPos(playerIn.getX() + 5, playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity2);
            lightningboltentity3.setPos(Vec3.atCenterOf(new BlockPos(playerIn.getX() - 5, playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity3);
            lightningboltentity4.setPos(Vec3.atCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ() + 5)));
            world.addFreshEntity(lightningboltentity4);
            lightningboltentity5.setPos(Vec3.atCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ() - 5)));
            world.addFreshEntity(lightningboltentity5);
            playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 600);
            playerIn.clearFire();
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }
}
