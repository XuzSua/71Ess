package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class Fly implements CommandExecutor
{

	static List<Player> playerFlyMods = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("71ess.fly")) {
			if (args.length == 0)
			{
				if (!(playerFlyMods.contains(p))) {
					p.setAllowFlight(true);
					playerFlyMods.add(p);
					sendActionBar(p, MessageManager.FLY_SET_TRUE);
				} else {
					p.setAllowFlight(false);
					playerFlyMods.remove(p);
					sendActionBar(p, MessageManager.FLY_SET_FALSE);
				}
			}
			if (args.length == 1)
			{
				Player target = Bukkit.getServer().getPlayer(args[0]);
				
				if (!(playerFlyMods.contains(target))) {
					target.setAllowFlight(true);
					playerFlyMods.add(p);
					sendActionBar(target, MessageManager.FLY_SET_TRUE);
				} else {
					target.setAllowFlight(false);
					playerFlyMods.remove(p);
					sendActionBar(target, MessageManager.FLY_SET_FALSE);
				}
			}
		} else {
			p.sendMessage(MessageManager.HAVENOPERMISSION);
		}
		return false;
	}
	
	public void sendActionBar(Player player,String str) {
		
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(str).create());
		
	}

}
