package yaboichips.crazycrew.common.entites.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.entites.Chadwick;
import yaboichips.crazycrew.common.entites.models.ChadwickModel;

public class ChadwickRenderer<T extends Chadwick> extends MobRenderer<T, ChadwickModel<T>> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(CrazyCrew.MOD_ID, "textures/entity/chadwick.png");


    public ChadwickRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChadwickModel<>(renderManager.bakeLayer(ChadwickModel.LAYER_LOCATION)), 0.35F);
        this.shadowRadius = 0.2F;

    }

    @Override
    public ResourceLocation getTextureLocation(T instance) {
        return TEXTURES;
    }
}
