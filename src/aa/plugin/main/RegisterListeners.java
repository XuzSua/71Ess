package aa.plugin.main;

import aa.plugin.main.GUIs.GamemodeGUI;
import aa.plugin.main.GUIs.MainAdminGUI;
import aa.plugin.main.GUIs.MainGUI;
import aa.plugin.main.GUIs.TeleportGUI;
import aa.plugin.main.GUIs.TimeGUI;
import aa.plugin.main.GUIs.TpaGUI;
import aa.plugin.system.Afk;
import aa.plugin.system.GameModes;
import aa.plugin.system.God;
import aa.plugin.system.SignEditorBySigtuna;
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
		plugin.getServer().getPluginManager().registerEvents(new SignEditorBySigtuna(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TradeChannel(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new Afk(), plugin);
		
		//GUIs
		plugin.getServer().getPluginManager().registerEvents(new MainGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new MainAdminGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TeleportGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TimeGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new GamemodeGUI(), plugin);
		plugin.getServer().getPluginManager().registerEvents(new TpaGUI(), plugin);
	}
}