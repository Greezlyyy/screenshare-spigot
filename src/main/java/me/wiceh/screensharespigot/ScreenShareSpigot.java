package me.wiceh.screensharespigot;

import me.wiceh.screensharespigot.listeners.Listeners;
import me.wiceh.screensharespigot.objects.Placeholder;
import org.bukkit.plugin.java.JavaPlugin;
import redis.clients.jedis.Jedis;

public final class ScreenShareSpigot extends JavaPlugin {

    public static Jedis jedis;
    private final String CONNECTION_STRING = "redis://default:cVLItIxsoXNeUvDyJh6UGism15aLV1cI@redis-12700.c276.us-east-1-2.ec2.cloud.redislabs.com:12700";

    @Override
    public void onEnable() {
        getLogger().info("Il plugin è stato abilitato!");
        jedis = new Jedis(CONNECTION_STRING);
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        new Placeholder().register();
    }
}
