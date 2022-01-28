package yaboichips.crazycrew.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class LuckSword extends SwordItem {
    public LuckSword(final @NotNull Tier tier, final int attackDamageIn, final float attackSpeedIn, final @NotNull Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        player.addEffect(new MobEffectInstance(getRandomEffect(world.random), 300, 1));
        player.getCooldowns().addCooldown(player.getItemInHand(hand).getItem(), 600);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    public MobEffect getRandomEffect(@NotNull final Random rand) {
        int i = rand.nextInt(6);
        return switch (i) {
            case 1 -> MobEffects.INVISIBILITY;
            case 2 -> MobEffects.REGENERATION;
            case 3 -> MobEffects.FIRE_RESISTANCE;
            case 4 -> MobEffects.ABSORPTION;
            case 5 -> MobEffects.DAMAGE_RESISTANCE;
            default -> MobEffects.GLOWING;
        };
    }
}