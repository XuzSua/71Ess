package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

public class PrivateMessage implements CommandExecutor {

	Map<Player, Player> lastsent = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if (!(player.hasPermission("71ess.privatemessage")))
			{
				player.sendMessage(MessageManager.HAVENOPERMISSION);
				return false;
			}
			
			if (cmd.getName().equalsIgnoreCase("msg"))
			{
				if (args.length == 0 || args.length == 1)
				{
					player.sendMessage(MessageManager.TELL_ERRORCOMMAND);
					return false;
				}
				
				if (args.length >= 2)
				{
					Player target = Bukkit.getServer().getPlayer(args[0]);
					
					if (target == null)
					{
						
						player.sendMessage(MessageManager.TELL_PLAYERNULL);
						
					} else {
						
						lastsent.put(player, target);
						
						String msg = "";
						for (int i = 1 ; i != args.length ; i++)
						{
							msg += args[i] + " ";
						}
						
						target.sendMessage("§6" + player.getName() + " §e--> §6" + lastsent.get(target).getName() + " §7" + msg);
						player.sendMessage("§6" + player.getName() + " §e--> §6" + lastsent.get(target).getName() + " §7" + msg);
						
					}
					
				}
			}
			if (cmd.getName().equalsIgnoreCase("msgr"))
			{
							
				if (!(lastsent.containsKey(player)))
				{
					player.sendMessage(MessageManager.TELL_PLAYERNULL);
					return false;
				}
				
				Player target = lastsent.get(player);
				lastsent.put(player, target);
	
				String msg = "";
				for (int i = 1 ; i != args.length ; i++)
				{
					msg += args[i] + " ";
				}
				
				lastsent.get(target).sendMessage("§6" + player.getName() + " §e--> §6" + lastsent.get(target).getName() + " §7" + msg);
				player.sendMessage("§6" + player.getName() + " §e--> §6" + lastsent.get(target).getName() + " §7" + msg);
				
			}
			
		}
		return false;
	}

}
