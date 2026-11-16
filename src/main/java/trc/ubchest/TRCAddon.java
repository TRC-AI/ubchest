package trc.ubchest;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import org.jetbrains.annotations.NotNull;
import trc.core.ITRCAddon;
import trc.core.settings.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TRCAddon implements ITRCAddon, ISettingsHolder {
    public static final String MOD_ID = "ubchest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final BoolSetting IGNORE_BLOCK_ABOVE =
            new BoolSetting("ignore_block_above", Component.translatable("ubchest.setting.ignore_block_above"), false, "Open chests through solid blocks");

    public static final BoolSetting IGNORE_SITTING_CATS =
            new BoolSetting("ignore_sitting_cats", Component.translatable("ubchest.setting.ignore_sitting_cats"), true, "Open chests under sitting cats");

    public static final BoolSetting APPLY_TO_COPPER_GOLEMS =
            new BoolSetting("apply_to_copper_golems", Component.translatable("ubchest.setting.apply_to_copper_golems"), true, "Apply to copper golems");

    static final List<Setting> settings = new ArrayList<>();

    @Override
    public void init() {
        settings.add(IGNORE_BLOCK_ABOVE);
        settings.add(IGNORE_SITTING_CATS);
        settings.add(APPLY_TO_COPPER_GOLEMS);

        SettingsManager.getSettingsManager().register(this);
    }

    @Override
    public void start() {
    }

    @Override
    public String getModId() { return MOD_ID; }

    // Internal function for TRC-Core to collect all settings. Do not touch.
    @Override
    public List<Setting> getSettings() { return settings; }

    @Override
    public void onSettingsChanged() {}

    public static @NotNull Identifier id(String path) { return Identifier.fromNamespaceAndPath(MOD_ID, path); }
}