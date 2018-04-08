package aa.plugin.main.GUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import aa.plugin.function.createItem;
import aa.plugin.main.MessageManager;

public class MainGUI implements Listener
{
	@EventHandler
	public void openMainGUI (PlayerSwapHandItemsEvent event)
	{
		if (event.getPlayer().isSneaking())
		{
			event.setCancelled(true);
			main(event.getPlayer());
		}		
	}
	
	public static void main (Player player)
	{
		int inventorySizeLevel = 2;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];
		
		if (player.isOp())
		{
			items[17] = createItem.createItemsForICON(Material.REDSTONE_BLOCK, 0, 1, "管理員使用指令", Arrays.asList("§c管理員權限使用"));
			
		} else {
			
			items[17] = createItem.createItemsForICON(Material.BARRIER, 0, 1, "管理員使用指令", Arrays.asList("§f你想用嗎? 不給你用"));
		}

		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "選單功能");
		inv.setStorageContents(items);
		player.openInventory(inv);
	}
	
	@EventHandler
	public static void mainClick (InventoryClickEvent event)
	{
		if (event.getInventory().getName().contains("選單功能"))
		{
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
			
			switch (event.getRawSlot() == event.getSlot() ? event.getRawSlot() : -1)
			{
				case 17:
					if (player.isOp())
					{
						player.closeInventory();
						MainAdminGUI.mainAdmin(player);
					} else {
						player.closeInventory();
						player.sendMessage(MessageManager.HAVENOPERMISSION);
					}
					break;
					
				default:
					break;
				
			}
		}
	}
}
