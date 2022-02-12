package yaboichips.crazycrew.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class HairDye extends Item {
    public HairDye(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 1));
        world.playSound(null, player.blockPosition(), SoundEvents.SLIME_BLOCK_BREAK, SoundSource.NEUTRAL, 1, 1);
        player.getCooldowns().addCooldown(this, 600);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
