package net.mcreator.ass.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.ass.block.TurdBlock;
import net.mcreator.ass.block.SmoothTurdBlock;
import net.mcreator.ass.block.SmoothShitBlock;
import net.mcreator.ass.block.SmoothShicksBlock;
import net.mcreator.ass.block.SmoothPoopBlock;
import net.mcreator.ass.block.ShitBlock;
import net.mcreator.ass.block.ShicksBlock;
import net.mcreator.ass.block.PoopBlock;
import net.mcreator.ass.block.DiarrheaBlock;
import net.mcreator.ass.block.CoarseTurdBlock;
import net.mcreator.ass.block.CoarseShitBlock;
import net.mcreator.ass.block.CoarseShicksBlock;
import net.mcreator.ass.block.CoarsePoopBlock;
import net.mcreator.ass.AssMod;

import java.util.Map;

public class ShitWettingProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AssMod.LOGGER.warn("Failed to load dependency x for procedure ShitWetting!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AssMod.LOGGER.warn("Failed to load dependency y for procedure ShitWetting!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AssMod.LOGGER.warn("Failed to load dependency z for procedure ShitWetting!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AssMod.LOGGER.warn("Failed to load dependency world for procedure ShitWetting!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((BlockTags.getCollection().getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))
				|| ((BlockTags.getCollection().getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))
						|| (BlockTags.getCollection().getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))))
				|| ((BlockTags.getCollection().getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))
						|| ((BlockTags.getCollection().getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))
								|| (BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("ass:dilutes_shit").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock())))))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ShitBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SmoothShitBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CoarseShitBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShitBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmoothShitBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DiarrheaBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ShicksBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SmoothShicksBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CoarseShicksBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShicksBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmoothShicksBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DiarrheaBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == TurdBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SmoothTurdBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CoarseTurdBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), TurdBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmoothTurdBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DiarrheaBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PoopBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SmoothPoopBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CoarsePoopBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PoopBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SmoothPoopBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DiarrheaBlock.block.getDefaultState(), 3);
			}
		}
	}
}
