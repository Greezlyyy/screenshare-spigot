package me.wiceh.screensharespigot.objects;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.wiceh.screensharespigot.ScreenShareSpigot;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Placeholder extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "screenshare";
    }

    @Override
    public @NotNull String getAuthor() {
        return "wIceh";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if(params.equals("suspected")) {
            if(!ScreenShareSpigot.jedis.get("Sospettato").equals("")) {
                return ScreenShareSpigot.jedis.get("Sospettato");
            }else {
                return "Nessuno";
            }
        }
        return null;
    }
}
