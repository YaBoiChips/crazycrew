package yaboichips.crazycrew.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.entites.*;

import java.util.ArrayList;
import java.util.List;

public final class CCEntities {
    public static List<EntityType<?>> entities = new ArrayList<>();

    public static final EntityType<TheWhip> WHIP = createEntity("the_whip", EntityType.Builder.of(TheWhip::new, MobCategory.MISC).sized(1, 1.5F).build("the_whip"));
    public static final EntityType<ThrowingKnifeEntity> THROWING_KNIFE = createEntity("throwing_knife", EntityType.Builder.<ThrowingKnifeEntity>of(ThrowingKnifeEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).setTrackingRange(4).updateInterval(20).build("throwing_knife"));
    public static final EntityType<Waifu> WAIFU = createEntity("waifu", EntityType.Builder.of(Waifu::new, MobCategory.MISC).sized(2, 1F).build("waifu"));
    public static final EntityType<PieEntity> PIE = createEntity("pie", EntityType.Builder.of(PieEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build("pie"));
    public static final EntityType<Chadwick> CHADWICK = createEntity("chadwick", EntityType.Builder.of(Chadwick::new, MobCategory.MISC).sized(2, 1F).build("chadwick"));
    public static final EntityType<BulletEntity> BULLET = createEntity("bullet", EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC).sized(0.2F, 0.2F).setTrackingRange(4).updateInterval(20).build("bullet"));

    @Contract("null, _ -> fail; _, null -> fail; !null, !null -> new")
    public static @NotNull <E extends Entity, ET extends EntityType<E>> ET createEntity(String id, ET entityType) {
        entityType.setRegistryName(new ResourceLocation(CrazyCrew.MOD_ID, id));
        entities.add(entityType);
        return entityType;
    }

    public static void init() {
    }


}
