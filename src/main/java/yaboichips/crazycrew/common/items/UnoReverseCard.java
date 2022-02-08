package yaboichips.crazycrew.common.items;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnoReverseCard extends Item {

    public UnoReverseCard(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        AABB aabb = new AABB(player.blockPosition()).inflate(4);
        List<Player> list = world.getEntitiesOfClass(Player.class, aabb);
        for (Player playerEntity : list) {
            if (playerEntity instanceof ServerPlayer) {
                if (playerEntity != player && world.isClientSide) {
                    playerEntity.setXRot(-playerEntity.getXRot());
                    playerEntity.setYRot(-playerEntity.getYRot());
                    playerEntity.setDeltaMovement(playerEntity.getDeltaMovement().reverse());
                }
            }
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
