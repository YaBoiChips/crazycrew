package yaboichips.crazycrew.common.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.core.CCKeybinds;

public class SpaceHelmet extends ArmorItem {

    public boolean hasDoubleJumped;

    public SpaceHelmet(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack stack, final @NotNull Level world, final @NotNull Entity player, final @NotNull int p_41407_, final @NotNull boolean p_41408_) {
        if (world.isClientSide) return;
        if (player instanceof Player) {
            if (CCKeybinds.USE_ITEM.isDown() && !hasDoubleJumped) {
                Vec3 vector3d = player.getLookAngle();
                player.lerpMotion(vector3d.x + 1, vector3d.y + 1, vector3d.z + 1);
                ((Player) player).getCooldowns().addCooldown(this, 600);
                hasDoubleJumped = true;
            }
            if (player.isOnGround()) {
                hasDoubleJumped = false;
            }
        }
        super.inventoryTick(stack, world, player, p_41407_, p_41408_);
    }
}
