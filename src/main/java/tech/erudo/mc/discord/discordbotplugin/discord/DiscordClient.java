package tech.erudo.mc.discord.discordbotplugin.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.entity.Player;
import tech.erudo.mc.discord.discordbotplugin.DiscordBotPlugin;
import tech.erudo.mc.discord.discordbotplugin.discord.listener.ChatListener;
import tech.erudo.mc.discord.discordbotplugin.util.config.TokenConfig;

import javax.security.auth.login.LoginException;

public class DiscordClient {
    private JDA jda = null;
    private Long guildId = null;

    public DiscordClient(String token, Long guildId) {
        this.guildId = guildId;
        login(token);
    }

    private void login(String token) {
        try {
            jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES)
                    .setRawEventsEnabled(true)
                    .addEventListeners(new ChatListener())
                    .setActivity(Activity.playing("マインクラフト"))
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void mute(Player player, boolean muted) {
        Guild guild = this.getGuild();


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
