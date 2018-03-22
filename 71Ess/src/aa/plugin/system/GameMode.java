package aa.plugin.system;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import aa.plugin.function.createItem;
import aa.plugin.main.MessageManager;

public class GameMode implements CommandExecutor, Listener {
	
	File file = new File("plugins/71ess/Message.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	Map<Player,Player> right_click = new HashMap<Player,Player>();
	
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
					Inventory inv = Bukkit.createInventory(null, 9*5, "遊戲模式選單 (對自己)");
					
					//第一排
					inv.setItem(0, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(1, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(2, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(3, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(4, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(5, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(6, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(7, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(8, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					
					//第三排
					inv.setItem(19, createItem.createItem(Material.DIAMOND_PICKAXE, 0, "§a生存模式", ""));
					inv.setItem(21, createItem.createItem(Material.GRASS, 0, "§d創造模式", ""));
					inv.setItem(23, createItem.createItem(Material.PAPER, 0, "§5冒險模式", ""));
					inv.setItem(25, createItem.createItem(Material.BARRIER, 0, "§c觀察模式", ""));
					
					//第四排
					inv.setItem(35, createItem.createItem(Material.REDSTONE_BLOCK, 0, "§4警告", "切換遊戲模式後請自行關閉選單"));
					
					//第五排
					inv.setItem(36, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(37, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(38, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(39, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(40, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(41, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(42, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(43, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					inv.setItem(44, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
					
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
	public void ClickPlayerInventory(PlayerInteractEntityEvent e)
	{
		Player clicker = e.getPlayer();
		Player clicked = (Player) e.getRightClicked();
		
		if (e.getRightClicked() instanceof Player)
		{
			if (clicker.isSneaking() && clicker.hasPermission("71ess.gamemode"))
			{
				
				right_click.put(e.getPlayer(), clicked);
				
				Inventory inv = Bukkit.createInventory(null, 9*5, "遊戲模式選單 (對玩家)");
				
				//第一排
				inv.setItem(0, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(1, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(2, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(3, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(4, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(5, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(6, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(7, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(8, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				
				//第三排
				inv.setItem(19, createItem.createItem(Material.DIAMOND_PICKAXE, 0, "§a生存模式", ""));
				inv.setItem(21, createItem.createItem(Material.GRASS, 0, "§d創造模式", ""));
				inv.setItem(23, createItem.createItem(Material.PAPER, 0, "§5冒險模式", ""));
				inv.setItem(25, createItem.createItem(Material.BARRIER, 0, "§c觀察模式", ""));
				
				//第四排
				inv.setItem(35, createItem.createItem(Material.REDSTONE_BLOCK, 0, "§4警告", "切換遊戲模式後請自行關閉選單"));
				
				//第五排
				inv.setItem(36, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(37, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(38, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(39, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(40, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(41, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(42, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(43, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				inv.setItem(44, createItem.createItem(Material.STAINED_GLASS_PANE, 0, " ", ""));
				
				clicker.openInventory(inv);
			}
		}
	}
	
	//判斷使用者點擊物品 並且作出相對回應(對自己)
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("遊戲模式選單 (對自己)"))
		{
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
			{
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a生存模式"))
			{
				p.setGameMode(org.bukkit.GameMode.SURVIVAL);
				p.sendMessage(MessageManager.GAMEMODE_SRUVIVAL);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d創造模式"))
			{
				p.setGameMode(org.bukkit.GameMode.CREATIVE);
				p.sendMessage(MessageManager.GAMEMODE_CREATIVE);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5冒險模式"))
			{
				p.setGameMode(org.bukkit.GameMode.ADVENTURE);
				p.sendMessage(MessageManager.GAMEMODE_ADVENTURE);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c觀察模式"))
			{
				p.setGameMode(org.bukkit.GameMode.SPECTATOR);
				p.sendMessage(MessageManager.GAMEMODE_SPECTATOR);
				return;
			}
		}
		
		if (e.getInventory().getName().contains("遊戲模式選單 (對玩家)"))
		{
			Player p = right_click.get((Player)e.getWhoClicked());
			e.setCancelled(true);
			
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
			{
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a生存模式"))
			{
				p.setGameMode(org.bukkit.GameMode.SURVIVAL);
				p.sendMessage(MessageManager.GAMEMODE_SRUVIVAL);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d創造模式"))
			{
				p.setGameMode(org.bukkit.GameMode.CREATIVE);
				p.sendMessage(MessageManager.GAMEMODE_CREATIVE);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5冒險模式"))
			{
				p.setGameMode(org.bukkit.GameMode.ADVENTURE);
				p.sendMessage(MessageManager.GAMEMODE_ADVENTURE);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c觀察模式"))
			{
				p.setGameMode(org.bukkit.GameMode.SPECTATOR);
				p.sendMessage(MessageManager.GAMEMODE_SPECTATOR);
				return;
			}
		}
	}
}