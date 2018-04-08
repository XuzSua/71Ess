package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PingDetect extends BukkitRunnable implements CommandExecutor
{

	Main plugin = Main.plugin;
	
	@Override
	public void run()
	{		
		for(Player player : Bukkit.getOnlinePlayers())
		{
			
			int ping = ((CraftPlayer)player).getHandle().ping;
			
			if(ping > 200)
			{
				
				player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGERROR, ping)));
				
			} else {
				
				player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGNORMAL, ping)));
				
			}
			
		}
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if (args.length == 0)
			{
				
				int ping = ((CraftPlayer)player).getHandle().ping;
				
				if(ping > 200)
				{
					
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGERROR, ping)));
					
				} else {
					
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGNORMAL, ping)));
					
				}
				
			}
			if (player.hasPermission("71ess.pingother"))
			{
				
				if (args.length == 1)
				{
					
					Player target = Bukkit.getServer().getPlayer(args[0]);
					
					int ping = ((CraftPlayer)target).getHandle().ping;
					
					if(ping > 200)
					{
						
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGERROR, ping)));
						
					} else {
						
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(String.format(MessageManager.PINGNORMAL, ping)));
						
					}
					
				}
				
			}
		}
		return false;
	}

}
