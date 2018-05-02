package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import aa.plugin.function.cooldown;
import aa.plugin.main.MessageManager;

public class Afk implements CommandExecutor, Listener
{

	static List<UUID> afkmod = new ArrayList<>();
	
	@EventHandler
	public void onEntityDamage (EntityDamageEvent event)
	{
		if (event.getEntity() instanceof Player)
		{
			Player player = (Player) event.getEntity();
			
			if (afkmod.contains(player.getUniqueId()))
			{
				
				event.setCancelled(true);
				
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		
		if (afkmod.contains(player.getUniqueId()))
		{
			afkmod.remove(player.getUniqueId());
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		
		if (afkmod.contains(player.getUniqueId()))
		{
			afkmod.remove(player.getUniqueId());
		}
		
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		
		if (afkmod.contains(player.getUniqueId()))
		{
			afkmod.remove(player.getUniqueId());
			player.sendMessage(MessageManager.AFK_DISABLE);
			for (Player onlineplayer : Bukkit.getServer().getOnlinePlayers())
			{
				onlineplayer.sendMessage(String.format("§6§l%s §c離開§f掛機模式!", player.getName()));
			}
		}
		
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			
			Player player = (Player) sender;
			if (player.hasPermission("71ess.afk"))
			{
				if (!(cooldown.CooldownCheck(player.getName() + "_掛機模式")))
				{
					player.sendMessage(MessageManager.AFK_COOLDOWN);
					return false;
				}
				if (!(afkmod.contains(player.getUniqueId())))
				{
					afkmod.add(player.getUniqueId());
					player.sendMessage(MessageManager.AFK_ENABLE);
					for (Player onlineplayer : Bukkit.getServer().getOnlinePlayers())
					{
						onlineplayer.sendMessage(String.format("§6§l%s §a進入§f掛機模式!", player.getName()));
					}
					cooldown.CooldownSet(player.getName() + "_掛機模式", 5);
					return false;
				}
				if (afkmod.contains(player.getUniqueId()))
				{
					afkmod.remove(player.getUniqueId());
					player.sendMessage(MessageManager.AFK_DISABLE);
					for (Player onlineplayer : Bukkit.getServer().getOnlinePlayers())
					{
						onlineplayer.sendMessage(String.format("§6§l%s §c離開§f掛機模式!", player.getName()));
					}
					cooldown.CooldownSet(player.getName() + "_掛機模式", 5);
					return false;
				}
			}
				
		}
		return false;
	}

}
