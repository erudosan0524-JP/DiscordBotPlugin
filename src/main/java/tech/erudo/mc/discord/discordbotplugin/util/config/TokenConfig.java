package tech.erudo.mc.discord.discordbotplugin.util.config;

import lombok.Data;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TokenConfig extends CustomConfig {

    public final String token;

    public TokenConfig(JavaPlugin plugin) {
        super(plugin, "token.yml");

        this.token = this.getConfig().getString("TOKEN");
    }
}
