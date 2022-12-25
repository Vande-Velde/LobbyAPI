package lobbyapi.lobbyapi.API;

import lobbyapi.lobbyapi.MySQL.CoinsMySQL;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyAPI extends JavaPlugin {

    public static LobbyAPI INSTANCE;
    public static LobbyAPI plugin;

    @Override
    public void onEnable() {

        CoinsMySQL.setStandardMySQL();
        CoinsMySQL.readMySQL();
        CoinsMySQL.connect();
        CoinsMySQL.createTable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public LobbyAPI() {
        INSTANCE = this;
    }
    public static LobbyAPI getPlugin() {
        return plugin;
    }
}
