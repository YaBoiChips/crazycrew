package yaboichips.crazycrew.client.models;// Made with Blockbench 4.1.4
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import yaboichips.crazycrew.CrazyCrew;

public class ChadwickModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CrazyCrew.MOD_ID, "chadwick"), "main");
	private final ModelPart frontRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart backRightLeg;
	private final ModelPart backLeftLeg;
	private final ModelPart body;
	private final ModelPart head;

	public ChadwickModel(ModelPart root) {
		this.frontRightLeg = root.getChild("frontRightLeg");
		this.frontLeftLeg = root.getChild("frontLeftLeg");
		this.backRightLeg = root.getChild("backRightLeg");
		this.backLeftLeg = root.getChild("backLeftLeg");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frontRightLeg = partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(43, 10).addBox(-1.0F, 4.3333F, -1.3333F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 37).addBox(-1.0F, 7.3333F, -2.3333F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(20, 35).addBox(-1.0F, -1.6667F, -1.8333F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 15.6667F, -4.6667F));

		PartDefinition frontLeftLeg = partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(42, 42).addBox(-1.0F, 4.3333F, -1.3333F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 30).addBox(-1.0F, 7.3333F, -2.3333F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(35, 0).addBox(-1.0F, -1.6667F, -1.8333F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 15.6667F, -4.6667F));

		PartDefinition backRightLeg = partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(8, 42).addBox(-1.0F, 4.3333F, -1.3333F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 37).addBox(-1.0F, 7.3333F, -2.3333F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 31).addBox(-1.0F, -1.6667F, -1.8333F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 15.6667F, 5.3333F));

		PartDefinition backLeftLeg = partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(32, 41).addBox(-1.0F, 4.3333F, -1.3333F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(36, 25).addBox(-1.0F, 7.3333F, -2.3333F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 25).addBox(-1.0F, -1.6667F, -1.8333F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 15.6667F, 5.3333F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -13.0F, -8.0F, 8.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 45).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, 16.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.0F, 0.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -15.0F, 10.5F, -1.0472F, 0.0F, 0.0F));

		PartDefinition neck_r1 = body.addOrReplaceChild("neck_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -0.5F, 0.5F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.5F, -9.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(-2.817F, -5.433F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 25).mirror().addBox(-1.817F, -2.433F, -4.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.183F, 8.433F, -8.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(35, 10).mirror().addBox(0.183F, -3.933F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -7.5F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-2.0F, -2.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.817F, -8.933F, 0.0F, 0.0F, 0.0F, -0.5672F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.backLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.frontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		frontRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		frontLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		backRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		backLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
}