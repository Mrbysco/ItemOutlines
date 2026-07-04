package com.mrbysco.itemoutlines.client;

import com.mrbysco.itemoutlines.config.ConfigHandler;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
	public static void onClientSetup(final FMLClientSetupEvent event) {
		ConfigHandler.initializeConfig();
	}
}
