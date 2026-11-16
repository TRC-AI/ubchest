package trc.ubchest.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.ChestBlock;

import trc.ubchest.GolemContext;
import trc.ubchest.TRCAddon;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBlock.class)
public class ChestBlockMixin {
	@Inject(at = @At("HEAD"), method = "isBlockedChestByBlock", cancellable = true)
	private static void ubchest$ignoreBlockAbove(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (TRCAddon.IGNORE_BLOCK_ABOVE.value && GolemContext.notUseVanillaRules()) {
			cir.setReturnValue(false);
		}
	}

	@Inject(at = @At("HEAD"), method = "isCatSittingOnChest", cancellable = true)
	private static void ubchest$ignoreSittingCats(LevelAccessor level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (TRCAddon.IGNORE_SITTING_CATS.value && GolemContext.notUseVanillaRules()) {
			cir.setReturnValue(false);
		}
	}
}