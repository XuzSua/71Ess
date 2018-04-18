package aa.plugin.main;

import aa.plugin.main.GUIs.MainAdminGUI;
import aa.plugin.main.GUIs.MainGUI;
import aa.plugin.main.GUIs.TeleportGUI;
import aa.plugin.main.GUIs.TimeGUI;
import aa.plugin.system.GameModes;
import aa.plugin.system.God;
import aa.plugin.system.SignEditor;
import aa.plugin.system.Spawn;
import aa.plugin.system.TradeChannel;
import aa.plugin.system.Weather;

public class RegisterListeners
{
	Main main = Main.plugin;
	
	public RegisterListeners(Main plugin) 
	{
		
		//plugin.getServer().getPluginManager().registerEvents();
		
		plugin.getServer().getPluginManager().registerEvents(new GameModes(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Weather(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Spawn(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new God(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new SignEditor(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TradeChannel(), plugin);
		
		//GUIs
		plugin.getServer().getPluginManager().registerEvents(new MainGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new MainAdminGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TeleportGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TimeGUI(), plugin);
	}
}