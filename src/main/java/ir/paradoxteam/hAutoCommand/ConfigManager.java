package ir.paradoxteam.hAutoCommand;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {

    private final Main plugin;
    private boolean enabled;
    private int time;
    private List<String> commands;
    private String prefix;

    public  ConfigManager(Main plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        load();
    }

    public void load() {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();
        enabled = config.getBoolean("enabled", true);
        time = config.getInt("time", 30);
        commands = config.getStringList("commands");
        prefix = config.getString("prefix");
    }

    public boolean isEnabled() { return enabled; }
    public int getTime() { return time; }
    public List<String> getCommands() { return commands; }
    public String getPrefix() { return prefix; }

}
