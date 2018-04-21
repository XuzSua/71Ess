package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import aa.plugin.main.Main;
import aa.plugin.main.GUIs.TpaGUI;


class Invite{
	
	Player inviter;
	Player target;
	
}

public class Tpa implements CommandExecutor
{

	Map<Player,Invite> map = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (args.length == 0)
		{
			Player player = (Player) sender;
			TpaGUI.teleportGUI(player);
			return false;
		}
		
		if(args[0].equals("yes")) {
			
			Player target = (Player) sender;
			
			//如果邀請不存在的話
			if(!map.containsKey(target)) {
				
				target.sendMessage("邀請不存在。");
				return false;
				
			}
			
			Invite inv = map.get(target);
			
			Player inviter = inv.inviter;

			inviter.sendMessage(target.getName() + " §a§l接受§f你的傳送請求");
			
			inviter.teleport(target.getLocation());
			
			map.remove(target);
			
		}else if(args[0].equals("no")) {
			
			Player target = (Player) sender;
			
			//如果邀請不存在的話
			if(!map.containsKey(target)) {
				
				target.sendMessage("邀請不存在。");
				return false;
				
			}
			
			Invite inv = map.get(target);
			
			Player inviter = inv.inviter;			
			
			inviter.sendMessage(target.getName() + " §c§l拒絕§f你的傳送請求");
			
			map.remove(target);
			
		}else {
			
			Player target = Bukkit.getServer().getPlayer(args[0]);
			Player inviter = (Player)sender;
			
			if(map.containsKey(target)) {
				
				inviter.sendMessage("邀請已存在，請等待回覆。");
				return false;
			}
			
			Invite inv = new Invite();
			
			inv.inviter = inviter;
			inv.target = target;
			
			map.put(target, inv);
			
			target.sendMessage("=================================================================");
			target.sendMessage("");
			target.sendMessage(String.format("§f你接到了一封來自於 §6§l%s §f的傳送請求", inviter.getName()));
			target.sendMessage("");
			target.sendMessage("§a§l接受§f請輸入/tpa yes ， §c§l拒絕§f請輸入/tpa no");
			target.sendMessage("");
			target.sendMessage("§f此封邀請將在§a 1 分鐘§f後§4§l自動刪除");
			target.sendMessage("");
			target.sendMessage("=================================================================");
			
			if (!(map.containsKey(target)))
			{
				new BukkitRunnable() {
					
					public void run() {
						
						inviter.sendMessage("邀請已被自動刪除。");
						target.sendMessage("邀請已被自動刪除。");
						map.remove(target);
						
					}
					
				}.runTaskLater(Main.plugin, 20*60);
			}
			
		}
		
		return false;
	}

}
