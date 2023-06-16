package me.mio.utility.commands.reports;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ReportsCommand implements CommandExecutor {

    private ReportManager reportManager;

    public ReportsCommand(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Report> reports = reportManager.getReports();
        if (reports.isEmpty()) {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eNo reports available.");
        } else {
            sender.sendMessage("§eᴜᴛɪʟɪᴛʏ §8• §eReports:");
            for (Report report : reports) {
                sender.sendMessage("§e- Reporter: §7" + report.getReporter());
                sender.sendMessage("§e  Reported Player: §7" + report.getReportedPlayer());
                sender.sendMessage("§e  Reason: §7" + report.getReason());
            }
        }
        return true;
    }
}
