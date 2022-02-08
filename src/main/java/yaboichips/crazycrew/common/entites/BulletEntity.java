package yaboichips.crazycrew.common.entites;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.core.CCEntities;
import yaboichips.crazycrew.core.CCItems;

public class BulletEntity extends AbstractArrow {
    public BulletEntity(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
    }

    public BulletEntity(Level world, Player player, ItemStack stack) {
        super(CCEntities.BULLET, player, world);    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return CCItems.BULLET.getDefaultInstance();
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
