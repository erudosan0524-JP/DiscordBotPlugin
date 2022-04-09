package tech.erudo.mc.discord.discordbotplugin.discord.listener;

import net.dv8tion.jda.api.audio.SpeakingMode;
import net.dv8tion.jda.api.audio.hooks.ConnectionListener;
import net.dv8tion.jda.api.audio.hooks.ConnectionStatus;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class VoiceListener implements ConnectionListener {

    @Override
    public void onPing(long ping) {

    }

    @Override
    public void onStatusChange(@NotNull ConnectionStatus status) {

    }

    @Override
    public void onUserSpeaking(@NotNull User user, boolean speaking) {
        if(speaking) {

        }
    }
}
