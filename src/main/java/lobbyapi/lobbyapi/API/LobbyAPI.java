package lobbyapi.lobbyapi.API;

import lobbyapi.lobbyapi.MySQL.CoinsMySQL;
import lobbyapi.lobbyapi.utils.MySQLInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyAPI extends JavaPlugin {

    public static String Prefix = "§e§lLobbyAPI §8» ";
    public static LobbyAPI INSTANCE;

    @Override
    public void onEnable() {

        CoinsMySQL.setStandardMySQL();
        CoinsMySQL.readMySQL();
        CoinsMySQL.connect();
        CoinsMySQL.createTable();

        getCommand("checkmysql").setExecutor(new MySQLInventory());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public LobbyAPI() {
        INSTANCE = this;
    }
}
