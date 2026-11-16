package trc.ubchest.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.ai.behavior.TransportItemsBetweenContainers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

import trc.ubchest.GolemContext;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

@Mixin(TransportItemsBetweenContainers.TransportItemTarget.class)
public class TransportItemTargetMixin {
	@WrapOperation(
			method = "getBlockEntityContainer",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/ChestBlock;getContainer(Lnet/minecraft/world/level/block/ChestBlock;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Z)Lnet/minecraft/world/Container;"))
	private static Container ubchest$markGolemCheck(ChestBlock block, BlockState state, Level level, BlockPos pos, boolean ignoreBeingBlocked, Operation<Container> original) {
		return GolemContext.run(() -> original.call(block, state, level, pos, ignoreBeingBlocked));
	}
}