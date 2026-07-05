package com.mrbysco.itemoutlines;

import com.mojang.logging.LogUtils;
import com.mrbysco.itemoutlines.client.ClientHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ItemOutlinesMod.MOD_ID)
public class ItemOutlinesMod {
	public static final String MOD_ID = "itemoutlines";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ItemOutlinesMod(IEventBus eventBus, Dist dist) {
		if (dist.isClient()) {
			eventBus.addListener(ClientHandler::onClientSetup);
		}
	}
}
