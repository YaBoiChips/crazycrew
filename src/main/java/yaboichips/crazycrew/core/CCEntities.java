package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.entites.TheWhip;

import java.util.ArrayList;
import java.util.List;

public final class CCEntities {
    public static List<EntityType<?>> entities = new ArrayList<>();

    public static final EntityType<TheWhip> WHIP = createEntity("the_whip", EntityType.Builder.of(TheWhip::new, MobCategory.MISC).sized(1,1).build("the_whip"));

    @Contract("null, _ -> fail; _, null -> fail; !null, !null -> new")
    public static @NotNull <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        entityType.setRegistryName(new ResourceLocation(CrazyCrew.MOD_ID, id));
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
