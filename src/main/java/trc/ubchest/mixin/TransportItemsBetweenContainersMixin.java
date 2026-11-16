package trc.ubchest.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.behavior.TransportItemsBetweenContainers;
import net.minecraft.world.level.LevelAccessor;

import trc.ubchest.GolemContext;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

@Mixin(TransportItemsBetweenContainers.class)
public class TransportItemsBetweenContainersMixin {
	@WrapOperation(
			method = "isTargetBlocked",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/ChestBlock;isChestBlockedAt(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;)Z"))
	private boolean ubchest$markGolemCheck(LevelAccessor level, BlockPos pos, Operation<Boolean> original) {
		return GolemContext.run(() -> original.call(level, pos));
	}
}