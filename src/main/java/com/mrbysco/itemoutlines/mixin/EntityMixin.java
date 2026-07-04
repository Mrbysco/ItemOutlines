package com.mrbysco.itemoutlines.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mrbysco.itemoutlines.util.OutlineUtil;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Entity.class)
public class EntityMixin {
	@WrapMethod(method = "getTeamColor()I")
	private int ItemOutlines$redirectTeamColor(Operation<Integer> original) {
		Entity entity = (Entity) (Object) this;
		Integer color = OutlineUtil.getColor(entity);
		if (color != null) {
			return color;
		}
		return original.call();
	}
}