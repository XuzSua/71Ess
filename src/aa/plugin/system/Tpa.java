package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import aa.plugin.function.cooldown;
import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;
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
		
		if(args[0].equals("accept")) {
			
			Player target = (Player) sender;
			
			//如果邀請不存在的話
			if(!map.containsKey(target)) {
				
				target.sendMessage("邀請不存在。");
				return false;
				
			}
			
			Invite inv = map.get(target);
			
			Player inviter = inv.inviter;

			inviter.sendMessage(target.getName() + " 接受了你的傳送請求");
			
			inviter.teleport(target.getLocation());
			
			map.remove(target);
			
		}else if(args[0].equals("denied")) {
			
			Player target = (Player) sender;
			
			//如果邀請不存在的話
			if(!map.containsKey(target)) {
				
				target.sendMessage("邀請不存在。");
				return false;
				
			}
			
			Invite inv = map.get(target);
			
			Player inviter = inv.inviter;			
			
			inviter.sendMessage(target.getName() + " 拒絕了你的傳送請求");
			
			map.remove(target);
			
		}else {
			
			Player player = (Player) sender;
			if (!(cooldown.CooldownCheck(player.getName() + "_發送傳送邀請冷卻")))
			{
				player.sendMessage(MessageManager.TPA_INVITE_COOLDOWN);
				return false;
			}
			
			Player target = Bukkit.getPlayer(args[0]);
			Player inviter = (Player)sender;
			
			if(map.containsKey(target)) {
				
				inviter.sendMessage("邀請已存在，請等待回覆。");
				
			}
			
			Invite inv = new Invite();
			
			inv.inviter = inviter;
			inv.target = target;
			
			map.put(target, inv);
			
			target.sendMessage(String.format("你接到了一封來自於 %s 的傳送請求",inviter.getName()));
			target.sendMessage("接受請輸入/tpa accept ， 不接受請輸入/tpa denied");
			target.sendMessage("此封邀請將在1分鐘後自動刪除");
			
			if (map.containsKey(target))
			{
				new BukkitRunnable() {
					
					public void run() {
						
						inviter.sendMessage("邀請已被自動刪除。");
						map.remove(target);
						
					}
					
				}.runTaskLater(Main.plugin, 20*60);
			}
			
		}
		
		return false;
	}

}
