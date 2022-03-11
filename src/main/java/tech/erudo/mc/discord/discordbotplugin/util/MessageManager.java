package tech.erudo.mc.discord.discordbotplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageManager {

    public static void sendAll(String user, String msg) {
        sendAll("[" + user + "] " + msg);
    }

    public static void sendAll(String msg) {
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage(msg);
        }
    }
}
