package me.mio.utility.commands.reports;

public class Report {

    private String reporter;
    private String reportedPlayer;
    private String reason;

    public Report(String reporter, String reportedPlayer, String reason) {
        this.reporter = reporter;
        this.reportedPlayer = reportedPlayer;
        this.reason = reason;
    }

    public String getReporter() {
        return reporter;
    }

    public String getReportedPlayer() {
        return reportedPlayer;
    }

    public String getReason() {
        return reason;
    }
}
