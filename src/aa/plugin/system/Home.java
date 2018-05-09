package aa.plugin.system;

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
				home(player);
				
			} else if (cmd.getName().equalsIgnoreCase("sethome"))
			{
				setHome(player);	
			}
		}
		
		return false;
	}
	
	public static void home (Player player)
	{
		
		if(home.getString(player.getName()) == null) {
			
			player.sendMessage("尚未設置家點，請設置");
			
		}
		
		World w = Bukkit.getWorld(home.getString(player.getName() + ".world","world"));
		String location = home.getString(player.getName() + ".home_location");
		
		String[] array = location.split(",");
		
		int x = Integer.parseInt(array[0]);
		int y = Integer.parseInt(array[1]);
		int z = Integer.parseInt(array[2]);
		
		player.teleport(new Location(w,x,y,z));
		
		player.sendMessage("傳送至您的家");
	}
	
	public static void setHome(Player player)
	{
		String playerID = player.getName();
		
		Location loc = player.getLocation();
		
		String location = String.format("%d,%d,%d", loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());

		home.set(playerID + ".world", player.getLocation().getWorld().getName());
		home.set(playerID + ".home_location", location);
		
		Main.plugin.SystemReLoad();

		player.sendMessage("已將您的家點設置於此");
		
	}
	
}
