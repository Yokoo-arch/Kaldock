// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelBeeV2 extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer stinger;
	private final ModelRenderer rightwing_bone;
	private final ModelRenderer leftwing_bone;
	private final ModelRenderer leg_front;
	private final ModelRenderer leg_mid;
	private final ModelRenderer leg_back;

	public ModelBeeV2() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.5F, 19.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 7.0F, 10.0F, 0.0F, true);
		body.setTextureOffset(2, 3).addBox(-2.5F, -4.0F, -8.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(2, 0).addBox(1.5F, -4.0F, -8.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		stinger = new ModelRenderer(this);
		stinger.setRotationPoint(0.0F, -1.0F, 1.0F);
		body.addChild(stinger);
		stinger.setTextureOffset(26, 7).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		rightwing_bone = new ModelRenderer(this);
		rightwing_bone.setRotationPoint(-1.5F, -4.0F, -3.0F);
		body.addChild(rightwing_bone);
		setRotationAngle(rightwing_bone, 0.2618F, -0.2618F, 0.0F);
		rightwing_bone.setTextureOffset(0, 18).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);

		leftwing_bone = new ModelRenderer(this);
		leftwing_bone.setRotationPoint(1.5F, -4.0F, -3.0F);
		body.addChild(leftwing_bone);
		setRotationAngle(leftwing_bone, 0.2618F, 0.2618F, 0.0F);
		leftwing_bone.setTextureOffset(9, 24).addBox(0.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, 0.0F, false);

		leg_front = new ModelRenderer(this);
		leg_front.setRotationPoint(1.5F, 3.0F, -2.0F);
		body.addChild(leg_front);
		leg_front.setTextureOffset(26, 1).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);

		leg_mid = new ModelRenderer(this);
		leg_mid.setRotationPoint(1.5F, 3.0F, 0.0F);
		body.addChild(leg_mid);
		leg_mid.setTextureOffset(26, 3).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);

		leg_back = new ModelRenderer(this);
		leg_back.setRotationPoint(1.5F, 3.0F, 2.0F);
		body.addChild(leg_back);
		leg_back.setTextureOffset(26, 5).addBox(-5.0F, 0.0F, 0.0F, 7.0F, 2.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}