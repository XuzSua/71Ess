package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import aa.plugin.main.MessageManager;

public class Back implements CommandExecutor, Listener
{

	static Map<Player, Location> backpoint = new HashMap<>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		backpoint.put(player, player.getLocation());
		player.sendMessage(MessageManager.AUTORESPAWN_DEATHMESSAGE);
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event)
	{
		Player player = event.getPlayer();
		backpoint.put(player, player.getLocation());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("71ess.back"))
			{
				if (backpoint.containsKey(player))
				{
					player.teleport(backpoint.get(player));
					player.sendMessage("已將您傳送回上一個點");
					
					backpoint.remove(player);
					
				} else {
				
					player.sendMessage("您沒有上一個傳送點可供傳送");
				}
			}
		}
		return false;
	}

}
