package aa.plugin.system;

import org.bukkit.Bukkit;
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
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Time implements CommandExecutor, Listener
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		Player p = (Player) sender;
		if (sender instanceof Player)
		{
			if (p.hasPermission("71ess.time"))
			{
				if (args.length == 0)
				{
					Inventory inv = Bukkit.createInventory(null, 9*5, "時間控制");
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 4.0F, 4.0F);
					
					//第一排
					inv.setItem(0, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(1, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(2, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(3, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(4, createItem.createItem(Material.WATCH, 0, " ", ""));
					inv.setItem(5, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(6, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(7, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(8, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
				
					//第三排
					inv.setItem(20, createItem.createItem(Material.DOUBLE_PLANT, 0, "§6早上", ""));
					inv.setItem(24, createItem.createItem(Material.EYE_OF_ENDER, 0, "§8晚上", ""));
				
					//第四排
					inv.setItem(35, createItem.createItem(Material.REDSTONE_BLOCK, 0, "§4警告", "切換後請自行關閉選單"));
				
					//第五排
					inv.setItem(36, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(37, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(38, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(39, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(40, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(41, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(42, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(43, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
					inv.setItem(44, createItem.createItem(Material.STAINED_GLASS_PANE, 15, " ", ""));
				
					p.openInventory(inv);
				}
			} else {
				p.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		} else {
			sender.sendMessage("此指令限定玩家使用");
		}
		return false;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("時間控制"))
		{
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6早上"))
			{
				p.getLocation().getWorld().setTime(1000);
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_DAY));
				
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8晚上"))
			{
				p.getLocation().getWorld().setTime(16000);
				p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_NIGHT));
			}
		}
	}
	
}
			
