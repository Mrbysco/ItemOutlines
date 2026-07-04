package com.mrbysco.itemoutlines;

import com.mojang.logging.LogUtils;
import com.mrbysco.itemoutlines.client.ClientHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ItemOutlinesMod.MOD_ID)
public class ItemOutlinesMod {
	public static final String MOD_ID = "itemoutlines";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ItemOutlinesMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::onClientSetup);
		});
	}
}
