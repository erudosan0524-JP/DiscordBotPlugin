package tech.erudo.mc.discord.discordbotplugin.listener.bukkit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class InteractListener implements Listener {

    private JavaPlugin plugin;

    public InteractListener(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    //骨を使ってプレイヤーをクリックした時
    @EventHandler
    public void onBoneInteract(PlayerInteractEntityEvent e) {
        if(!(e.getRightClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) e.getRightClicked();
        PlayerInventory inv = player.getInventory();

        if(inv.getItemInMainHand().getType().equals(Material.BONE)) {

        }
    }
}
