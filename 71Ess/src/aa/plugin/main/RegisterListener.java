package aa.plugin.main;

import aa.plugin.system.GameMode;
import aa.plugin.system.Spawn;
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
	}
}
