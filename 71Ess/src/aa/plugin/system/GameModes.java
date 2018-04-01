package aa.plugin.system;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
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
						
							inv.setItem(i, createItem.createItems(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
						}
					
						inv.setItem(4, createItem.createItems(Material.ITEM_FRAME, 0, " ", ""));
					
						//第三排
						inv.setItem(19, createItem.createItems(Material.DIAMOND_PICKAXE, 0, "§a生存模式", ""));
						inv.setItem(21, createItem.createItems(Material.GRASS, 0, "§d創造模式", ""));
						inv.setItem(23, createItem.createItems(Material.PAPER, 0, "§5冒險模式", ""));
						inv.setItem(25, createItem.createItems(Material.BARRIER, 0, "§c觀察模式", ""));
					
						//第四排
						inv.setItem(35, createItem.createItems(Material.REDSTONE_BLOCK, 0, "§4警告", "切換後請自行關閉選單"));
					
						for(int i = 36; i <= 44; i++) {
							
							inv.setItem(i, createItem.createItems(Material.STAINED_GLASS_PANE, 15, " ", ""));
						
						}
					
						p.openInventory(inv);
					}
					GameMode[] gm = { GameMode.SURVIVAL, GameMode.CREATIVE, GameMode.ADVENTURE, GameMode.SPECTATOR };
					int mode = Integer.parseInt(args[0]);
				
					String[] gamemode = { "已將您的遊戲模式更改為 (生存模式)", "已將您的遊戲模式更改為 (創造模式)", "已將您的遊戲模式更改為 (冒險模式)", "已將您的遊戲模式更改為 (觀察模式)" };
				
					if (args.length == 1)
					{
						p.setGameMode(gm[mode]);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.title + gamemode[mode]));
						return false;
					}
					if (args.length == 2)
					{
						Player target = Bukkit.getServer().getPlayer(args[1]);
					
						target.setGameMode(gm[mode]);
						target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.title + gamemode[mode]));
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
					
					inv.setItem(i, createItem.createItems(Material.STAINED_GLASS_PANE, 15, " ", ""));
					
				}
				
				//第三排
				inv.setItem(19, createItem.createItems(Material.DIAMOND_PICKAXE, 0, "§a生存模式", "§0" + clickedUUID));
				inv.setItem(21, createItem.createItems(Material.GRASS, 0, "§d創造模式", "§0" + clickedUUID));
				inv.setItem(23, createItem.createItems(Material.PAPER, 0, "§5冒險模式", "§0" + clickedUUID));	
				inv.setItem(25, createItem.createItems(Material.BARRIER, 0, "§c觀察模式", "§0" + clickedUUID));
				
				//第四排
				inv.setItem(35, createItem.createItems(Material.REDSTONE_BLOCK, 0, "§4警告", "切換遊戲模式後請自行關閉選單"));
				
				//第五排
				for(int i = 36; i <= 44; i++) {
					
					inv.setItem(i, createItem.createItems(Material.STAINED_GLASS_PANE, 15, " ", ""));
					
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
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a生存模式"))
			{
				if (!(p.getGameMode() == org.bukkit.GameMode.SURVIVAL))
				{
					p.setGameMode(org.bukkit.GameMode.SURVIVAL);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SURVIVAL));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d創造模式"))
			{
				if (!(p.getGameMode() == org.bukkit.GameMode.CREATIVE))
				{
					p.setGameMode(org.bukkit.GameMode.CREATIVE);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_CREATIVE));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5冒險模式"))
			{
				if (!(p.getGameMode() == org.bukkit.GameMode.ADVENTURE))
				{
					p.setGameMode(org.bukkit.GameMode.ADVENTURE);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_ADVENTURE));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c觀察模式"))
			{
				if (!(p.getGameMode() == org.bukkit.GameMode.SPECTATOR))
				{
					p.setGameMode(org.bukkit.GameMode.SPECTATOR);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SPECTATOR));
					return;
				}
			}
		}
		
		if (e.getInventory().getName().contains("遊戲模式選單 (對玩家)"))
		{
			Player p = (Player) e.getWhoClicked();
			Player target = Bukkit.getPlayer(UUID.fromString(clickedUUID));

			e.setCancelled(true);
			
			if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a生存模式") && e.getCurrentItem().getItemMeta().getLore().get(0).equals("§0" + clickedUUID))
			{
				if (!(target.getGameMode() == org.bukkit.GameMode.SURVIVAL)) 
				{
					target.setGameMode(org.bukkit.GameMode.SURVIVAL);
					target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SURVIVAL_HASBEENCHANGE));
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SURVIVAL_TOPLAYER));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d創造模式") && e.getCurrentItem().getItemMeta().getLore().get(0).equals("§0" + clickedUUID))
			{
				if (!(target.getGameMode() == org.bukkit.GameMode.CREATIVE))
				{
					target.setGameMode(org.bukkit.GameMode.CREATIVE);
					target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_CREATIVE_HASBEENCHANGE));
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_CREATIVE_TOPLAYER));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5冒險模式") && e.getCurrentItem().getItemMeta().getLore().get(0).equals("§0" + clickedUUID))
			{
				if (!(target.getGameMode() == org.bukkit.GameMode.ADVENTURE))
				{
					target.setGameMode(org.bukkit.GameMode.ADVENTURE);
					target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_ADVENTURE_HASBEENCHANGE));
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_ADVENTURE_TOPLAYER));
					return;
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c觀察模式") && e.getCurrentItem().getItemMeta().getLore().get(0).equals("§0" + clickedUUID))
			{
				if (!(target.getGameMode() == org.bukkit.GameMode.SPECTATOR))
				{
					target.setGameMode(org.bukkit.GameMode.SPECTATOR);
					target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SPECTATOR_HASBEENCHANGE));
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GAMEMODE_SPECTATOR_TOPLAYER));
					return;
				}
			}
		}
	}
	
}
