package lobbyapi.lobbyapi.utils;

import lobbyapi.lobbyapi.MySQL.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MySQLInventory implements CommandExecutor {

    // hier steht nix

    private ItemStack glass = ItemBuilder.createItem(" ", Material.GRAY_STAINED_GLASS_PANE, 1);
    private ItemStack connected = ItemBuilder.createItem("§e§lMySQL §aconnected", Material.EMERALD, 1);
    private ItemStack notconnected = ItemBuilder.createItem("§e§lMySQL §cnot connected", Material.REDSTONE, 1);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("checkmysql")) {
            if (p.hasPermission("statsapi.check")) {
                final Inventory inv = Bukkit.createInventory(null, 27, "§8» §e§lMySQL §acheck §8«");

                inv.setItem(0, glass);
                inv.setItem(1, glass);
                inv.setItem(2, glass);
                inv.setItem(3, glass);
                inv.setItem(4, glass);
                inv.setItem(5, glass);
                inv.setItem(6, glass);
                inv.setItem(7, glass);
                inv.setItem(8, glass);
                inv.setItem(9, glass);
                inv.setItem(10, glass);
                inv.setItem(11, glass);
                inv.setItem(12, glass);
                inv.setItem(14, glass);
                inv.setItem(15, glass);
                inv.setItem(16, glass);
                inv.setItem(17, glass);
                inv.setItem(18, glass);
                inv.setItem(19, glass);
                inv.setItem(20, glass);
                inv.setItem(21, glass);
                inv.setItem(22, glass);
                inv.setItem(23, glass);
                inv.setItem(24, glass);
                inv.setItem(25, glass);
                inv.setItem(26, glass);

                if (MySQL.isConnected()) {
                    inv.setItem(13, connected);
                } else if (!MySQL.isConnected()) {
                    inv.setItem(13, notconnected);
                }

                p.openInventory(inv);

            }
        }
        return true;
    }
}
