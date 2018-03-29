package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import aa.plugin.function.cooldown;
import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Spawn implements CommandExecutor, Listener
{

	FileConfiguration spawn = Main.plugin.sc;
	
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
						if (!cooldown.CooldownCheck(p.getName() + "_重生點設置"))
						{
							p.sendMessage(MessageManager.SPAWN_SET_COOLDOWN);
							return false;
						}					
							spawn.set("world", p.getLocation().getWorld().getName());
							spawn.set("spawnX", p.getLocation().getX());
							spawn.set("spawnY", p.getLocation().getY());
							spawn.set("spawnZ", p.getLocation().getZ());
							spawn.set("spawnPitch", p.getLocation().getPitch());
							spawn.set("spawnYaw", p.getLocation().getYaw());
							Main.plugin.SystemReLoad();

							cooldown.CooldownSet(p.getName() + "_重生點設置", 5);
							p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.SPAWN_SET));
					}
					break;
				
				case "tp":
					if (!cooldown.CooldownCheck(p.getName() + "_重生點傳送"))
					{
						p.sendMessage(MessageManager.SPAWN_TP_COOLDOWN);
						return false;
					}
						World w = Bukkit.getWorld(spawn.getString("world"));
						double x = spawn.getDouble("spawnX");
						double y = spawn.getDouble("spawnY");
						double z = spawn.getDouble("spawnZ");
						float pitch = (float) spawn.getDouble("spawnPitch");
						float yaw = (float) spawn.getDouble("spawnYaw");
					
						Location loc = new Location(w, x, y, z, pitch, yaw);
						p.teleport(loc);
						cooldown.CooldownSet(p.getName() + "_重生點傳送", 5);
						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.SPAWN_TP));
					
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
	
	//修正，新增初值world，如果spawn沒有設置就自動導向world
	@EventHandler
	public void onJoin(PlayerLoginEvent e)
	{
		Player p = e.getPlayer();
		
		FileConfiguration spawn = Main.plugin.sc;
		
		World w = Bukkit.getWorld(spawn.getString("world","world"));
		double x = spawn.getDouble("spawnX");
		double y = spawn.getDouble("spawnY");
		double z = spawn.getDouble("spawnZ");
		float pitch = (float) spawn.getDouble("spawnPitch");
		float yaw = (float) spawn.getDouble("spawnYaw");
		
		Location loc = new Location(w, x, y, z, pitch, yaw);
		p.teleport(loc);
		p.sendMessage(MessageManager.SPAWN_LOGIN);
	}
}
