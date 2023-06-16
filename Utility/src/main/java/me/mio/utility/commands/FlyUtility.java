package me.mio.utility.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FlyUtility implements CommandExecutor {

    private JavaPlugin plugin;

    public FlyUtility(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("util.fly")) {
                boolean isFlying = !player.isFlying();
                player.setFlying(isFlying);
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eFlight " + (isFlying ? "enabled" : "disabled") + ".");
            } else {
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cYou don't have permission to use this command.");
            }
        } else {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cThis command can only be executed by a player.");
        }
        return true;
    }
}
