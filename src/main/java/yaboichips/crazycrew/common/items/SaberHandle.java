package yaboichips.crazycrew.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.common.events.SaberSoundEvent;
import yaboichips.crazycrew.core.CCItems;
import yaboichips.crazycrew.core.CCSounds;

public class SaberHandle extends Item {
    public SaberHandle(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        world.playSound(null, player.blockPosition(), CCSounds.OPEN, SoundSource.NEUTRAL, 0.5F, 1.0F);
        player.setItemInHand(hand, CCItems.SABER.getDefaultInstance());
//        if (world.isClientSide) {
//            Minecraft.getInstance().getSoundManager().play(new SaberSoundEvent(player));
//        }
        return super.use(world, player, hand);
    }
}
