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

public class MainAdminGUI implements Listener
{
	
	public static void mainAdmin (Player player)
	{
		int inventorySizeLevel = 5;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];

		items[11] = createItem.createItemsForICON(Material.ELYTRA, 0, 1, "§a傳送", Arrays.asList(" "));
		
		items[13] = createItem.createItemsForICON(Material.WATCH, 0, 1, "§6時間", Arrays.asList(" "));
		
		items[15] = createItem.createItemsForICON(Material.DIRT, 0, 1, "§e遊戲模式", Arrays.asList(" ")); 
		
		items[44] = createItem.createItemsForICON(Material.BARRIER, 0, 1, "返回至主選單", Arrays.asList(" "));
		
		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "管理員使用");
		inv.setStorageContents(items);
		player.openInventory(inv);
	}
	
	@EventHandler
	public static void mainClick (InventoryClickEvent event)
	{
		if (event.getInventory().getName().contains("管理員使用"))
		{
			
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
			
			switch (event.getRawSlot() == event.getSlot() ? event.getRawSlot() : -1)
			{
				case 11:
					player.closeInventory();
					TeleportGUI.teleportGUI(player);
					break;
					
				case 13:
					player.closeInventory();
					TimeGUI.Time(player);
					break;
					
				case 15:
					player.closeInventory();
					GamemodeGUI.GameModeGUI(player);
					break;
					
				case 44:
					player.closeInventory();
					MainGUI.main(player);
					break;
					
				default:
					break;
			}
		}	
	}
}
