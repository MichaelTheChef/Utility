package me.mio.utility.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class VanishUtility implements CommandExecutor {

    private JavaPlugin plugin;
    private Set<UUID> vanishedPlayers;

    public VanishUtility(JavaPlugin plugin) {
        this.plugin = plugin;
        this.vanishedPlayers = new HashSet<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("util.vanish")) {
                UUID playerUUID = player.getUniqueId();
                boolean isVanished = vanishedPlayers.contains(playerUUID);
                if (isVanished) {
                    for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
                        onlinePlayer.showPlayer(plugin, player);
                    }
                    vanishedPlayers.remove(playerUUID);
                    player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eYou are no longer vanished.");
                } else {
                    for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()) {
                        onlinePlayer.hidePlayer(plugin, player);
                    }
                    vanishedPlayers.add(playerUUID);
                    player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eYou are now vanished.");
                }
            } else {
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cYou don't have permission to use this command.");
            }
        } else {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cThis command can only be executed by a player.");
        }
        return true;
    }
}
