package tech.erudo.mc.discord.discordbotplugin.discord;

import lombok.Data;
import net.dv8tion.jda.api.entities.User;
import org.bukkit.entity.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class DiscordMember {

    public static final HashMap<Player, DiscordMember> memberMap = new HashMap<>();
    public static final Set<Player> playerList = memberMap.keySet();
    public static final HashMap<Player, String> PlayerToAuthcode = new HashMap<>();

    private Long userId;

    public DiscordMember(Long userId) {
        this.userId = userId;
    }

    public static boolean auth() {
        return false;
    }

}
