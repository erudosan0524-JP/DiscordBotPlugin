package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;

public class JoinCommand implements Command {
    @Override
    public String name() {
        return "join";
    }

    @Override
    public void execute(MessageReceivedEvent e) {
        TextChannel channel = e.getTextChannel();
        if(!e.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
            e.getTextChannel().sendMessage("I do not have permission to join a voice channel").queue();
        } else {
            VoiceChannel connectChannel = e.getMember().getVoiceState().getChannel();
        }
    }
}
