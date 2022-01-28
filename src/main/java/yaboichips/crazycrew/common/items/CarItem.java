package yaboichips.crazycrew.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import yaboichips.crazycrew.common.entites.TheWhip;
import yaboichips.crazycrew.core.CCEntities;

public class CarItem extends Item {
    public CarItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext result) {
        Player player = result.getPlayer();
        Level world = result.getLevel();
        BlockPos blockpos = result.getClickedPos();
        TheWhip theWhip = CCEntities.WHIP.create(world);
        theWhip.setPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
        theWhip.setOwnerUUID(player.getUUID());
        player.getItemInHand(result.getHand()).shrink(1);
        world.addFreshEntity(theWhip);
        return super.useOn(result);
    }
}
