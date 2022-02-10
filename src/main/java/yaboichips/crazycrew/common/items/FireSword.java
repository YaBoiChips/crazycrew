package yaboichips.crazycrew.common.items;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.PI;
import static net.minecraft.util.Mth.*;

public final class FireSword extends SwordItem {

    public int fireTimer;

    public FireSword(final @NotNull Tier tier, final int attackDamageIn, final float attackSpeedIn, final @NotNull Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(final @NotNull ItemStack stack, final @NotNull LivingEntity target, final @NotNull LivingEntity attacker) {
        target.setSecondsOnFire(10);
        return super.hurtEnemy(stack, target, attacker);
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level worldIn, final @NotNull Player playerIn, final @NotNull InteractionHand handIn) {
        if (!worldIn.isClientSide) {
            ItemStack item = playerIn.getItemInHand(handIn);
            if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
                final float f7 = playerIn.getYRot();
                final float f = playerIn.getXRot();
                float f1 = -sin(f7 * ((float) PI / 180F)) * cos(f * ((float) PI / 180F));
                float f2 = -sin(f * ((float) PI / 180F));
                float f3 = cos(f7 * ((float) PI / 180F)) * cos(f * ((float) PI / 180F));
                final float f4 = sqrt((f1 * f1) + (f2 * f2) + (f3 * f3));
                f1 *= 3.0 / f4;
                f3 *= 3.0 / f4;
                playerIn.push(f1, 0, f3);
                fireTimer = 60;
                worldIn.playSound(null, playerIn.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 600);
                playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0));
                playerIn.clearFire();
            }
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
        }
        return InteractionResultHolder.fail(playerIn.getItemInHand(handIn));
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack stack, final @NotNull Level world, final @NotNull Entity player, final int p_41407_, final boolean p_41408_) {
        if (world.isClientSide) return;
            if (fireTimer > 0) {
            fireTimer--;
            world.setBlock(player.getOnPos().above(), Blocks.FIRE.defaultBlockState(), 1);
            player.clearFire();
        }
        super.inventoryTick(stack, world, player, p_41407_, p_41408_);
    }
}
