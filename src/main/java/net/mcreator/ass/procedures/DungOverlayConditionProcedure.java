package net.mcreator.ass.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.ass.AssMod;

import java.util.Map;

public class DungOverlayConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AssMod.LOGGER.warn("Failed to load dependency entity for procedure DungOverlayCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getPersistentData().getBoolean("is_shitten"))) {
			return (true);
		}
		return (false);
	}
}
