package yaboichips.crazycrew.common.items;


import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
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

import java.util.Random;

public class Denki extends SwordItem {
    public Denki(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random rand = new Random();
        int i = rand.nextInt(10);
        Level world = attacker.getLevel();
        BlockPos blockpos = target.blockPosition();
        LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
        if (i >= 9) {
            lightningboltentity.setPos(Vec3.atCenterOf(blockpos));
            world.addFreshEntity(lightningboltentity);
        }
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
            float f5 = 4.0F;
            f1 = f1 * (f5 / f4);
            f2 = f2 * (f5 / f4);
            f3 = f3 * (f5 / f4);
            playerIn.push(f1 , 0, f3);
            Level world = playerIn.level;
            LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity2 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity3 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity4 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity5 = EntityType.LIGHTNING_BOLT.create(world);
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
