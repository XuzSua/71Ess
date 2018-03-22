package aa.plugin.main;

import aa.plugin.system.GameMode;
import aa.plugin.system.Spawn;
import aa.plugin.system.Weather;

public class RegisterCommands
{
	Main plugin = Main.plugin;
	
	public RegisterCommands()
	{
		//plugin.getCommand("").setExecutor(new (plugin));
		plugin.getCommand("gm").setExecutor(new GameMode());
		plugin.getCommand("weather").setExecutor(new Weather());
		plugin.getCommand("spawn").setExecutor(new Spawn());
	}
}
