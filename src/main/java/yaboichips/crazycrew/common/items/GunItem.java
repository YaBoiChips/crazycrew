package yaboichips.crazycrew.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.common.entites.BulletEntity;

public class GunItem extends Item {
    public GunItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level world, final @NotNull Player player, final @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            BulletEntity bullet = new BulletEntity(world, player, stack);
            bullet.setBaseDamage(0.1D);
            bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F + (float) 3 * 0.5F, 1.0F);
            world.addFreshEntity(bullet);
            world.playSound(null, bullet, SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return super.use(world, player, hand);
    }
}
