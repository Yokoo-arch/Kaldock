package net.mcreator.theworld.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theworld.TheWorldModElements;
import net.mcreator.theworld.TheWorldMod;

import java.util.Map;

@TheWorldModElements.ModElement.Tag
public class ToxicFluidLorsqueLeMobjoueurEntreEnCollisionAvecLeBlocProcedure extends TheWorldModElements.ModElement {
	public ToxicFluidLorsqueLeMobjoueurEntreEnCollisionAvecLeBlocProcedure(TheWorldModElements instance) {
		super(instance, 87);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheWorldMod.LOGGER.warn("Failed to load dependency entity for procedure ToxicFluidLorsqueLeMobjoueurEntreEnCollisionAvecLeBloc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 60, (int) 1, (false), (false)));
	}
}
