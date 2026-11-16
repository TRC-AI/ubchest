package trc.ubchest;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class GolemContext {
    private static final ThreadLocal<int[]> DEPTH = ThreadLocal.withInitial(() -> new int[1]);

    private GolemContext() {}

    public static <T> T run(@NotNull Supplier<T> check) {
        int[] depth = DEPTH.get();
        depth[0]++;
        try {
            return check.get();
        } finally {
            depth[0]--;
        }
    }

    public static boolean notUseVanillaRules() { return DEPTH.get()[0] <= 0 || TRCAddon.APPLY_TO_COPPER_GOLEMS.value; }
}