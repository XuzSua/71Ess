package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import aa.plugin.main.Main;
import aa.plugin.main.MessageManager;

public class AutoRespawn implements Listener
{
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event)
	{
		
		Player player = event.getEntity();
		player.spigot().respawn();
		player.sendMessage("");
		player.sendMessage(MessageManager.AUTORESPAWN);
		player.sendMessage("");
		
		FileConfiguration spawn = Main.plugin.sc;
		
		World w = Bukkit.getWorld(spawn.getString("world"));
		double x = spawn.getDouble("spawnX");
		double y = spawn.getDouble("spawnY");
		double z = spawn.getDouble("spawnZ");
		float pitch = (float) spawn.getDouble("spawnPitch");
		float yaw = (float) spawn.getDouble("spawnYaw");
	
		Location loc = new Location(w, x, y, z, pitch, yaw);
		player.teleport(loc);
		
	}
	
}
