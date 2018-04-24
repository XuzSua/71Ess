package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;

public class Heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("你必須是玩家。");
			return false;
			
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("71ess.heal")) {
			
			player.sendMessage(MessageManager.HAVENOPERMISSION);
			return false;
			
		}
		
		if(args.length == 0) {
			
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			
			player.setFoodLevel(20);
			
			player.sendMessage(String.format(MessageManager.HEAL_PLAYER, player.getName()));
			
		}
		
		if(args.length == 1) {
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target == null) {
				
				player.sendMessage(MessageManager.HEAL_PLAYERNOTFOUND);
				return false;
				
			}
			
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			
			target.setFoodLevel(20);
			
			target.sendMessage(String.format(MessageManager.HEAL_PLAYER, args[0]));
			
			player.sendMessage(String.format(MessageManager.HEAL_PLAYER, args[0]));
			
		}
		
		return false;
	}
	
	

}
