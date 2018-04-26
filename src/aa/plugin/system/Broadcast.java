package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("71ess.broadcast"))
			{
				if ((cmd.getName().equalsIgnoreCase("broadcast")) || (cmd.getName().equalsIgnoreCase("bc")))
				{
					
					if (args.length == 0)
					{
						
						sender.sendMessage("請輸入正確指令 /broadcast <訊息>");
						return false;
					}
					if (args.length >= 1)
					{
						
						String text = "";
	                    for (int i = 0; i < args.length; i++)
	                    {
	                    	text += args[i] + " ";
	                    }
                          
                        
						for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
						{
							onlinePlayer.sendMessage("");
							onlinePlayer.sendMessage("§7[§a§l管理員廣播§7] §f" + text.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
							onlinePlayer.sendMessage("");
						}
						
					}
					
				}
				
				
			}
		}else {
			
			if ((cmd.getName().equalsIgnoreCase("broadcast")) || (cmd.getName().equalsIgnoreCase("bc")))
			{
			
				if (args.length == 0)
				{
					
					sender.sendMessage("請輸入正確指令 /broadcast <訊息>");
					return false;
				}
				if (args.length >= 1)
				{
					
					String text = "";
                    for (int i = 0; i < args.length; i++)
                    {
                    	text += args[i] + " ";
                    }
					
					for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
					{
						onlinePlayer.sendMessage("");
						onlinePlayer.sendMessage("§7[§c§l伺服器後台§7] §f" + text.replaceAll("(&([a-f0-9]))", "\u00A7$2"));
						onlinePlayer.sendMessage("");
					}
					
				}
				
			}
			
		}
		return false;
	}

}
