package ir.paradoxteam.hAutoCommand;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class CommandScheduler {

    private final Main plugin;
    private BukkitTask task;

    public CommandScheduler(Main plugin) {
        this.plugin = plugin;
    }

    public void start(long delayTicks, long periodTicks) {
        stop();

        task = new BukkitRunnable() {
            @Override
            public void run() {
                for (String cmd : plugin.getConfigManager().getCommands()) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    plugin.getLogger().info("Cmd Runned: " + cmd);
                }
            }
        }.runTaskTimer(plugin, delayTicks, periodTicks);
    }

    public void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    public boolean isRunning() {
        return task != null;
    }
}