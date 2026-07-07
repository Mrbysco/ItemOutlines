package com.mrbysco.itemoutlines.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrbysco.itemoutlines.ItemOutlinesMod;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigHandler {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	public static final File JSON_DIR = new File(FMLPaths.CONFIGDIR.get().toFile() + "/itemoutlines");

	public static final Map<Identifier, Integer> ITEM_COLOR_MAP = new HashMap<>();

	private static void createDefaultConfig() {
		ItemColor defaultColor = new ItemColor("#d8e0d4", new String[]{"minecraft:nether_star"});
		File defaultFile = new File(JSON_DIR, "default.json");
		try (FileWriter writer = new FileWriter(defaultFile)) {
			GSON.toJson(defaultColor, writer);
			writer.flush();
		} catch (IOException e) {
			ItemOutlinesMod.LOGGER.error("Failed to create default config file.");
			e.printStackTrace();
		}
	}

	public static void initializeConfig() {
		ITEM_COLOR_MAP.clear();

		if (!JSON_DIR.exists()) {
			if (JSON_DIR.mkdirs()) {
				createDefaultConfig();
			}
		}

		File[] files = JSON_DIR.listFiles();
		if (files == null) return;

		for (File file : files) {
			String fileName = file.getName();
			if (!fileName.endsWith(".json")) {
				ItemOutlinesMod.LOGGER.error("Found invalid file {} in item outlines config folder. It must be a .json file!", fileName);
				continue;
			}
			try (FileReader reader = new FileReader(file)) {
				ItemColor itemColor = GSON.fromJson(reader, ItemColor.class);
				if (itemColor == null) {
					ItemOutlinesMod.LOGGER.error("Could not load item color from {}.", fileName);
					continue;
				}
				int color = parseColor(itemColor.color());
				if (itemColor.items() != null) {
					for (String item : itemColor.items()) {
						Identifier location = Identifier.tryParse(item);
						if (location == null) {
							ItemOutlinesMod.LOGGER.error("Invalid item location '{}' in {}.", item, fileName);
						} else if (ITEM_COLOR_MAP.containsKey(location)) {
							ItemOutlinesMod.LOGGER.warn("Duplicate item '{}' found in {}. Ignoring.", item, fileName);
						} else {
							ITEM_COLOR_MAP.put(location, color);
						}
					}
				}
			} catch (IOException e) {
				ItemOutlinesMod.LOGGER.error("Unable to load file {}. Please make sure it's a valid json.", fileName);
				e.printStackTrace();
			}
		}
	}

	private static int parseColor(String hex) {
		if (hex == null) return 0xFFFFFF;
		String clean = hex.startsWith("#") ? hex.substring(1) : hex;
		try {
			return (int) Long.parseLong(clean, 16);
		} catch (NumberFormatException e) {
			ItemOutlinesMod.LOGGER.error("Invalid color value '{}', defaulting to white.", hex);
			return 0xFFFFFF;
		}
	}

}
