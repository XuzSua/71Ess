package aa.plugin.system;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import aa.plugin.main.Main;

public class Home implements CommandExecutor
{
	private static FileConfiguration home = Main.plugin.hc;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("home"))
			{
				
				home(player, args[0]);
				
			} else if (cmd.getName().equalsIgnoreCase("sethome"))
			{
			
				setHome(player, args[0]);
				
			} else if (cmd.getName().equalsIgnoreCase("delhome"))
			{
				
				delHome(player, args[0]);
				
			}
		}
		
		return false;
	}
	
	public static void home (Player player, String homeName)
	{
		
		World w = Bukkit.getWorld(home.getString("world"));
		double x = home.getDouble("spawnX");
		double y = home.getDouble("spawnY");
		double z = home.getDouble("spawnZ");
		float pitch = (float) home.getDouble("spawnPitch");
		float yaw = (float) home.getDouble("spawnYaw");
	
		Location loc = new Location(w, x, y, z, pitch, yaw);
		player.teleport(loc);
		
		player.sendMessage("傳送至您的家 " + homeName);
	}
	
	public static void setHome(Player player, String homeName)
	{
		if (player == null) return;
			
		home.set(homeName + ".world", player.getLocation().getWorld().getName());
		home.set(homeName + ".homeX", player.getLocation().getX());
		home.set(homeName + ".homeY", player.getLocation().getY());
		home.set(homeName + ".homeZ", player.getLocation().getZ());
		home.set(homeName + ".homePitch", player.getLocation().getPitch());
		home.set(homeName + ".homeYaw", player.getLocation().getYaw());
		
		Main.plugin.SystemReLoad();

		player.sendMessage("已將您的家點設置於此");
		
	}
	
	public static void delHome(Player player, String homeName)
	{
	
		if (player == null) return;
		
		Set<String> set = home.getKeys(false);
		for (String name : set)
		{
			if (name.equalsIgnoreCase(homeName))
			{
				home.set(name, null);
				break;
			}
		}
		
		Main.plugin.SystemReLoad();
		
		player.sendMessage("已將您的家 " + homeName + " 移除!");
	}
	
}
