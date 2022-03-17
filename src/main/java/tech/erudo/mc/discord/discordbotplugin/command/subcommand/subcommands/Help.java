package tech.erudo.mc.discord.discordbotplugin.command.subcommand.subcommands;

import org.bukkit.entity.Player;
import tech.erudo.mc.discord.discordbotplugin.command.subcommand.SubCommand;

public class Help implements SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage(
                "===================",
                "HELP",
                "==================="
        );
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
