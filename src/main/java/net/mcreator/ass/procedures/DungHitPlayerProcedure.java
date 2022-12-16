package net.mcreator.ass.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.ass.AssMod;

import java.util.Map;

public class DungHitPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AssMod.LOGGER.warn("Failed to load dependency entity for procedure DungHitPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("is_shitten", (true));
	}
}
