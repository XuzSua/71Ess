package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;
import aa.plugin.main.GUIs.TimeGUI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Time implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		Player p = (Player) sender;
		if (sender instanceof Player)
		{
			if (p.hasPermission("71ess.time"))
			{
				if (args.length == 0) TimeGUI.Time(p);
				
				if (args.length == 1)
				{
					switch (args[0])
					{
						case "day":
							
							p.getLocation().getWorld().setTime(1000);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_DAY));
							
							break;
						
						case "night":
							
							p.getLocation().getWorld().setTime(16000);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_NIGHT));
							
							break;
							
						default:
							
							sender.sendMessage("====================================");
							sender.sendMessage("/time day 將玩家所處世界更改為早上");
							sender.sendMessage("/time day <World> 將指定世界更改為早上");
							sender.sendMessage("/time night 將玩家所處世界更改為晚上");
							sender.sendMessage("/time night <World> 將指定世界更改為晚上");
							sender.sendMessage("====================================");
							
							break;
					}
				}
				if (args.length == 2)
				{
					World w = Bukkit.getServer().getWorld(args[1]);
					
					if (args[0].equals("day"))
					{
						
						w.setTime(1000);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_DAY));
						
					}
					if (args[0].equals("night"))
					{
						
						w.setTime(16000);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.TIME_NIGHT));
						
					}
				}
			} else {
				p.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		} else {
			sender.sendMessage("此指令限定玩家使用");
		}
		return false;
	}
	
}
			
