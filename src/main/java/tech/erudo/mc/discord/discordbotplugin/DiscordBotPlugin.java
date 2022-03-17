package tech.erudo.mc.discord.discordbotplugin;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;
import tech.erudo.mc.discord.discordbotplugin.discord.DiscordClient;
import tech.erudo.mc.discord.discordbotplugin.discord.listener.ChatListener;
import tech.erudo.mc.discord.discordbotplugin.listener.InteractListener;
import tech.erudo.mc.discord.discordbotplugin.util.config.TokenConfig;

import javax.security.auth.login.LoginException;

public final class DiscordBotPlugin extends JavaPlugin {

    @Getter
    private static DiscordBotPlugin instance;

    private DiscordClient client;

    @Override
    public void onEnable() {
        //instance設定
        instance = this;

        //BOTの設定
        final TokenConfig tokenConfig = new TokenConfig(this);
        client = new DiscordClient(tokenConfig.getToken(), tokenConfig.getGuildId());

        //Listenerの登録
        new InteractListener(getInstance());

    }

    @Override
    public void onDisable() {
        client.shutdown();
    }
}
