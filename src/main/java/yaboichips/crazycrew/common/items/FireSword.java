package yaboichips.crazycrew.common.items;


import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class FireSword extends SwordItem {

    public int fireTimer;

    public FireSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(10);
        return super.hurtEnemy(stack, target, attacker);
    }
    

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
            float f7 = playerIn.getYRot();
            float f = playerIn.getXRot();
            float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
            float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
            float f5 = 3.0F;
            f1 = f1 * (f5 / f4);
            f2 = f2 * (f5 / f4);
            f3 = f3 * (f5 / f4);
            playerIn.push(f1 , 0, f3);
            fireTimer = 60;
            worldIn.playSound(null, playerIn.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
            playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 600);
            playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0));
            playerIn.clearFire();
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity player, int p_41407_, boolean p_41408_) {
        if (isFireTimerActive()){
            fireTimer--;
            world.setBlock(player.getOnPos().above(), Blocks.FIRE.defaultBlockState(), 1);
            player.clearFire();
        }
        super.inventoryTick(stack, world, player, p_41407_, p_41408_);
    }

    public boolean isFireTimerActive() {
        return fireTimer > 0;
    }
}
