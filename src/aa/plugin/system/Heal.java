package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("你必須是玩家。");
			return false;
			
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("71ess.heal")) {
			
			player.sendMessage("不讓你用");
			return false;
			
		}
		
		if(args.length == 0) {
			
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			
			player.setFoodLevel(20);
			
			player.sendMessage("狀態回復完成");
			
		}
		
		if(args.length == 1) {
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target == null) {
				
				player.sendMessage("玩家不存在");
				return false;
				
			}
			
			target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			
			target.setFoodLevel(20);
			
			target.sendMessage("狀態回復完成");
			
			player.sendMessage("回復 " + target.getName() + " 的狀態完成");
			
		}
		
		return false;
	}
	
	

}
