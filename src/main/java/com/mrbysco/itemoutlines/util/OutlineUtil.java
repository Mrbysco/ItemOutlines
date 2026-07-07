package com.mrbysco.itemoutlines.util;

import com.mrbysco.itemoutlines.config.ConfigHandler;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;

public class OutlineUtil {
	public static boolean shouldGlow(Entity entity) {
		if (entity instanceof ItemEntity itemEntity) {
			Identifier itemId = itemEntity.getItem().getItem()
					.builtInRegistryHolder().key().identifier();
			return ConfigHandler.ITEM_COLOR_MAP.containsKey(itemId);
		}
		return false;
	}

	public static Integer getColor(Entity entity) {
		if (entity instanceof ItemEntity itemEntity) {
			Identifier itemId = itemEntity.getItem().getItem()
					.builtInRegistryHolder().key().identifier();
			return ConfigHandler.ITEM_COLOR_MAP.get(itemId);
		}
		return null;
	}
}
