package yaboichips.crazycrew.common.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SmokeBomb extends Item {
    public SmokeBomb(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        if (!world.isClientSide) {
            double d0 = player.getX();
            double d1 = player.getY();
            double d2 = player.getZ();
            world.playSound(null, d0, d1, d2, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);

            for (int i = 5; i < 32; ++i) {
                double d3 = player.getX() + (player.getRandom().nextDouble() - 0.5D) * 32.0D;
                double d4 = Mth.clamp(player.getY() + (double) (player.getRandom().nextInt(32) - 8), world.getMinBuildHeight(), world.getMinBuildHeight() + ((ServerLevel) world).getLogicalHeight() - 1);
                double d5 = player.getZ() + (player.getRandom().nextDouble() - 0.5D) * 32.0D;
                if (player.isPassenger()) {
                    player.stopRiding();
                }

                net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(player, d3, d4, d5);
                if (player.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                    world.playSound(null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    player.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }
            player.getCooldowns().addCooldown(this, 20);
        }

        if (world.isClientSide) {
            int h = 4;
            for (int x1 = player.blockPosition().getX() - h; x1 <= player.blockPosition().getX() + h; ++x1) {
                for (int y1 = player.blockPosition().getY(); y1 <= player.blockPosition().getY() + h; ++y1) {
                    for (int z1 = player.blockPosition().getZ() - h; z1 <= player.blockPosition().getZ() + h; ++z1) {
                        world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x1, y1, z1, 0D, 5.0E-4D, 0D);
                    }
                }
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
