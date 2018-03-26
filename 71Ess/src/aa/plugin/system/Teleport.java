package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Teleport implements CommandExecutor, Listener
{
	List<Inventory> inventories = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (sender.hasPermission("71ess.gamemode"))
			{
				if (args.length == 0)
				{
					Inventory inv = Bukkit.createInventory(null, 36, "在線玩家列表 (傳送用)");
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 4.0F, 4.0F);
					
					for (Player OnlinePlayers : Bukkit.getOnlinePlayers())
					{	
						if (OnlinePlayers != p.getPlayer())
						{
							ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
							SkullMeta meta = (SkullMeta)item.getItemMeta();
							meta.setDisplayName(OnlinePlayers.getName());
							meta.setOwningPlayer(OnlinePlayers);
							item.setItemMeta(meta);
							
							inv.addItem(item);
							
						}
					}
					p.openInventory(inv);
				}
			}
		}
		return false;
	}
	
	//判斷使用者點擊物品 並且作出相對回應
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("在線玩家列表 (傳送用)"))
		{
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
				
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			for (Player OnlinePlayers : Bukkit.getOnlinePlayers())
			{
				if (OnlinePlayers != p.getPlayer())
				{
					if (e.getCurrentItem().getItemMeta().getDisplayName().equals(OnlinePlayers.getName()))
					{
						Location loc = OnlinePlayers.getLocation();
						p.teleport(loc);
						
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TELEPORT_TOPLAYER));
					}
				}
			}	
		}
	}
}
