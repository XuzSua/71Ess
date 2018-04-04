package aa.plugin.main.GUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import aa.plugin.function.createItem;

public class mainAdminGUI implements Listener
{
	
	public static void main (Player player)
	{
		int inventorySizeLevel = 2;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];

		items[2] = createItem.createItemsForICON(Material.ELYTRA, 0, 1, "§a傳送", Arrays.asList("§f玩家用傳送相關"));
		
		items[17] = createItem.createItemsForICON(Material.BARRIER, 0, 1, "返回至主選單", Arrays.asList(" "));
		
		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "管理員使用");
		inv.setStorageContents(items);
		player.openInventory(inv);
	}
	
	@EventHandler
	public static void mainClick (InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		switch (event.getRawSlot() == event.getSlot() ? event.getRawSlot() : -1)
		{
			case 2:
				player.closeInventory();
				player.performCommand("tp");
				break;
				
			case 17:
				player.closeInventory();
				mainGUI.main(player);
				break;
				
			default:
				break;
		}
		
	}
}
