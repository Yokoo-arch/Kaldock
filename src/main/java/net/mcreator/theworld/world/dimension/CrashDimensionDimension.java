
package net.mcreator.theworld.world.dimension;

import net.minecraft.block.material.Material;

@TheWorldModElements.ModElement.Tag
public class CrashDimensionDimension extends TheWorldModElements.ModElement {

	@ObjectHolder("the_world:crash_dimension")
	public static final ModDimension dimension = null;

	public static DimensionType type = null;

	private static Biome[] dimensionBiomes;

	public CrashDimensionDimension(TheWorldModElements instance) {
		super(instance, 87);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("crash_dimension"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("the_world:crash_dimension")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("the_world:crash_dimension"), dimension, null, true);
		}

		type = DimensionType.byName(new ResourceLocation("the_world:crash_dimension"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{};
	}

	public static class CustomModDimension extends ModDimension {

		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return CustomDimension::new;
		}

	}

	public static class CustomDimension extends Dimension {

		private BiomeProviderCustom biomeProviderCustom = null;

		public CustomDimension(World world, DimensionType type) {
			super(world, type, 0.5f);
			this.nether = false;
		}


		@Override @OnlyIn(Dist.CLIENT) public Vec3d getFogColor(float celestialAngle, float partialTicks) {
			return new Vec3d(0.337254901961,0.345098039216,0.23137254902);
		}

		@Override public ChunkGenerator<?> createChunkGenerator() {
			if(this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override public boolean isSurfaceWorld() {
			return true;
		}

		@Override public boolean canRespawnHere() {
			return true;
		}

		@OnlyIn(Dist.CLIENT) @Override public boolean doesXZShowFog(int x, int z) {
			return false;
		}

		@Override public SleepResult canSleepAt(PlayerEntity player, BlockPos pos){
        	return SleepResult.ALLOW;
		}

		@Nullable public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
   		   return null;
   		}

   		@Nullable public BlockPos findSpawn(int x, int z, boolean checkValid) {
   		   return null;
   		}

		@Override public boolean doesWaterVaporize() {
      		return false;
   		}

		@Override /* failed to load code for net.minecraft.world.dimension.OverworldDimension */

	}

	public static class ChunkProviderModded extends OverworldChunkGenerator {

		public ChunkProviderModded(IWorld world, BiomeProvider provider) {
			super(world, provider, new OverworldGenSettings() {
				public BlockState getDefaultBlock() {
					return Blocks.STONE.getDefaultState();
				}

				public BlockState getDefaultFluid() {
					return ToxicFluidItem.block.getDefaultState();
				}
			});
			this.randomSeed.skip(5349);
		}

		@Override
		public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
		}

	}

	public static class BiomeLayerCustom implements IC0Transformer {

		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}

	}

	public static class BiomeProviderCustom extends BiomeProvider {

		private Layer genBiomes;

		private static boolean biomesPatched = false;

		public BiomeProviderCustom(World world) {
			super(new HashSet<Biome>(Arrays.asList(dimensionBiomes)));

			this.genBiomes = getBiomeLayer(world.getSeed());

			if (!biomesPatched) {
				for (Biome biome : this.biomes) {
					biome.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new CaveWorldCarver(ProbabilityConfig::deserialize, 256) {
						{
							carvableBlocks = ImmutableSet.of(Blocks.STONE.getDefaultState().getBlock(),
									biome.getSurfaceBuilder().getConfig().getTop().getBlock(),
									biome.getSurfaceBuilder().getConfig().getUnder().getBlock());
						}
					}, new ProbabilityConfig(0.14285715f)));
				}
				biomesPatched = true;
			}
		}

		public Biome getNoiseBiome(int x, int y, int z) {
			return this.genBiomes.func_215738_a(x, z);
		}

		private Layer getBiomeLayer(long seed) {
			LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);

			IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
			IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);

			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);

			return new Layer(biomeLayer);
		}

	}

}
