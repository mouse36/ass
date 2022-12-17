package net.mcreator.ass.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.ass.item.DiarrheaBucketItem;
import net.mcreator.ass.block.DiarrheaBlock;
import net.mcreator.ass.AssMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class DispenseDiarrheaBucketProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				AssMod.LOGGER.warn("Failed to load dependency direction for procedure DispenseDiarrheaBucket!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AssMod.LOGGER.warn("Failed to load dependency x for procedure DispenseDiarrheaBucket!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AssMod.LOGGER.warn("Failed to load dependency y for procedure DispenseDiarrheaBucket!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AssMod.LOGGER.warn("Failed to load dependency z for procedure DispenseDiarrheaBucket!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AssMod.LOGGER.warn("Failed to load dependency world for procedure DispenseDiarrheaBucket!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double index = 0;
		index = (double) 0;
		for (int index0 = 0; index0 < (int) (9); index0++) {
			if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (index))).getItem() == DiarrheaBucketItem.block)) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (index);
						final ItemStack _setstack = new ItemStack(Items.BUCKET);
						_setstack.setCount((int) 1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
			}
			index = (double) (index + 1);
		}
		if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("minecraft:air").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (x + (direction.getXOffset())), (int) (y + (direction.getYOffset())),
						(int) (z + (direction.getZOffset()))))).getBlock()))) {
			world.setBlockState(
					new BlockPos((int) (x + (direction.getXOffset())), (int) (y + (direction.getYOffset())), (int) (z + (direction.getZOffset()))),
					DiarrheaBlock.block.getDefaultState(), 3);
		}
	}
}
