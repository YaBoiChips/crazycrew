package yaboichips.crazycrew.common.entites.renderers;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.entites.TheWhip;
import yaboichips.crazycrew.common.entites.models.TheWhipModel;

public class TheWhipRenderer<T extends TheWhip> extends MobRenderer<T, TheWhipModel<T>> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(CrazyCrew.MOD_ID, "textures/entity/the_whip.png");
    public static final ModelLayerLocation THE_WHIP = new ModelLayerLocation(new ResourceLocation(CrazyCrew.MOD_ID, "the_whip"), "main");


    public TheWhipRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TheWhipModel<>(renderManager.bakeLayer(THE_WHIP)), 0.35F);
        this.shadowRadius = 0.2F;

    }

    @Override
    public ResourceLocation getTextureLocation(T instance) {
        return TEXTURES;
    }
}
