package net.sapo.flycheck.Commands;

import net.sapo.flycheck.Flycheck;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commandflycheck implements CommandExecutor {
    FileConfiguration cfg = Flycheck.getPlugin(Flycheck.class).getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("incorrect-usage")).replace("&", ""));
            return true;
        }

        if (!sender.hasPermission("flycheck.fc")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("no-permissions")).replace("&", ""));
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("not-online")).replace("&", ""));
            return true;
        }

        if (player.hasPermission("essentials.fly")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("yes-access").replace("%player%", args[0])).replace("&", ""));
        }else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString("no-access").replace("%player%", args[0])).replace("&", ""));
        }

        return true;
    }
}
