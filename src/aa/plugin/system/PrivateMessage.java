package aa.plugin.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

class MessageSave{
	
	Player player;
	
	String message;
	
}

public class PrivateMessage implements CommandExecutor {

	static Map<Player, MessageSave> lastsent = new HashMap<>();
	
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
						
						String msg = String.join("", Arrays.copyOfRange(args, 1, args.length));

						MessageSave ms = new MessageSave();
						
						ms.player = target;
						ms.message = msg;
						
						lastsent.put(player, ms);
						
						target.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §7" + msg);
						player.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §7" + msg);
						
						target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 4.0F, 4.0F);
						player.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 4.0F, 4.0F);
						
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
				
				MessageSave ms = lastsent.get(player);
				
				Player target = ms.player;
				
//				lastsent.put(player, target);
	
				String msg = ms.message;
				
				target.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §7" + msg);
				player.sendMessage("§6" + player.getName() + " §e--> §6" + target.getName() + " §7" + msg);
				
				target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 4.0F, 4.0F);
				player.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 4.0F, 4.0F);
			}
			
		}
		return false;
	}

}
