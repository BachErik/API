package de.bacherik.api;

import de.bacherik.api.languages.Manager;
import de.niklas.nikapi.spigot.NikAPI;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String PREFIX = ChatColor.GOLD + "[API] §f";
    @Override
    public void onEnable() {
        NikAPI nikAPI = new NikAPI();
        nikAPI.init(this);
        // Plugin startup logic
        Manager.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
