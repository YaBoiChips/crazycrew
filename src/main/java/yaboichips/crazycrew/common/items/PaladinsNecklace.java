package yaboichips.crazycrew.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PaladinsNecklace extends Item {
    public PaladinsNecklace(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        player.curePotionEffects(this.getDefaultInstance());
        player.getCooldowns().addCooldown(this, 600);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
