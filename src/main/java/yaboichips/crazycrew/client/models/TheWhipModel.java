package yaboichips.crazycrew.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import yaboichips.crazycrew.CrazyCrew;
import yaboichips.crazycrew.common.entites.TheWhip;

public class TheWhipModel<T extends TheWhip> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CrazyCrew.MOD_ID, "the_whip"), "main");
    private final ModelPart Body;
    private final ModelPart Wheels;

    public TheWhipModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Wheels = root.getChild("Wheels");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -6.0F, -33.0F, 28.0F, 1.0F, 42.0F, new CubeDeformation(0.0F))
                .texOffs(44, 70).addBox(7.0F, -23.0F, -33.0F, 1.0F, 17.0F, 42.0F, new CubeDeformation(0.0F))
                .texOffs(0, 53).addBox(-20.0F, -23.0F, -33.0F, 1.0F, 17.0F, 42.0F, new CubeDeformation(0.0F))
                .texOffs(0, 129).addBox(-19.0F, -23.0F, -33.0F, 26.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(127, 0).addBox(-19.0F, -23.0F, 8.0F, 26.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 81).addBox(-19.0F, -23.0F, -32.0F, 26.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(62, 61).addBox(6.0F, -44.0F, -20.0F, 2.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 61).addBox(-20.0F, -44.0F, 8.0F, 2.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 61).addBox(6.0F, -44.0F, 8.0F, 2.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(56, 61).addBox(-20.0F, -44.0F, -20.0F, 2.0F, 21.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 57).addBox(-18.0F, -44.0F, -20.0F, 24.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(44, 53).addBox(-18.0F, -44.0F, 8.0F, 24.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 102).addBox(7.0F, -44.0F, -19.0F, 1.0F, 2.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(98, 0).addBox(-20.0F, -44.0F, -19.0F, 1.0F, 2.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(88, 53).addBox(-19.0F, -44.0F, -19.0F, 26.0F, 1.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(0, 43).addBox(-38.0F, -51.0F, 14.0F, 66.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -44.0F, 14.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -44.0F, 14.0F, 1.0036F, 0.0F, 0.0F));

        PartDefinition Wheels = partdefinition.addOrReplaceChild("Wheels", CubeListBuilder.create().texOffs(20, 53).addBox(4.0F, -6.0F, 2.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 53).addBox(4.0F, -6.0F, -25.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(20, 18).addBox(-20.0F, -6.0F, -25.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(-20.0F, -6.0F, 2.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(poseStack, buffer, packedLight, packedOverlay);
        Wheels.render(poseStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root();
    }
}