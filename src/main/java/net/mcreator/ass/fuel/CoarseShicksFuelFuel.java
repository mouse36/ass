
package net.mcreator.ass.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.ass.block.CoarseShicksBlock;

@Mod.EventBusSubscriber
public class CoarseShicksFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CoarseShicksBlock.block.asItem())
			event.setBurnTime(1200);
	}
}
