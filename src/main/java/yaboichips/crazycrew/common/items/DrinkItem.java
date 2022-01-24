package yaboichips.crazycrew.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public final class DrinkItem extends Item {
    public DrinkItem(final @NotNull Item.Properties builder) {
        super(builder);
    }

    public @NotNull ItemStack
    finishUsingItem(final @NotNull ItemStack stack,
                    final @NotNull Level worldIn,
                    final @NotNull LivingEntity entityLiving) {
        super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }
            return stack;
    }



    public int getUseDuration(final @NotNull ItemStack stack) {
        return 20;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(final @NotNull ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack>
            use(final @NotNull Level level,
                final @NotNull Player player,
                final @NotNull InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}

