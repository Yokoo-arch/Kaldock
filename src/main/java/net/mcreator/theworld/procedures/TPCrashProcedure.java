package net.mcreator.theworld.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theworld.world.dimension.CrashDimensionDimension;
import net.mcreator.theworld.TheWorldModElements;
import net.mcreator.theworld.TheWorldMod;

import java.util.Map;

@TheWorldModElements.ModElement.Tag
public class TPCrashProcedure extends TheWorldModElements.ModElement {
	public TPCrashProcedure(TheWorldModElements instance) {
		super(instance, 88);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheWorldMod.LOGGER.warn("Failed to load dependency entity for procedure TPCrash!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
				DimensionType destinationType = CrashDimensionDimension.type;
				ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
				if (nextWorld != null) {
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
		}
	}
}
