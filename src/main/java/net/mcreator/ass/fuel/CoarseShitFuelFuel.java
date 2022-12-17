
package net.mcreator.ass.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.ass.block.CoarseShitBlock;

@Mod.EventBusSubscriber
public class CoarseShitFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CoarseShitBlock.block.asItem())
			event.setBurnTime(1000);
	}
}
