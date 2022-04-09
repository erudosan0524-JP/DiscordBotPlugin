package tech.erudo.mc.discord.discordbotplugin.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import okhttp3.Cache;
import org.bukkit.entity.Player;
import tech.erudo.mc.discord.discordbotplugin.discord.listener.ChatListener;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class DiscordClient {
    private JDA jda = null;
    private final Long guildId;

    private final List<Player> speakingPlayers = new ArrayList<>();

    public DiscordClient(String token, Long guildId) {
        this.guildId = guildId;
        login(token);
    }

    private void login(String token) {
        try {
            jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGES)
                    .disableCache(CacheFlag.EMOTE)
                    .enableCache(CacheFlag.VOICE_STATE)
                    .setRawEventsEnabled(true)
                    .addEventListeners(new ChatListener())
                    .setActivity(Activity.playing("マインクラフト"))
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public boolean isLogin() {
        return jda != null;
    }

    public Guild getGuild() {
        if(guildId != null) {
            return jda.getGuildById(guildId);
        } else {
            return null;
        }
    }

    public String getBotName() {
        return jda.getSelfUser().getName();
    }

    public void shutdown() {
        jda.shutdownNow();
    }

}
