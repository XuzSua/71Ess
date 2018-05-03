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
				if (args[0] == null)
				{
					
					player.sendMessage("請輸入你的家名稱");
					return true;
					
				}
				home(player, args[0]);
				
			} else if (cmd.getName().equalsIgnoreCase("sethome"))
			{
				if (args[0] == null)
				{
					
					player.sendMessage("請輸入一個名稱來命名你的家");
					return true;
					
				}
				setHome(player, args[0]);
				
			} else if (cmd.getName().equalsIgnoreCase("delhome"))
			{
				
				if (args[0] == null)
				{
					
					player.sendMessage("請輸入你的家名稱來刪除");
					return true;
					
				}
				delHome(player, args[0]);
				
			}
		}
		
		return false;
	}
	
	public static void home (Player player, String homeName)
	{
		
		World w = Bukkit.getWorld(home.getString(homeName + ".world","world"));
		double x = home.getDouble(homeName + ".homeX");
		double y = home.getDouble(homeName + ".homeY");
		double z = home.getDouble(homeName + ".homeZ");
		float pitch = (float) home.getDouble(homeName + ".homePitch");
		float yaw = (float) home.getDouble(homeName + ".homeYaw");
	
		Location loc = new Location(w, x, y + 1, z, pitch, yaw);
		player.teleport(loc);
		
		player.sendMessage("傳送至您的家 " + homeName);
	}
	
	public static void setHome(Player player, String homeName)
	{
		String playerID = player.getName();
		
		home.set(playerID + "." + homeName + ".world", player.getLocation().getWorld().getName());
		home.set(playerID + "." + homeName + ".homeX", player.getLocation().getBlockX());
		home.set(playerID + "." + homeName + ".homeY", player.getLocation().getBlockY());
		home.set(playerID + "." + homeName + ".homeZ", player.getLocation().getBlockZ());
		home.set(playerID + "." + homeName + ".homePitch", player.getLocation().getPitch());
		home.set(playerID + "." + homeName + ".homeYaw", player.getLocation().getYaw());
		
		Main.plugin.SystemReLoad();

		player.sendMessage("已將您的家點設置於此");
		
	}
	
	public static void delHome(Player player, String homeName)
	{		
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
