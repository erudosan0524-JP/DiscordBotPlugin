package tech.erudo.mc.discord.discordbotplugin;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.tokens.Token;
import tech.erudo.mc.discord.discordbotplugin.command.CommandManager;
import tech.erudo.mc.discord.discordbotplugin.discord.DiscordClient;
import tech.erudo.mc.discord.discordbotplugin.discord.listener.ChatListener;
import tech.erudo.mc.discord.discordbotplugin.listener.InteractListener;
import tech.erudo.mc.discord.discordbotplugin.util.config.TokenConfig;

import javax.security.auth.login.LoginException;

public final class DiscordBotPlugin extends JavaPlugin {

    private static DiscordBotPlugin INSTANCE;

    @Getter
    private DiscordClient client;

    @Override
    public void onEnable() {
        INSTANCE = this;

        //BOTの設定
        TokenConfig tokenConfig = new TokenConfig(this);
        client = new DiscordClient(tokenConfig.getToken(), tokenConfig.getGuildId());

        //Listenerの登録
        new InteractListener(this);

        //コマンドの登録
        CommandManager commandManager = new CommandManager(this);
        commandManager.setup();

    }

    @Override
    public void onDisable() {
        client.shutdown();
    }

    public static DiscordBotPlugin getInstance() {
        return INSTANCE;
    }
}
