package de.bacherik.api.languages;

import de.bacherik.api.Main;
import org.bukkit.Bukkit;

public class Manager {
    public static void init(){
        Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "Language-System Started");
    }
}
