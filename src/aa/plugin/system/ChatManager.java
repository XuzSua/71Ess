package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

public class ChatManager implements CommandExecutor
{
	//指令部分
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			
			Player player = (Player) sender;
			if (player.hasPermission("71ess.chat"))
			{
				
				switch(args[0])
				{
				
					case "clear":
						
						for (int i = 0 ; i < 100 ; i++)
						{
							
							Bukkit.getServer().broadcastMessage("");
							
						}
						
						Bukkit.getServer().broadcastMessage(String.format(MessageManager.CHAT_CLEAR, player.getName()));
						
						break;
						
					default:
						
						
						break;
				
				}
				
			} else {
				
				player.sendMessage(MessageManager.HAVENOPERMISSION);
				
			}
		}
		
		return false;
	}

}
