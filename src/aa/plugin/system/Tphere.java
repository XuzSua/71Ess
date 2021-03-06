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
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

class TPHereInvite {

	Player inviter;
	Player target;

}

public class Tphere implements CommandExecutor {

	Map<Player, TPHereInvite> map = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {

		if (sender instanceof Player)
		{
			Player checkpermission = (Player) sender;
			if (checkpermission.hasPermission("71ess.tphere"))
			{
				if (args.length == 0) {
					return false;
				}

				if (args[0].equals("yes")) {

					Player target = (Player) sender;

					// 如果邀請不存在的話
					if (!map.containsKey(target)) {

						target.sendMessage("邀請不存在。");
						return false;

					}

					TPHereInvite inv = map.get(target);

					Player inviter = inv.inviter;

					if (inviter == null) {

						target.sendMessage("邀請人已不存在。");
						return false;

					}

					inviter.sendMessage("§6§l" + target.getName() + " §a§l接受§f§l你的傳送請求");
					
					target.teleport(inviter.getLocation());

					map.remove(target);

				} else if (args[0].equals("no")) {

					Player target = (Player) sender;

					// 如果邀請不存在的話
					if (!map.containsKey(target)) {

						target.sendMessage("邀請不存在。");
						return false;

					}

					TPHereInvite inv = map.get(target);

					Player inviter = inv.inviter;

					if (inviter == null)
						return false;

					inviter.sendMessage("§6§l" + target.getName() + " §c§l拒絕§f§l你的傳送請求");

					map.remove(target);

				} else {

					Player target = Bukkit.getPlayer(args[0]);
					Player inviter = (Player) sender;

					if (target == null) {

						inviter.sendMessage("§c玩家不存在");
						return false;

					}

					if (map.containsKey(target)) {

						inviter.sendMessage("邀請已存在，請等待回覆。");
						return false;

					}

					TPHereInvite inv = new TPHereInvite();

					inv.inviter = inviter;
					inv.target = target;
					
					inviter.sendMessage("§f§l已發送傳送邀請給 §6§l" + target.getName());

					map.put(target, inv);

					TextComponent accept = new TextComponent("§f[§a§l接受§f]");

					accept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("點擊§a§l接受!").create()));
					accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tphere yes"));

					TextComponent nothing = new TextComponent(" ， ");
					
					TextComponent denied = new TextComponent("§f[§c§l拒絕§f]");

					denied.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("點擊§c§l拒絕!").create()));
					denied.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tphere no"));
					accept.addExtra(nothing);
					accept.addExtra(denied);
					
					target.sendMessage("=================================================================");
		            target.sendMessage("");
					target.sendMessage(String.format("§f§l你接到了一封來自於 §6§l%s §f§l的傳送請求", inviter.getName()));
					target.sendMessage("");
					target.spigot().sendMessage(accept);
					target.sendMessage("");
		            target.sendMessage("§f此封邀請將在§a 1 分鐘§f後§4§l自動刪除");
		            target.sendMessage("");
		            target.sendMessage("=================================================================");

					new BukkitRunnable() {

						public void run() {

							if(map.get(target) == null) return;
							
							inviter.sendMessage("邀請已被自動刪除。");
							map.remove(target);

						}

					}.runTaskLater(Main.plugin, 20 * 60);

				}
			} else {
				
				checkpermission.sendMessage(MessageManager.HAVENOPERMISSION);
			}
		}
		

		return false;
	}
}
