package ir.paradoxteam.hAutoCommand;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    private ConfigManager configManager;
    private CommandScheduler scheduler;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.scheduler = new CommandScheduler(this);

        if (configManager.isEnabled()) {
            startTask();
        }

        getCommand("autocommand").setExecutor(new CommandHandler(this));
        getLogger().info("hAutoCommand enabled.");
    }

    @Override
    public void onDisable() {
        scheduler.stop();
        getLogger().info("hAutoCommand disabled.");
    }

    public void startTask() {
        scheduler.start(0L, configManager.getTime() * 20L);
    }

    public ConfigManager getConfigManager() { return configManager; }
    public CommandScheduler getScheduler() { return scheduler; }
}
