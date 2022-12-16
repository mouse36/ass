package net.mcreator.ass.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.ass.gui.ShitpostReadingGUIGui;
import net.mcreator.ass.AssMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class ShitpostHitPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AssMod.LOGGER.warn("Failed to load dependency entity for procedure ShitpostHitPlayer!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				AssMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShitpostHitPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				AssMod.LOGGER.warn("Failed to load dependency x for procedure ShitpostHitPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				AssMod.LOGGER.warn("Failed to load dependency y for procedure ShitpostHitPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				AssMod.LOGGER.warn("Failed to load dependency z for procedure ShitpostHitPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				AssMod.LOGGER.warn("Failed to load dependency world for procedure ShitpostHitPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putString("owner", (sourceentity.getPersistentData().getString("owner")));
		entity.getPersistentData().putString("shitpost1", (sourceentity.getPersistentData().getString("shitpost1")));
		entity.getPersistentData().putString("shitpost2", (sourceentity.getPersistentData().getString("shitpost2")));
		entity.getPersistentData().putString("shitpost3", (sourceentity.getPersistentData().getString("shitpost3")));
		entity.getPersistentData().putString("shitpost4", (sourceentity.getPersistentData().getString("shitpost4")));
		entity.getPersistentData().putString("shitpost5", (sourceentity.getPersistentData().getString("shitpost5")));
		entity.getPersistentData().putString("shitpost6", (sourceentity.getPersistentData().getString("shitpost6")));
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("ShitpostReadingGUI");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new ShitpostReadingGUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		entity.getPersistentData().putBoolean("isShitten", (true));
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent((((((entity.getDisplayName().getString())) + "" + (" just got absolutely bamboozled by ")))
										+ "" + ((((sourceentity.getPersistentData().getString("owner"))) + "" + ("."))))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
