package me.mio.utility.commands.reports;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Arrays;

public class ReportCommand implements CommandExecutor {

    private ReportManager reportManager;

    public ReportCommand(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 2) {
                String reportedPlayer = args[0];
                String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                reportManager.addReport(player.getName(), reportedPlayer, reason);
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eReport submitted successfully.");
            } else {
                player.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cUsage: /report <player> <reason>");
            }
        } else {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §cThis command can only be executed by a player.");
        }
        return true;
    }
}
