package tech.erudo.mc.discord.discordbotplugin.command.subcommand.subcommands;

import org.bukkit.entity.Player;
import tech.erudo.mc.discord.discordbotplugin.command.subcommand.SubCommand;

public class Auth implements SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {

    }

    @Override
    public String name() {
        return "auth";
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
