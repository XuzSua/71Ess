package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import aa.plugin.main.MessageManager;
import aa.plugin.main.GUIs.TeleportGUI;

public class Teleport implements CommandExecutor
{	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if (sender.hasPermission("71ess.teleport"))
			{
				if (args.length == 0) TeleportGUI.teleportGUI(p);
				
				//sender tp to target
				if (args.length == 1)
				{
					
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null)
					{
						p.sendMessage(String.format(MessageManager.TELEPORT_TARGETNOTFOUND, args[0]));
						return true;
					}
					p.teleport(target.getLocation());
					p.sendMessage(String.format(MessageManager.TELEPORT_TOPLAYER, args[0]));
					return false;
					
				}
				
				//player tp to player
				if (args.length == 2)
				{
					
					Player target1 = Bukkit.getServer().getPlayer(args[0]);
					
					if (target1 == null)
					{
						p.sendMessage(String.format(MessageManager.TELEPORT_TARGETNOTFOUND, args[0]));
						return true;
					}
					Player target2 = Bukkit.getServer().getPlayer(args[1]);
					if (target2 == null)
					{
						p.sendMessage(String.format(MessageManager.TELEPORT_TARGETNOTFOUND, args[1]));
						return true;
					}
					
					target1.teleport(target2.getLocation());
					p.sendMessage(String.format(MessageManager.TELEPORT_PLAYERTOPLAYER, args[1]));
					target1.sendMessage(String.format(MessageManager.TELEPORT_PLAYERHASBEENTP, args[1]));
					
				}
			} else {
				p.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		}
		return false;
	}

}
