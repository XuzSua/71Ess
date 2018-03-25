package aa.plugin.system;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;

public class Spawn implements CommandExecutor, Listener
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (args.length > 0)
		{
			Player p = (Player) sender;
			if (sender instanceof Player) switch (args[0])
			{
				case "set":
					
					if (p.hasPermission("71ess.setspawn"))
					{
						FileConfiguration spawn = Main.plugin.sc;
						
						spawn.set("world", p.getLocation().getWorld().getName());
						spawn.set("spawnX", p.getLocation().getX());
						spawn.set("spawnY", p.getLocation().getY());
						spawn.set("spawnZ", p.getLocation().getZ());
						spawn.set("spawnPitch", p.getLocation().getPitch());
						spawn.set("spawnYaw", p.getLocation().getYaw());
						Main.plugin.SystemReLoad();
						
						p.sendMessage(MessageManager.SPAWN_SET);
					}
					break;
				
				case "tp":

					FileConfiguration spawn = Main.plugin.sc;
					
					World w = Bukkit.getWorld(spawn.getString("world"));
					double x = spawn.getDouble("spawnX");
					double y = spawn.getDouble("spawnY");
					double z = spawn.getDouble("spawnZ");
					float pitch = (float) spawn.getDouble("spawnPitch");
					float yaw = (float) spawn.getDouble("spawnYaw");
					
					Location loc = new Location(w, x, y, z, pitch, yaw);
					p.teleport(loc);
					p.sendMessage(MessageManager.SPAWN_TP);
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
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		
		File file = new File("plugins/71ess/spawn.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		World w = Bukkit.getWorld(cfg.getString("world"));
		double x = cfg.getDouble("spawnX");
		double y = cfg.getDouble("spawnY");
		double z = cfg.getDouble("spawnZ");
		float pitch = (float) cfg.getDouble("spawnPitch");
		float yaw = (float) cfg.getDouble("spawnYaw");
		
		Location loc = new Location(w, x, y, z, pitch, yaw);
		p.teleport(loc);
		p.sendMessage(MessageManager.SPAWN_LOGIN);
	}
}
