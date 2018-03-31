package aa.plugin.main;

import aa.plugin.system.GameMode;
import aa.plugin.system.Spawn;
import aa.plugin.system.Teleport;
import aa.plugin.system.Time;
import aa.plugin.system.Weather;

public class RegisterListener
{
	Main main = Main.plugin;
	
	public RegisterListener(Main plugin) 
	{
		
		//plugin.getServer().getPluginManager().registerEvents();
		plugin.getServer().getPluginManager().registerEvents(new GameMode(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Weather(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Spawn(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Time(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Teleport(), plugin);
	}
}
