package me.mio.utility;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.mio.utility.commands.FlyUtility;
import me.mio.utility.commands.GamemodeUtility;
import me.mio.utility.commands.VanishUtility;
import me.mio.utility.commands.reports.Report;
import me.mio.utility.commands.reports.ReportCommand;
import me.mio.utility.commands.reports.ReportManager;
import me.mio.utility.commands.reports.ReportsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Utility extends JavaPlugin {
    private FlyUtility flyUtility;
    private VanishUtility vanishUtility;
    private GamemodeUtility gamemodeUtility;
    private ReportManager reportManager;

    @Override
    public void onEnable() {
        flyUtility = new FlyUtility(this);
        vanishUtility = new VanishUtility(this);
        gamemodeUtility = new GamemodeUtility();

        getCommand("fly").setExecutor(flyUtility);
        getCommand("vanish").setExecutor(vanishUtility);
        getCommand("gamemode").setExecutor(gamemodeUtility);

        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("utility");
        MongoCollection<Report> reportCollection = database.getCollection("reports", Report.class);

        reportManager = new ReportManager(reportCollection);

        getCommand("report").setExecutor(new ReportCommand(reportManager));
        getCommand("reports").setExecutor(new ReportsCommand(reportManager));
    }

    public FlyUtility getFlyUtility() {
        return flyUtility;
    }

    public VanishUtility getVanishUtility() {
        return vanishUtility;
    }

    public GamemodeUtility getGamemodeUtility() {
        return gamemodeUtility;
    }

    public ReportManager getReportManager() {
        return reportManager;
    }
}
