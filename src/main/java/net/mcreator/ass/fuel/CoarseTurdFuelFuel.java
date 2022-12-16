
package net.mcreator.ass.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.ass.item.CoarseDungItem;

@Mod.EventBusSubscriber
public class CoarseTurdFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CoarseDungItem.block)
			event.setBurnTime(600);
	}
}
