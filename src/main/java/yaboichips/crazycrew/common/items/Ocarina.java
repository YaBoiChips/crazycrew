package yaboichips.crazycrew.common.items;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.core.CCSounds;

import java.util.List;

public class Ocarina extends Item {
    public Ocarina(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
            AABB aabb = new AABB(player.blockPosition()).inflate(4);
            List<Player> list = world.getEntitiesOfClass(Player.class, aabb);
            ItemStack stack = player.getItemInHand(hand);
            player.getCooldowns().addCooldown(stack.getItem(), 600);
            world.playSound(null, player.blockPosition(), CCSounds.OCARINA, SoundSource.NEUTRAL, 0.2F, 1.0F);
            for (Player playerEntity : list) {
                if (playerEntity != player) {
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 1));
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
