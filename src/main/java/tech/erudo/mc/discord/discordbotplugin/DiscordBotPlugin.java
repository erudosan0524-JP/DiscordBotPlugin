package tech.erudo.mc.discord.discordbotplugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;
import tech.erudo.mc.discord.discordbotplugin.listener.bot.ChatListener;

import javax.security.auth.login.LoginException;

public final class DiscordBotPlugin extends JavaPlugin {

    private JDA jda = null;
    private final String BOT_TOKEN = "";

    @Override
    public void onEnable() {
        try {
            jda = JDABuilder.createDefault(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES)
                    .setRawEventsEnabled(true)
                    .addEventListeners(new ChatListener())
                    .setActivity(Activity.playing("マインクラフト"))
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
