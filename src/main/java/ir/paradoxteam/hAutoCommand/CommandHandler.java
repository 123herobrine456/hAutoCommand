package ir.paradoxteam.hAutoCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private final Main plugin;

    public CommandHandler(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getPrefix());

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("hautocommand.admin")) {
                sender.sendMessage(prefix + "No permission!");
                return true;
            }

            plugin.getConfigManager().load();
            plugin.getScheduler().stop();
            if (plugin.getConfigManager().isEnabled()) {
                plugin.startTask();
            }

            sender.sendMessage(prefix + "Config reloaded!");
            return true;
        }

        sender.sendMessage(prefix + "Usage: /autocommand reload");
        return true;
    }
}