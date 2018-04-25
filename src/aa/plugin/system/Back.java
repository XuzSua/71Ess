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

public class Back implements CommandExecutor, Listener
{

	static Map<Player, Location> backpoint = new HashMap<>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		backpoint.put(player, player.getLocation());
		player.sendMessage("您已死亡, 可以透過 /back 回到您的死亡點");
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event)
	{
		Player player = event.getPlayer();
		backpoint.put(player, player.getLocation());
		player.sendMessage("您已傳送, 可以透過 /back 回到您的上一個傳送點");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("71ess.back"))
			{
				if (!(backpoint.containsKey(player)))
				{
					player.sendMessage("您沒有上一個傳送點可供傳送");
					return false;
				}else if (backpoint.containsKey(player))
				{
					Location loc = backpoint.get(player);
					player.teleport(loc);
					player.sendMessage("已將您傳送回上一個點");
					return false;
				}
			}
		}
		return false;
	}

}
