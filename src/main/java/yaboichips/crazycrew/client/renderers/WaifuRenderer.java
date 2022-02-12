package yaboichips.crazycrew.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.client.models.WaifuModel;
import yaboichips.crazycrew.common.entites.Waifu;

public class WaifuRenderer<T extends Waifu> extends MobRenderer<T, WaifuModel<T>> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(CrazyCrew.MOD_ID, "textures/entity/waifu.png");

    public WaifuRenderer(EntityRendererProvider.Context context) {
        super(context, new WaifuModel<>(context.bakeLayer(WaifuModel.LAYER_LOCATION)), 0.35F);
        this.shadowRadius = 0.2F;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull T entity) {
        return TEXTURES;
    }
}
