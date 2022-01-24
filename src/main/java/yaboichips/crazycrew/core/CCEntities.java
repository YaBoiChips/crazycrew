package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import yaboichips.crazycrew.CrazyCrew;

import java.util.ArrayList;
import java.util.List;

public class CCEntities {
    public static List<EntityType<?>> entities = new ArrayList<>();



    public static <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        entityType.setRegistryName(new ResourceLocation(CrazyCrew.MOD_ID, id));
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }
}
