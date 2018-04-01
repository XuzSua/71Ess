package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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

import aa.plugin.function.createItem;
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Teleport implements CommandExecutor, Listener
{	
	int listMaximum = 45;
	int inventorySizeLevel = 6;
	ItemStack[] items = new ItemStack[inventorySizeLevel * 9];
	List<Player> playersList = new ArrayList<Player>();
	
	Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "線上玩家列表 (傳送用)");
	int page;
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (sender.hasPermission("71ess.teleport"))
			{
				if (args.length == 0)
				{	
					playersList.addAll(Bukkit.getOnlinePlayers());
					for (int site = page * listMaximum; site < playersList.size() && site < ((page + 1) * listMaximum); site++)
					{
						//if (playersList.get(site) != p)
						{
							ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
							SkullMeta meta = (SkullMeta) item.getItemMeta();
							meta.setDisplayName("§e" + playersList.get(site).getName());
							meta.setOwningPlayer((OfflinePlayer)playersList.get(site));
							item.setItemMeta(meta);
								
						items[site - (page * listMaximum)] = item;
						playersList.remove(site);
						}
					}
					if (page > 0)
					{
						items[51] = createItem.createItems(Material.FEATHER, 0, "上一頁", " ");
					}
					if (playersList.size() - (listMaximum * page + 1) > 0)
					{
						items[52] = createItem.createItems(Material.FEATHER, 0, "下一頁", " ");
					}
					inv.setStorageContents(items);
					p.openInventory(inv);
				}
				
				if (args.length == 1)
				{
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null)
					{
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.TELEPORT_TARGETNOTFOUND, args[0])));
						return true;
					}
					p.teleport(target.getLocation());
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.TELEPORT_TOPLAYER, args[0])));
				}
			} else {
				p.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		}
		return false;
	}
	
	//判斷使用者點擊物品 並且作出相對回應
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("線上玩家列表 (傳送用)"))
		{
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
				
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			String ID = e.getCurrentItem().getItemMeta().getDisplayName();
			
			p.teleport(Bukkit.getPlayer(ChatColor.stripColor(ID)));
			
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.TELEPORT_TOPLAYER, ID)));

		}
	}
}
