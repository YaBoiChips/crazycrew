package yaboichips.crazycrew.common.items;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import yaboichips.crazycrew.core.CCItems;
import yaboichips.crazycrew.core.CCSounds;

public class SaberItem extends SwordItem {
    public SaberItem(Tier tier, int damage, float cooldown, Properties properties) {
        super(tier, damage, cooldown, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        world.playSound(player, player.blockPosition(), CCSounds.CLOSE, SoundSource.NEUTRAL, 0.5F, 1.0F);
        player.setItemInHand(hand, CCItems.SABER_HANDLE.getDefaultInstance());
        return super.use(world, player, hand);
    }
}
