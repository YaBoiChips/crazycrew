package yaboichips.crazycrew.common.events;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.items.ColMustard;
import yaboichips.crazycrew.common.items.SpaceHelmet;
import yaboichips.crazycrew.core.CCKeybinds;

@Mod.EventBusSubscriber(modid = CrazyCrew.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    public BlockPos checkedPos;
    public boolean isChecking;
    public boolean hasDoubleJumped = false;

    @SubscribeEvent
    public void doColMustard(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level world = player.level;
        Item item = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if (event.phase != TickEvent.Phase.END || world.isClientSide) return;
        if (item instanceof ColMustard) {
            if (CCKeybinds.USE_ITEM.isDown()) {
                checkedPos = player.blockPosition().above(2);
                isChecking = true;
            }
            if (isChecking) {
                if (!player.getCooldowns().isOnCooldown(item)) {
                    if (world.getBlockState(checkedPos) == Blocks.AIR.defaultBlockState() && world.getBlockState(checkedPos.above()) == Blocks.AIR.defaultBlockState() && world.getBlockState(checkedPos.below()) != Blocks.AIR.defaultBlockState()) {
                        player.setPos(checkedPos.getX(), checkedPos.getY(), checkedPos.getZ());
                        world.playSound(null, checkedPos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1, 1);
                        player.getCooldowns().addCooldown(item, 600);
                        isChecking = false;
                    } else {
                        checkedPos = checkedPos.above();
                        if (checkedPos.getY() >= 240) {
                            throw new IllegalStateException("Block Not Available");
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void doSpaceJump(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        Level world = player.level;
        Item item = player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        if (event.phase != TickEvent.Phase.END || !world.isClientSide) return;
        if (item instanceof SpaceHelmet) {
            if (CCKeybinds.USE_ITEM.isDown()) {
                System.out.println("cringe");
                if (!hasDoubleJumped) {
                    Vec3 vector3d = player.getLookAngle();
                    player.lerpMotion(vector3d.x + 1, vector3d.y + 1, vector3d.z + 1);
                    player.getCooldowns().addCooldown(item, 600);
                    hasDoubleJumped = true;
                }
            }
            if (player.isOnGround()) {
                hasDoubleJumped = false;
            }
        }
    }
}
