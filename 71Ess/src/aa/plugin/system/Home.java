package aa.plugin.system;

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
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Home implements CommandExecutor {

	FileConfiguration home = Main.plugin.hc;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (args.length > 0)
		{
			Player p = (Player) sender;
			if (sender instanceof Player) switch (args[0])
			{
				case "set":
					if (!cooldown.CooldownCheck("_家點設置"))
					{
						p.sendMessage(MessageManager.HOME_SET_COOLDOWN);
						return false;
					}
					if (args.length == 1)
					{
						p.sendMessage(MessageManager.HOME_PUTNAME);
						return false;
					}
					switch (args[1])
					{
						case "home1":
							home.set(p.getUniqueId() + ".home1.location.world", p.getLocation().getWorld().getName());
							home.set(p.getUniqueId() + ".home1.location.x", p.getLocation().getBlockX());
							home.set(p.getUniqueId() + ".home1.location.y", p.getLocation().getBlockY());
							home.set(p.getUniqueId() + ".home1.location.z", p.getLocation().getBlockZ());
							Main.plugin.SystemReLoad();
							
							cooldown.CooldownSet("_家點設置", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_SET_HOME1));
							break;
							
						case "home2":
							home.set(p.getUniqueId() + ".home2.location.world", p.getLocation().getWorld().getName());
							home.set(p.getUniqueId() + ".home2.location.x", p.getLocation().getBlockX());
							home.set(p.getUniqueId() + ".home2.location.y", p.getLocation().getBlockY());
							home.set(p.getUniqueId() + ".home2.location.z", p.getLocation().getBlockZ());
							Main.plugin.SystemReLoad();
							
							cooldown.CooldownSet("_家點設置", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_SET_HOME2));
							break;
							
						case "home3":
							home.set(p.getUniqueId() + ".home3.location.world", p.getLocation().getWorld().getName());
							home.set(p.getUniqueId() + ".home3.location.x", p.getLocation().getBlockX());
							home.set(p.getUniqueId() + ".home3.location.y", p.getLocation().getBlockY());
							home.set(p.getUniqueId() + ".home3.location.z", p.getLocation().getBlockZ());
							Main.plugin.SystemReLoad();
							
							cooldown.CooldownSet("_家點設置", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_SET_HOME3));
							break;
							
						default:
							System.out.println("請指定home1, home2, home3");

					}
					break;
					
				case "tp":
					if (!cooldown.CooldownCheck(p.getName() + "_家點傳送"))
					{
						p.sendMessage(MessageManager.SPAWN_TP_COOLDOWN);
						return false;
					}
					if (args.length == 1)
					{
						p.sendMessage(MessageManager.HOME_PUTNAME);
						return false;
					}
					switch (args[1])
					{
						case "home1":
							if (home.contains(p.getUniqueId() + ".home1")) return false;
							World w1 = Bukkit.getWorld(home.getString(p.getUniqueId() + ".home1.location.world"));
							int x1 = home.getInt(p.getUniqueId() + ".home1.location.x");
							int y1 = home.getInt(p.getUniqueId() + ".home1.location.y");
							int z1 = home.getInt(p.getUniqueId() + ".home1.location.z");
							
							Location loc1 = new Location(w1, x1, y1, z1);
							p.teleport(loc1);
							cooldown.CooldownSet(p.getName() + "_家點傳送", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_TP_HOME1));
							break;
							
						case "home2":
							if (home.contains(p.getUniqueId() + ".home2")) return false;
							World w2 = Bukkit.getWorld(home.getString(p.getUniqueId() + ".home1.location.world"));
							int x2 = home.getInt(p.getUniqueId() + ".home1.location.x");
							int y2 = home.getInt(p.getUniqueId() + ".home1.location.y");
							int z2 = home.getInt(p.getUniqueId() + ".home1.location.z");
							
							Location loc2 = new Location(w2, x2, y2, z2);
							p.teleport(loc2);
							cooldown.CooldownSet(p.getName() + "_家點傳送", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_TP_HOME2));
							break;
							
						case "home3":
							if (home.contains(p.getUniqueId() + ".home3")) return false;
							World w3 = Bukkit.getWorld(home.getString(p.getUniqueId() + ".home1.location.world"));
							int x3 = home.getInt(p.getUniqueId() + ".home1.location.x");
							int y3 = home.getInt(p.getUniqueId() + ".home1.location.y");
							int z3 = home.getInt(p.getUniqueId() + ".home1.location.z");
							
							Location loc3 = new Location(w3, x3, y3, z3);
							p.teleport(loc3);
							cooldown.CooldownSet(p.getName() + "_家點傳送", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.HOME_TP_HOME3));
							break;
						default:
							System.out.println("請指定home1, home2, home3");
					}
					break;
				default:
					System.out.println("未知的指令!");
			}
		} else {
			sender.sendMessage("====================================");
			sender.sendMessage("/spawn tp 傳送至伺服器公共重生點 (玩家可用)");
			sender.sendMessage("/spawn set 設置伺服器公共重生點");
			sender.sendMessage("====================================");
		}
		return false;
	}

}
//home set <home1 or 2 or 3>