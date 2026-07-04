[![build](https://github.com/Mrbysco/ItemOutlines/actions/workflows/build.yml/badge.svg)](https://github.com/Mrbysco/ItemOutlines/actions/workflows/build.yml) 
[![](http://cf.way2muchnoise.eu/versions/1598266.svg)](https://www.curseforge.com/minecraft/mc-mods/item-outlines)

# Item Outlines #

## About ##
Item Outlines allows you to configure items that glow when dropped. You can setup jsons per color with a list of items that will glow a certain color when dropped.

By default, the mod will make Nether Star glow when dropped.

## Configuration ##
Configuration files are located in `config/itemoutlines/` and use JSON format.

Example configuration file (e.g., `green.json`):
```json
{
  "color": "#00ff08",
  "items": [
    "minecraft:emerald"
  ]
}
```

- **color**: Hex color code (with or without `#`) for the outline glow
- **items**: Array of item ids that should glow with this color

## License ##
* Item Outlines is licensed under the MIT License
  - (c) 2025 Mrbysco
  - [![License](https://img.shields.io/badge/License-MIT-red.svg?style=flat)](http://opensource.org/licenses/MIT)

## Downloads ##
Downloads will be located on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/item-outlines)
