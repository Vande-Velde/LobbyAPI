package lobbyapi.lobbyapi.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemBuilder() {}

    public static ItemStack createItem(String name, Material material, int amout) {
        ItemStack item = new ItemStack(material, amout);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }
}
