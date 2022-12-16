
package net.mcreator.ass.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.ass.block.CoarsePoopBlock;

@Mod.EventBusSubscriber
public class CoarsePoopFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CoarsePoopBlock.block.asItem())
			event.setBurnTime(300);
	}
}
