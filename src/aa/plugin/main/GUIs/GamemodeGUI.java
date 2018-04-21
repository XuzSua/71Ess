package aa.plugin.main.GUIs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import aa.plugin.function.createItem;
import aa.plugin.main.MessageManager;

public class GamemodeGUI implements Listener
{

	public static void GameModeGUI(Player player)
	{
		int inventorySizeLevel = 5;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];
		
		for(int i = 0; i <= 8; i++) {
			
			items[i] = createItem.createItemsForICON(Material.STAINED_GLASS_PANE, 0, 1, " ", Arrays.asList(" "));
			
		}
		
		items[4] = createItem.createItemsForICON(Material.ITEM_FRAME, 0, 1, " ", Arrays.asList(" "));
	
		//第三排
		items[19] = createItem.createItemsForICON(Material.DIAMOND_PICKAXE, 0, 1, "§a生存模式", Arrays.asList(" "));
		items[21] = createItem.createItemsForICON(Material.GRASS, 0, 1, "§d創造模式", Arrays.asList(" "));
		items[23] = createItem.createItemsForICON(Material.PAPER, 0, 1, "§5冒險模式", Arrays.asList(" "));
		items[25] = createItem.createItemsForICON(Material.BARRIER, 0, 1, "§c觀察模式", Arrays.asList(" "));

		//第五排
		for(int i = 36; i <= 44; i++) {
			
			items[i] = createItem.createItemsForICON(Material.STAINED_GLASS_PANE, 0, 1, " ", Arrays.asList(" "));
			
		}
		
		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "遊戲模式選單選單");
		inv.setStorageContents(items);
		player.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (event.getInventory().getName().contains("遊戲模式選單"))
		{
			event.setCancelled(true);
			Player p = (Player) event.getWhoClicked();
			
			Map<String,GameMode> map = new HashMap<String,GameMode>();
			
			map.put("生存模式", GameMode.SURVIVAL);
			map.put("創造模式", GameMode.CREATIVE);
			map.put("冒險模式", GameMode.ADVENTURE);
			map.put("觀察模式", GameMode.SPECTATOR);
			
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
			
			String action = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
			
			p.setGameMode(map.get(action));
			p.sendActionBar(String.format(MessageManager.GAMEMODE_CHANGE, action));
		
			
		}
	}
}
