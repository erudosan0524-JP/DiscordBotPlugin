package tech.erudo.mc.discord.discordbotplugin.command.subcommand;

import org.bukkit.entity.Player;

public interface SubCommand {

    void onCommand(Player player, String[] args);
    String name();
    String info();
    String[] aliases();
}
