package yaboichips.crazycrew.common.events;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import yaboichips.crazycrew.core.CCItems;
import yaboichips.crazycrew.core.CCSounds;

public class SaberSoundEvent extends AbstractTickableSoundInstance {
    private final Player player;


    public SaberSoundEvent(Player player) {
        super(CCSounds.BUZZ, SoundSource.NEUTRAL);
        this.player = player;
        this.looping = true;
        this.volume = 0.05F;

    }

    @Override
    public void tick() {
        Item item = this.player.getMainHandItem().getItem();
        if (item != CCItems.SABER) {
            this.stop();
        }
    }
}
