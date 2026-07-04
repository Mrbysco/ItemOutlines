package com.mrbysco.itemoutlines.mixin;

import com.mrbysco.itemoutlines.util.OutlineUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	@Inject(method = "shouldEntityAppearGlowing(Lnet/minecraft/world/entity/Entity;)Z",
			at = @At("HEAD"), cancellable = true)
	public void ItemOutlines$shouldEntityAppearGlowing(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (OutlineUtil.shouldGlow(entity)) {
			cir.setReturnValue(true);
		}
	}
}
