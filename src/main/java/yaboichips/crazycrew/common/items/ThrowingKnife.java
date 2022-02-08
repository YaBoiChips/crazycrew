package yaboichips.crazycrew.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.common.entites.ThrowingKnifeEntity;

public class ThrowingKnife extends SwordItem {
    public ThrowingKnife(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level world, final @NotNull Player player, final @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            stack.hurtAndBreak(1, player, (playerIn) -> {
                player.broadcastBreakEvent(hand);
            });
            ThrowingKnifeEntity knife = new ThrowingKnifeEntity(world, player, stack);
            knife.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F + (float) 3 * 0.5F, 1.0F);
            world.addFreshEntity(knife);
            world.playSound(null, knife, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
            player.getInventory().removeItem(stack);
        }
        return super.use(world, player, hand);

    }
}