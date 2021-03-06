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
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class TimeGUI implements Listener
{
	public static void Time(Player player)
	{
		int inventorySizeLevel = 5;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];

		for(int i = 0; i <= 8; i++) {
			
			items[i] = createItem.createItemsForICON(Material.GLASS_PANE, 0, 1, " ", Arrays.asList(" "));
			
		}
		
		items[4] = createItem.createItemsForICON(Material.CLOCK, 0, 1, " ", Arrays.asList(" "));
	
		//第三排
		items[20] = createItem.createItemsForICON(Material.SUNFLOWER, 0, 1, "§6早上", Arrays.asList(" "));
		items[24] = createItem.createItemsForICON(Material.ENDER_EYE, 0, 1, "§7晚上", Arrays.asList(" "));

		//第五排
		for(int i = 36; i <= 44; i++) {
			
			items[i] = createItem.createItemsForICON(Material.WHITE_STAINED_GLASS_PANE, 0, 1, " ", Arrays.asList(" "));
			
		}
		
		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "時間選單");
		inv.setStorageContents(items);
		player.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (event.getInventory().getName().contains("時間選單"))
		{
			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
			
			switch (event.getRawSlot() == event.getSlot() ? event.getRawSlot() : -1)
			{
				case 20:
					player.closeInventory();
					player.getLocation().getWorld().setTime(1000);
					sendActionBar(player, MessageManager.TIME_DAY);
					break;
					
				case 24:
					player.closeInventory();
					player.getLocation().getWorld().setTime(16000);
					sendActionBar(player, MessageManager.TIME_NIGHT);
					break;
					
				default:
					break;
		
			}
		}
	}
	
	public void sendActionBar(Player player,String str) {
		
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(str).create());
		
	}
}
