package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

public class Tell implements CommandExecutor
{

	Map<Player, Player> lastSentMsg = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			
			Player player = (Player) sender;
			if (player.hasPermission("71ess.tell"))
			{
				Player target = Bukkit.getServer().getPlayer(args[0]);
				
				if (cmd.getName().equalsIgnoreCase("tell"))
				{
					if (target != null) 
					{
						String msg = "";
						for (int i = 1 ; i != args.length ; i++)
						{
							msg += args[i] + " ";
						}
							
						target.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §d" + msg);
						player.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §d" + msg);
							
						lastSentMsg.put(player, target);
					} else {
							
						player.sendMessage(MessageManager.TELL_PLAYERNULL);
							
					}
					return false;
				}
				if (cmd.getName().equalsIgnoreCase("r"))
				{
					if (target != null) 
					{
						String msg = "";
						for (int i = 1 ; i != args.length ; i++)
						{
							msg += args[i] + " ";
						}
						
						lastSentMsg.get(target).sendMessage("§6" + player.getName() + " §e--> §6" + lastSentMsg.get(target) + " §7" + msg);
						player.sendMessage("§6" + player.getName() + " §e--> §6" + lastSentMsg.get(target) + " §7" + msg);
					} else {
						
						player.sendMessage(MessageManager.TELL_PLAYERNULL);
					}
				}
			}
		
		} else {
			
			sender.sendMessage("此指令只限定玩家使用");
			
		}
		
		
		return false;
	}

}
