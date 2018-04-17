package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

public class Tpall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("71ess.tpall"))
			{
				for (Player target : Bukkit.getServer().getOnlinePlayers())
				{
					if (target != player)
					{
						target.teleport(player);
					}
				}
			} else {
				player.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		} 
		return false;
	}

}
