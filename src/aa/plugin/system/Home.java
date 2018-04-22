package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import aa.plugin.function.cooldown;
import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;

public class Home implements CommandExecutor {

	FileConfiguration home = Main.plugin.hc;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (args.length > 0) {

			if (args.length < 1) {
				sender.sendMessage(MessageManager.HOME_PUTNAME);
				return false;
			}

			if (sender instanceof Player) {

				Player p = (Player) sender;
				
				switch (args[0]) {

				case "set":

					if (!cooldown.CooldownCheck("_家點設置"))
					{
						 return false;
					}

					set(p, args[1]);

					break;

				case "tp":

					if (!cooldown.CooldownCheck(p.getName() + "_家點傳送")) {
						p.sendMessage(MessageManager.SPAWN_TP_COOLDOWN);
						return false;
					}

					tp(p, args[1]);

					break;

				default:
					System.out.println("未知的指令!");

				}

			} else {
				
				sender.sendMessage("====================================");
				sender.sendMessage("/home tp <home1/home2/home3> 傳送至home點");
				sender.sendMessage("/home set <home1/home2/home3> 設置home點");
				sender.sendMessage("====================================");
				
			}

		}

		return false;

	}

	public void set(Player player, String point) {

		if (point == null)
		{
			player.sendMessage("請指定home1, home2, home3");
			return;
		}
		
		List<String> list = new ArrayList<String>();

		list.add("home1");
		list.add("home2");
		list.add("home3");

		if (!list.contains(point)) {

			player.sendMessage("請指定home1, home2, home3");

			return;

		}

		home.set(player.getUniqueId() + String.format(".%s.location.world", point),
				player.getLocation().getWorld().getName());
		home.set(player.getUniqueId() + String.format(".%s.location.x", point), player.getLocation().getBlockX());
		home.set(player.getUniqueId() + String.format(".%s.location.y", point), player.getLocation().getBlockY());
		home.set(player.getUniqueId() + String.format(".%s.location.z", point), player.getLocation().getBlockZ());
		Main.plugin.SystemReLoad();

		cooldown.CooldownSet("_家點設置", 5);
		player.sendActionBar(String.format(MessageManager.HOME_SET_HOME, point));

	}

	public void tp(Player player, String point) {

		List<String> list = new ArrayList<String>();

		list.add("home1");
		list.add("home2");
		list.add("home3");

		if (!list.contains(point)) {

			player.sendMessage("請指定home1, home2, home3");

			return;

		}

		if (home.get(player.getUniqueId() + String.format(".%s", point)) == null) {

			player.sendActionBar(String.format(MessageManager.HOME_TP_POINT_NOT_EXIST, point));
			return;
		}

		World w1 = Bukkit.getWorld(home.getString(player.getUniqueId() + String.format(".%s.location.world", point)));
		int x1 = home.getInt(player.getUniqueId() + String.format(".%s.location.x", point));
		int y1 = home.getInt(player.getUniqueId() + String.format(".%s.location.y", point));
		int z1 = home.getInt(player.getUniqueId() + String.format(".%s.location.z", point));

		Location loc1 = new Location(w1, x1, y1, z1);
		player.teleport(loc1);
		cooldown.CooldownSet(player.getName() + "_家點傳送", 5);
		player.sendActionBar(String.format(MessageManager.HOME_TP_HOME, point));

	}

}
// home set <home1 or 2 or 3>