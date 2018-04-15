package aa.plugin.main.GUIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import aa.plugin.function.cooldown;
import aa.plugin.function.createItem;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TpaGUI
{
	
	public static void teleportGUI(Player player)
	{
		int listMaximum = 45;
		int inventorySizeLevel = 6;
		ItemStack[] items = new ItemStack[inventorySizeLevel * 9];
		List<Player> playersList = new ArrayList<Player>();
		
		Inventory inv = Bukkit.createInventory(null, inventorySizeLevel * 9, "線上玩家列表 (玩家傳送用)");
		int page = 0;
		
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
			items[51] = createItem.createItemsForICON(Material.FEATHER, 1, 1, "上一頁", Arrays.asList(" "));
		}
		if (playersList.size() - (listMaximum * page + 1) > 0)
		{
			items[52] = createItem.createItemsForICON(Material.FEATHER, 1, 1, "上一頁", Arrays.asList(" "));
		}
		inv.setStorageContents(items);
		player.openInventory(inv);
	}
	
	Map<Player, Player> teleport = new HashMap<>();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (event.getInventory().getName().contains("線上玩家列表 (玩家傳送用)"))
		{
			
			Player p = (Player) event.getWhoClicked();
			event.setCancelled(true);
	
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
			
			String ID = event.getCurrentItem().getItemMeta().getDisplayName();
			
			Player target = Bukkit.getPlayer(ChatColor.stripColor(ID));
			
			
			if (!(teleport.containsKey(target)))
			{
				if (!cooldown.CooldownCheck(p.getName() + "_傳送請求發送延遲"))
				{
					p.sendMessage("§f§l您的§a傳送請求§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
					return;
					
				} else {
					
					teleport.remove(target);
				}
				
				TextComponent tpInvite = new TextComponent();
				
					tpInvite.setText(String.format("%s 此玩家發送給您一個傳送邀請! (邀請將於 5 秒鐘後失效)", p));
					
				TextComponent targetAccept = new TextComponent("§a接受");
				{
					
					targetAccept.setBold(true);
					targetAccept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "tpaccept"));
					targetAccept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§a接受傳送請求").create()));
					
				}
				TextComponent targetDeny = new TextComponent("§c拒絕");
				{
					
					targetDeny.setBold(true);
					targetDeny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "tpdeny"));
					targetDeny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§c拒絕傳送請求").create()));
					
				}
				
				tpInvite.addExtra(targetAccept);
				tpInvite.addExtra(targetDeny);
				
				p.sendMessage(tpInvite);
				
				cooldown.CooldownSet(p.getName() + "_傳送請求發送延遲", 5);
				teleport.put(target, p);
				
			}
			
		}
	}
}
