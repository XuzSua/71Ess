package aa.plugin.system;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
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
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class GameModes implements CommandExecutor, Listener {
	
	File file = new File("plugins/71ess/Message.yml");	
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
			if (sender instanceof Player)
			{
				Player p = (Player) sender;
				if (sender.hasPermission("71ess.gamemode"))
				{
					if (args.length == 0)
					{
						Inventory inv = Bukkit.createInventory(null, 9*5, "遊戲模式選單 (對自己)");
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 4.0F, 4.0F);
					
						//第一排
						for(int i = 0; i <= 8; i++) {
						
							inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
						}
					
						inv.setItem(4, createItem.createItemsForGUI(Material.ITEM_FRAME, 0, " ", ""));
					
						//第三排
						inv.setItem(19, createItem.createItemsForGUI(Material.DIAMOND_PICKAXE, 0, "§a生存模式", ""));
						inv.setItem(21, createItem.createItemsForGUI(Material.GRASS, 0, "§d創造模式", ""));
						inv.setItem(23, createItem.createItemsForGUI(Material.PAPER, 0, "§5冒險模式", ""));
						inv.setItem(25, createItem.createItemsForGUI(Material.BARRIER, 0, "§c觀察模式", ""));
					
						//第四排
						inv.setItem(35, createItem.createItemsForGUI(Material.REDSTONE_BLOCK, 0, "§4警告", "切換後請自行關閉選單"));
					
						for(int i = 36; i <= 44; i++) {
							
							inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
						}
					
						p.openInventory(inv);
						
						return false;
						
					}
					
					GameMode[] gm = { GameMode.SURVIVAL, GameMode.CREATIVE, GameMode.ADVENTURE, GameMode.SPECTATOR };
					int mode = Integer.parseInt(args[0]);
					String[] gamemode = { "生存模式","創造模式","冒險模式","觀察者模式" };		
				
					if (args.length == 1)
					{				

						
						p.setGameMode(gm[mode]);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(MessageManager.GAMEMODE_CHANGE,gamemode[mode])));
						return false;
					}
					if (args.length == 2)
					{
						Player target = Bukkit.getServer().getPlayer(args[1]);
					
						target.setGameMode(gm[mode]);
						target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(MessageManager.GAMEMODE_HASBEENCHANGE,gamemode[mode])));
						return false;
					}
				} else {
					p.sendMessage(MessageManager.HAVENOPERMISSION);
				}
			} else {
				sender.sendMessage("此指令限定玩家使用");
			}
		}
		return false;
	}
	
	String clickedUUID; 
	
	@EventHandler
	public void ClickPlayerInventory(PlayerInteractEntityEvent e)
	{
		Player clicker = e.getPlayer();
		if (e.getRightClicked() instanceof Player)
		{
			if (clicker.isSneaking() && clicker.hasPermission("71ess.gamemode"))
			{
				
				clickedUUID = e.getRightClicked().getUniqueId().toString();
				
				Inventory inv = Bukkit.createInventory(null, 9*5, "遊戲模式選單 (對玩家)");
				clicker.playSound(clicker.getLocation(), Sound.BLOCK_NOTE_PLING, 4.0F, 4.0F);
				
				//第一排
				for(int i = 0; i <= 8; i++) {
					
					inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
					
				}
				inv.setItem(4, createItem.createItemsForGUI(Material.ITEM_FRAME, 0, " ", ""));
				
				//第三排
				inv.setItem(19, createItem.createItemsForGUI(Material.DIAMOND_PICKAXE, 0, "§a生存模式", "§0" + clickedUUID));
				inv.setItem(21, createItem.createItemsForGUI(Material.GRASS, 0, "§d創造模式", "§0" + clickedUUID));
				inv.setItem(23, createItem.createItemsForGUI(Material.PAPER, 0, "§5冒險模式", "§0" + clickedUUID));	
				inv.setItem(25, createItem.createItemsForGUI(Material.BARRIER, 0, "§c觀察模式", "§0" + clickedUUID));
				
				//第四排
				inv.setItem(35, createItem.createItemsForGUI(Material.REDSTONE_BLOCK, 0, "§4警告", "切換遊戲模式後請自行關閉選單"));
				
				//第五排
				for(int i = 36; i <= 44; i++) {
					
					inv.setItem(i, createItem.createItemsForGUI(Material.STAINED_GLASS_PANE, 15, " ", ""));
					
				}
				
				clicker.openInventory(inv);
			}
		}
	}
	
	//判斷使用者點擊物品 並且作出相對回應
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if (e.getInventory().getName().contains("遊戲模式選單 (對自己)"))
		{
			e.setCancelled(true);
			Player p = (Player) e.getWhoClicked();
			
			Map<String,GameMode> map = new HashMap<String,GameMode>();
			
			map.put("生存模式", GameMode.SURVIVAL);
			map.put("創造模式", GameMode.CREATIVE);
			map.put("冒險模式", GameMode.ADVENTURE);
			map.put("觀察模式", GameMode.SPECTATOR);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			String action = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			
			p.setGameMode(map.get(action));
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(MessageManager.GAMEMODE_CHANGE, action)));
			
		}
		
		if (e.getInventory().getName().contains("遊戲模式選單 (對玩家)"))
		{
			e.setCancelled(true);
			Player p = (Player) e.getWhoClicked();
			Player target = Bukkit.getPlayer(UUID.fromString(clickedUUID));

			e.setCancelled(true);
			
			
			Map<String, GameMode> map = new HashMap<String, GameMode>();
			
			map.put("生存模式", GameMode.SURVIVAL);
			map.put("創造模式", GameMode.CREATIVE);
			map.put("冒險模式", GameMode.ADVENTURE);
			map.put("觀察模式", GameMode.SPECTATOR);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			if (!(e.getCurrentItem().getItemMeta().getLore().get(0) == ChatColor.stripColor(clickedUUID))) return;
			
			String action = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			
			target.setGameMode(map.get(action));
			target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(MessageManager.GAMEMODE_HASBEENCHANGE,action)));
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.format(MessageManager.GAMEMODE_TOPLAYER, action)));
			
		}
	}
	
}
