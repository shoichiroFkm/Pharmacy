package jp.houlab.shoichiro.pharmacy;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pharmacy extends JavaPlugin {
    static private Plugin plugin;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Ability(), this);
        getServer().getPluginManager().registerEvents(new Ultimate(), this);
        // Plugin startup logic
        getLogger().info("Pharmacy Plugin On");
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Pharmacy Plugin Off");
    }
    static public Plugin getPlugin(){
        return plugin;
    }
}
