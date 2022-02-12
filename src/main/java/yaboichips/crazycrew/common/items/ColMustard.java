package yaboichips.crazycrew.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.core.CCKeybinds;

public class ColMustard extends ArmorItem {

    public BlockPos checkedPos;
    public boolean isChecking;

    public ColMustard(final @NotNull ArmorMaterial material, final @NotNull EquipmentSlot slot, final @NotNull Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack stack, final @NotNull Level world, final @NotNull Entity player, final @NotNull int p_41407_, final @NotNull boolean p_41408_) {
        if (!world.isClientSide) return;
        if (player instanceof Player) {
            if (CCKeybinds.USE_ITEM.isDown()) {
                checkedPos = player.blockPosition().above();
                isChecking = true;
            }
            if (isChecking) {
                if (!((Player) player).getCooldowns().isOnCooldown(stack.getItem())) {
                    if (world.getBlockState(checkedPos) == Blocks.AIR.defaultBlockState() && world.getBlockState(checkedPos.above()) == Blocks.AIR.defaultBlockState() && world.getBlockState(checkedPos.below()) != Blocks.AIR.defaultBlockState()) {
                        player.setPos(checkedPos.getX(), checkedPos.getY(), checkedPos.getZ());
                        world.playSound(null, checkedPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1, 1);
                        ((Player) player).getCooldowns().addCooldown(stack.getItem(), 600);
                        isChecking = false;
                    } else {
                        checkedPos = checkedPos.above();
                        if (checkedPos.getY() >= 240) {
                            return;
                        }
                    }
                }
            }
        }
        super.inventoryTick(stack, world, player, p_41407_, p_41408_);
    }
}
