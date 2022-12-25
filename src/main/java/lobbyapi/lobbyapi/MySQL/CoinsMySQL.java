package lobbyapi.lobbyapi.MySQL;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class CoinsMySQL {

    public static String username;
    public static String password;
    public static String database;
    public static String host;
    public static String port;
    public static Connection con;

    public CoinsMySQL(String user, String pass, String host2, String dB) {}

    public static void connect()
    {
        if (!isConnected()) {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + username + "&password=" + password + "&autoReconnect=true");
                Bukkit.getConsoleSender().sendMessage("LobbyAPI verbunden");
            }
            catch (SQLException e)
            {
                Bukkit.getConsoleSender().sendMessage("Eine verbindung zur LobbyAPI konnte nicht hergestellt werden!");
            }
        }
    }

    public static void close()
    {
        if (isConnected()) {
            try
            {
                con.close();
                Bukkit.getConsoleSender().sendMessage("LobbyAPI verbindung getrent");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected()
    {
        return con != null;
    }

    public static void createTable()
    {
        if (isConnected()) {
            try
            {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS LobbyAPI (UUID VARCHAR(100), COINS int, KILLS int, DEATHS int , WIN int , LOSE int , BEDS int)");
                Bukkit.getConsoleSender().sendMessage("LobbyAPI Table created");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void update(String qry)
    {
        if (isConnected()) {
            try
            {
                con.createStatement().executeUpdate(qry);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet getResult(String qry)
    {
        ResultSet rs = null;
        try
        {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        }
        catch (SQLException e)
        {
            connect();
            System.err.println(e);
        }
        return rs;
    }

    public static File getMySQLFile()
    {
        return new File("plugins/LobbyAPI", "LobbyAPI.yml");
    }

    public static FileConfiguration getMySQLFileConfiguration()
    {
        return YamlConfiguration.loadConfiguration(getMySQLFile());
    }

    public static void setStandardMySQL()
    {
        FileConfiguration cfg = getMySQLFileConfiguration();

        cfg.options().copyDefaults(true);
        cfg.addDefault("username", "root");
        cfg.addDefault("password", "password");
        cfg.addDefault("database", "localhost");
        cfg.addDefault("host", "localhost");
        cfg.addDefault("port", "3306");
        try
        {
            cfg.save(getMySQLFile());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readMySQL()
    {
        FileConfiguration cfg = getMySQLFileConfiguration();
        username = cfg.getString("username");
        password = cfg.getString("password");
        database = cfg.getString("database");
        host = cfg.getString("host");
        port = cfg.getString("port");
    }
}