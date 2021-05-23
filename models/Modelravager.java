// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelravager extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer horns;
	private final ModelRenderer horns_r1;
	private final ModelRenderer horns_r2;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;

	public Modelravager() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 55).addBox(-11.0F, -7.0F, -4.0F, 22.0F, 16.0F, 20.0F, 0.0F, false);
		body.setTextureOffset(0, 91).addBox(-10.0F, 9.0F, -4.0F, 20.0F, 13.0F, 18.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-2.0F, 21.0F, -17.0F, 3.0F, 1.0F, 32.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-3.0F, 21.0F, 9.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 4.0F, -20.0F);
		neck.setTextureOffset(68, 73).addBox(-5.0F, -11.0F, 10.0F, 10.0F, 10.0F, 18.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -8.0F, 10.0F);
		neck.addChild(head);
		head.setTextureOffset(0, 16).addBox(-12.0F, -6.0F, -14.0F, 24.0F, 20.0F, 16.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-5.0F, 9.0F, -18.0F, 10.0F, 8.0F, 4.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 13.0F, 0.0F);
		head.addChild(mouth);
		mouth.setTextureOffset(0, 36).addBox(-12.0F, 1.0F, -14.0F, 24.0F, 1.0F, 16.0F, 0.0F, false);

		horns = new ModelRenderer(this);
		horns.setRotationPoint(-5.0F, 1.0F, -9.0F);
		head.addChild(horns);
		setRotationAngle(horns, 1.0472F, 0.0F, 0.0F);

		horns_r1 = new ModelRenderer(this);
		horns_r1.setRotationPoint(5.0F, 27.0F, 19.0F);
		horns.addChild(horns_r1);
		setRotationAngle(horns_r1, -0.3927F, 0.0F, 1.5708F);
		horns_r1.setTextureOffset(74, 55).addBox(-32.0F, -18.0F, -22.0F, 3.0F, 14.0F, 4.0F, 0.0F, false);

		horns_r2 = new ModelRenderer(this);
		horns_r2.setRotationPoint(5.0F, 27.0F, 19.0F);
		horns.addChild(horns_r2);
		setRotationAngle(horns_r2, -0.3927F, 0.0F, -1.5708F);
		horns_r2.setTextureOffset(74, 55).addBox(26.0F, -18.0F, -22.0F, 3.0F, 14.0F, 4.0F, 0.0F, false);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-12.0F, -6.0F, 22.0F);
		leg0.setTextureOffset(96, 0).addBox(-4.0F, -11.0F, -5.0F, 8.0F, 41.0F, 8.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, -6.0F, 22.0F);
		leg1.setTextureOffset(96, 0).addBox(4.0F, -11.0F, -5.0F, 8.0F, 41.0F, 8.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, -2.0F, -4.0F);
		leg2.setTextureOffset(0, 0).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 41.0F, 8.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-4.0F, -2.0F, -4.0F);
		leg3.setTextureOffset(64, 0).addBox(12.0F, -15.0F, -4.0F, 8.0F, 41.0F, 8.0F, 0.0F, false);
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
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}