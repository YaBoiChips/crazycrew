package yaboichips.crazycrew.common.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ThotSlayer extends SwordItem {


    public ThotSlayer(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(final @NotNull Level world, final @NotNull Player player, final @NotNull InteractionHand hand) {
        player.getCooldowns().addCooldown(this, 40);
        Vec3 vector3d = player.getLookAngle();
        player.lerpMotion(vector3d.x + 0.5, vector3d.y, vector3d.z + 0.5);
        return super.use(world, player, hand);
    }
}
