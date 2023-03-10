package net.mcreator.ass.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.ass.item.ShartShardItem;
import net.mcreator.ass.AssMod;

import java.util.Map;

public class ExplosiveDiarrheaLuckyBlockUltraCoolProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AssMod.LOGGER.warn("Failed to load dependency entity for procedure ExplosiveDiarrheaLuckyBlockUltraCool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AssMod.LOGGER.warn("Failed to load dependency x for procedure ExplosiveDiarrheaLuckyBlockUltraCool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AssMod.LOGGER.warn("Failed to load dependency y for procedure ExplosiveDiarrheaLuckyBlockUltraCool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AssMod.LOGGER.warn("Failed to load dependency z for procedure ExplosiveDiarrheaLuckyBlockUltraCool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AssMod.LOGGER.warn("Failed to load dependency world for procedure ExplosiveDiarrheaLuckyBlockUltraCool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(entity instanceof ItemEntity))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 5, Explosion.Mode.BREAK);
			}
			for (int index0 = 0; index0 < (int) (4); index0++) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, ((x + 0.5) + ((Math.random() - 0.5) * 5)), y,
							((z + 0.5) + ((Math.random() - 0.5) * 5)), new ItemStack(ShartShardItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
