package com.mrbysco.itemoutlines.config;

import java.util.Objects;

public final class ItemColor {
	private String color;
	private String[] items;

	public ItemColor(String color, String[] items) {
		this.color = color;
		this.items = items;
	}

	public String color() {
		return color;
	}

	public String[] items() {
		return items;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (ItemColor) obj;
		return Objects.equals(this.color, that.color) &&
				Objects.equals(this.items, that.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, items);
	}

	@Override
	public String toString() {
		return "ItemColor[" +
				"color=" + color + ", " +
				"items=" + items + ']';
	}

}
