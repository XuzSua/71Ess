package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class God implements CommandExecutor, Listener
{

	public static List<String> godList = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (p.hasPermission("71ess.god"))
			{
				
				
				if (args.length == 0)
				{
					if (!godList.contains(p.getName()))
					{
						
						godList.add(p.getName());
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GOD_ENABLE));
						return false;
						
					}
					if (godList.contains(p.getName()))
					{
						
						godList.remove(p.getName());
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GOD_DISABLE));
						return false;
						
					}
				}
				if (args.length == 1)
				{
					
					Player target = Bukkit.getServer().getPlayer(args[0]);
					
					if (target.hasPermission("71ess.god"))
					{
						
						if (!godList.contains(target.getName()))
						{
							
							godList.add(target.getName());
							target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GOD_ENABLE));
							return false;
						}
						if (godList.contains(target.getName()))
						{
							
							godList.remove(target.getName());
							target.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.GOD_DISABLE));
							return false;
						}
						
					} else {
						
						p.sendMessage(MessageManager.HAVENOPERMISSION);
						
					}
					
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onEntityDamage (EntityDamageEvent event)
	{
		if (event.getEntity() instanceof Player)
		{
			Player p = (Player) event.getEntity();
			
			if (godList.contains(p.getName()))
			{
				
				event.setCancelled(true);
				
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Player p = event.getPlayer();
		
		if (godList.contains(p.getName()))
		{
			godList.remove(p.getName());
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event)
	{
		Player p = event.getPlayer();
		
		if (godList.contains(p.getName()))
		{
			godList.remove(p.getName());
		}
		
	}
}
