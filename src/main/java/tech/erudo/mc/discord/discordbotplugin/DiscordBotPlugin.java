package tech.erudo.mc.discord.discordbotplugin;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;
import tech.erudo.mc.discord.discordbotplugin.listener.bot.ChatListener;
import tech.erudo.mc.discord.discordbotplugin.listener.bukkit.InteractListener;
import tech.erudo.mc.discord.discordbotplugin.util.config.TokenConfig;

import javax.security.auth.login.LoginException;

public final class DiscordBotPlugin extends JavaPlugin {

    @Getter
    private static DiscordBotPlugin instance;

    private JDA jda = null;

    @Override
    public void onEnable() {
        //instance設定
        instance = this;

        //BOTの設定
        TokenConfig tokenConfig = new TokenConfig(this);
        final String BOT_TOKEN = tokenConfig.getToken();

        try {
            jda = JDABuilder.createDefault(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES)
                    .setRawEventsEnabled(true)
                    .addEventListeners(new ChatListener())
                    .setActivity(Activity.playing("マインクラフト"))
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        //Listenerの登録
        new InteractListener(getInstance());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
