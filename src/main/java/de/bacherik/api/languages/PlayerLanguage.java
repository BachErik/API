package de.bacherik.api.languages;

import de.niklas.nikapi.spigot.config.YAMLConfig;

import java.io.IOException;

public class PlayerLanguage {

    private YAMLConfig config;

    public PlayerLanguage(String destination, String configName) {
        try {
            config = new YAMLConfig("plugins/" + destination + "/languages/" + configName + ".yml");
            getConfig().save();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
    public String getValue(String key) throws IOException {
        if(!getConfig().existEntry(key)) return null;
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
        config = new YAMLConfig("plugins/API/" + "PlayerLanguages.yml");
        getConfig().save();
        getConfig().addEntry(player, configDestination);
        getConfig().save();
    }
    public String setMessage(String message, String player) throws IOException {
        config = new YAMLConfig("plugins/API/" + "PlayerLanguages.yml");
        String Player = getConfig().getString(player);
        config = new YAMLConfig(Player);
        return getConfig().getString(message);
    }
}
