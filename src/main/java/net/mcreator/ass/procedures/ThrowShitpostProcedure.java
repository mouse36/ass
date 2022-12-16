package net.mcreator.ass.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.ass.AssMod;

import java.util.Map;

public class ThrowShitpostProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AssMod.LOGGER.warn("Failed to load dependency entity for procedure ThrowShitpost!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AssMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThrowShitpost!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.getPersistentData().putString("owner", ((itemstack).getOrCreateTag().getString("owner")));
		entity.getPersistentData().putString("shitpost1", ((itemstack).getOrCreateTag().getString("shitpost1")));
		entity.getPersistentData().putString("shitpost2", ((itemstack).getOrCreateTag().getString("shitpost2")));
		entity.getPersistentData().putString("shitpost3", ((itemstack).getOrCreateTag().getString("shitpost3")));
		entity.getPersistentData().putString("shitpost4", ((itemstack).getOrCreateTag().getString("shitpost4")));
		entity.getPersistentData().putString("shitpost5", ((itemstack).getOrCreateTag().getString("shitpost5")));
		entity.getPersistentData().putString("shitpost6", ((itemstack).getOrCreateTag().getString("shitpost6")));
	}
}
