package aa.plugin.main;

import aa.plugin.system.GameMode;
import aa.plugin.system.Spawn;
import aa.plugin.system.Weather;
import aa.plugin.system.teleport;
import aa.plugin.system.time;

public class RegisterCommands
{
	Main plugin = Main.plugin;
	
	public RegisterCommands()
	{
		//plugin.getCommand("").setExecutor(new (plugin));
		plugin.getCommand("gm").setExecutor(new GameMode());
		plugin.getCommand("weather").setExecutor(new Weather());
		plugin.getCommand("spawn").setExecutor(new Spawn());
		plugin.getCommand("time").setExecutor(new time());
		plugin.getCommand("tp").setExecutor(new teleport());
	}
}
