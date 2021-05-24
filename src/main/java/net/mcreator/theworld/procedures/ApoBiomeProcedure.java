package net.mcreator.theworld.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theworld.TheWorldModVariables;
import net.mcreator.theworld.TheWorldModElements;
import net.mcreator.theworld.TheWorldMod;

import java.util.Map;
import java.util.HashMap;

@TheWorldModElements.ModElement.Tag
public class ApoBiomeProcedure extends TheWorldModElements.ModElement {
	public ApoBiomeProcedure(TheWorldModElements instance) {
		super(instance, 89);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheWorldMod.LOGGER.warn("Failed to load dependency entity for procedure ApoBiome!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheWorldMod.LOGGER.warn("Failed to load dependency x for procedure ApoBiome!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheWorldMod.LOGGER.warn("Failed to load dependency y for procedure ApoBiome!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheWorldMod.LOGGER.warn("Failed to load dependency z for procedure ApoBiome!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheWorldMod.LOGGER.warn("Failed to load dependency world for procedure ApoBiome!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double TickNb = 0;
		if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("the_world:crash_biome_apo")))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 1);
		}
		if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("the_world:crash_biome_apo")))) {
			TickNb = (double) 0;
			TickNb = (double) ((TickNb) + 1);
			TheWorldModVariables.WorldVariables.get(world).ToxicityLVL = (double) (TickNb);
			TheWorldModVariables.WorldVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
