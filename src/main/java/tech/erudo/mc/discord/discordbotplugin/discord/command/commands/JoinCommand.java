package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;

public class JoinCommand implements Command {
    @Override
    public String name() {
        return "join";
    }

    @Override
    public void execute(MessageReceivedEvent e, String[] args) {
        TextChannel channel = e.getTextChannel();
        if(!e.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
            e.getTextChannel().sendMessage("I do not have permission to join a voice channel").queue();
        } else {
            if(e.getMember().getVoiceState() == null) return;
            if(!e.getMember().getVoiceState().inVoiceChannel()) return;
            if(e.getGuild().getSelfMember().getVoiceState().inVoiceChannel()) return;
            if(e.getMember().getVoiceState().getChannel() == null) return;

            VoiceChannel connectChannel = e.getMember().getVoiceState().getChannel();

            if(connectChannel == null) {
                channel.sendMessage("You are not connected to a voice channel!").queue();
                return;
            }

            AudioManager audioManager = e.getGuild().getAudioManager();
            audioManager.openAudioConnection(connectChannel);
            channel.sendMessage("Connected!").queue();

        }
    }
}
