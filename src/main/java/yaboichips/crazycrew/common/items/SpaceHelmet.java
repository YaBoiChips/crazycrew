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


    public SpaceHelmet(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }
}

