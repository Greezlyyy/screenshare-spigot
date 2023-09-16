package me.wiceh.screensharespigot.listeners;

import me.wiceh.screensharespigot.ScreenShareSpigot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String stafferName = ScreenShareSpigot.jedis.get("Staffer");
        String sospettatoName = ScreenShareSpigot.jedis.get("Sospettato");
        if(event.getPlayer().getName().equals(stafferName)) {
            event.setCancelled(true);
            Bukkit.getPlayer(stafferName).sendMessage("§b[STAFF] §7" + stafferName + ": §f" + event.getMessage());
            Bukkit.getPlayer(sospettatoName).sendMessage("§b[STAFF] §7" + stafferName + ": §f" + event.getMessage());
        }else if(event.getPlayer().getName().equals(sospettatoName)) {
            event.setCancelled(true);
            Bukkit.getPlayer(stafferName).sendMessage("§c[FROZEN] §7" + sospettatoName + ": §f" + event.getMessage());
            Bukkit.getPlayer(sospettatoName).sendMessage("§c[FROZEN] §7" + sospettatoName + ": §f" + event.getMessage());
        }else if(!event.getPlayer().getName().equals(stafferName) || !event.getPlayer().getName().equals(sospettatoName)) {
            event.setCancelled(true);
            Bukkit.getServer().broadcastMessage("§d[DEBUG] §7" + event.getPlayer().getName() + ": §f" + event.getMessage());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ScreenShareSpigot.jedis.set("Staffer", "");
        ScreenShareSpigot.jedis.set("Sospettato", "");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ScreenShareSpigot.jedis.connect();
    }
}
