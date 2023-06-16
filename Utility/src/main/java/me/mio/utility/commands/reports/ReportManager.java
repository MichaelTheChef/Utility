package me.mio.utility.commands.reports;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {

    private MongoCollection<Report> reportCollection;

    public ReportManager(MongoCollection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    public void addReport(String reporter, String reportedPlayer, String reason) {
        Report report = new Report(reporter, reportedPlayer, reason);
        reportCollection.insertOne(report);
    }

    public List<Report> getReports() {
        List<Report> reports = new ArrayList<>();
        for (Report report : reportCollection.find()) {
            reports.add(report);
        }
        return reports;
    }
}
