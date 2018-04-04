package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import aa.plugin.function.createItem;

public class Weather implements CommandExecutor, Listener
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (p.hasPermission("71ess.weather"))
			{
				if (args.length == 0)
				{
					Inventory inv = Bukkit.createInventory(null, 9*5, "天氣選單");
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 4.0F, 4.0F);
				
					//第一排
					for(int i = 0; i <= 8; i++) {
						
						inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
					}
					
					//第三排
					inv.setItem(20, createItem.createItemsForGUI(Material.LAVA_BUCKET, 0, "§a晴天", ""));
					inv.setItem(24, createItem.createItemsForGUI(Material.WATER_BUCKET, 0, "§c陰天", ""));
				
					//第四排
					inv.setItem(35, createItem.createItemsForGUI(Material.REDSTONE_BLOCK, 0, "§4警告", "切換後請自行關閉選單"));
				
					//第五排
					for(int i = 36; i <= 44; i++) {
						
						inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
					}
				
					p.openInventory(inv);
				}
			} else {
				p.sendMessage("不給你用");
			}
		} else {
			sender.sendMessage("此指令限定玩家使用");
		}
		return false;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("天氣選單"))
		{
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a晴天"))
			{
				p.getWorld().setStorm(false);
				p.getWorld().setThundering(false);
				p.sendMessage("已經您所在地圖更改天氣 " + ChatColor.GOLD + p.getWorld().getName() + "§f (晴天)");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c陰天"))
			{
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(true);
				p.sendMessage("已經您所在地圖更改天氣 " + ChatColor.GOLD + p.getWorld().getName() + "§f (陰天)");
			}
		}
	}
}
