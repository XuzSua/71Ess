package aa.plugin.main;

import aa.plugin.main.GUIs.mainAdminGUI;
import aa.plugin.main.GUIs.mainGUI;
import aa.plugin.system.ColorSign;
import aa.plugin.system.GameModes;
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
		
		plugin.getServer().getPluginManager().registerEvents(new GameModes(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Weather(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Spawn(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Time(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Teleport(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new ColorSign(), plugin);
		
		//GUIs
		plugin.getServer().getPluginManager().registerEvents(new mainGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new mainAdminGUI(), plugin);
	}
}