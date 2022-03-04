package de.bacherik.api.languages;

import de.niklas.nikapi.spigot.config.YAMLConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PlayerLanguage {

    private YAMLConfig config;

    public PlayerLanguage(String destination, String configName) {
        try {
            config = new YAMLConfig("plugins/" + destination + "/languages/" + configName + ".yml");
            getConfig().save();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getValue(String key) throws IOException {
        if (!getConfig().existEntry(key)) return null;
        return getConfig().getString(key);
    }

    public void setEntry(String key, Object value) throws IOException {
        getConfig().addEntry(key, value);
        getConfig().save();
    }

    public void setDefaultEntry(String key, Object value) throws IOException {
        getConfig().addDefaultEntry(key, value);
        getConfig().save();
    }

    public YAMLConfig getConfig() throws IOException {
        return config;
    }

    public void setPlayerLanguage(String configDestination, String player) throws IOException {
        config = new YAMLConfig("plugins/API/" + "/languages/" + "PlayerLanguages.yml");
        getConfig().save();
        getConfig().addEntry(player, configDestination);
        getConfig().save();
    }

    public String getLastEntry(String configDestination){
        String file = "test.txt";
        BufferedReader breader = null;
        try {
            breader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        String line = null;
        String merke = null;

        try {
            while ((line = breader.readLine()) != null) {
                merke = line;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            breader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String entry = merke.toString();
        return entry;
    }

    public String setMessage(String message, String player) throws IOException {
        config = new YAMLConfig("plugins/API/" + "/languages/" + "PlayerLanguages.yml");
        if (!(getConfig().existEntry(player))) {
            Player p = Bukkit.getPlayer(player);
            p.sendMessage("§eChoose a Language with: §6/language");
        } else {
            String Player = getConfig().getString(player);
            config = new YAMLConfig(Player);
            return getConfig().getString(message);
        }
        return message;
    }
}
