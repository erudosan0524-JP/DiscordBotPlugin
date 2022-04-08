package tech.erudo.mc.discord.discordbotplugin.command.subcommand.subcommands;

import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;
import tech.erudo.mc.discord.discordbotplugin.DiscordBotPlugin;
import tech.erudo.mc.discord.discordbotplugin.auth.AuthPlayer;
import tech.erudo.mc.discord.discordbotplugin.command.subcommand.SubCommand;
import tech.erudo.mc.discord.discordbotplugin.discord.DiscordClient;
import tech.erudo.mc.discord.discordbotplugin.auth.AuthManager;

public class Auth implements SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        DiscordClient client = DiscordBotPlugin.getInstance().getClient();
        if(client.isLogin()) {
            for(String code : AuthManager.authCode.keySet()) {
                if(args[0].equals(code)) {
                    player.sendMessage("Auth Complete!!");

                    AuthPlayer authPlayer = new AuthPlayer(player, AuthManager.authCode.get(code));
                    AuthManager.authPlayers.add(authPlayer);
                }
            }
        }
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
