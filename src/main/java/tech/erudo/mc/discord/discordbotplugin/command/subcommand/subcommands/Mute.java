package tech.erudo.mc.discord.discordbotplugin.command.subcommand.subcommands;

import org.bukkit.entity.Player;
import tech.erudo.mc.discord.discordbotplugin.auth.AuthManager;
import tech.erudo.mc.discord.discordbotplugin.auth.AuthPlayer;
import tech.erudo.mc.discord.discordbotplugin.command.subcommand.SubCommand;

public class Mute implements SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {
        if(!AuthManager.containsAuthPlayer(player)) {
            player.sendMessage("認証してください");
        } else {
            AuthPlayer authPlayer = AuthManager.getAuthPlayer(player);

            if(authPlayer.getMember() == null) return;
            if(authPlayer.getMember().getVoiceState() == null) return;
            if(!authPlayer.getMember().getVoiceState().inVoiceChannel()) return;

            authPlayer.getMember().mute(true).queue();
        }
    }

    @Override
    public String name() {
        return "mute";
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
