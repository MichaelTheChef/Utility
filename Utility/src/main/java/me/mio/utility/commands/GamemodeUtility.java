package me.mio.utility.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeUtility implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("util.gamemode")) {
                if (args.length == 1) {
                    GameMode gameMode = parseGameMode(args[0]);
                    if (gameMode != null) {
                        player.setGameMode(gameMode);
                        player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eYour gamemode has been set to " + gameMode.toString() + ".");
                    } else {
                        player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cInvalid gamemode specified.");
                    }
                } else {
                    player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cUsage: /gamemode <gamemode>");
                }
            } else {
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cYou don't have permission to use this command.");
            }
        } else {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cThis command can only be executed by a player.");
        }
        return true;
    }

    private GameMode parseGameMode(String input) {
        try {
            int value = Integer.parseInt(input);
            return GameMode.getByValue(value);
        } catch (NumberFormatException e) {
            try {
                return GameMode.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }
    }
}
