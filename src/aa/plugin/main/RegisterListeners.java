package aa.plugin.main;

import org.bukkit.plugin.PluginManager;

import aa.plugin.main.GUIs.GamemodeGUI;
import aa.plugin.main.GUIs.MainAdminGUI;
import aa.plugin.main.GUIs.MainGUI;
import aa.plugin.main.GUIs.TeleportGUI;
import aa.plugin.main.GUIs.TimeGUI;
import aa.plugin.main.GUIs.TpaGUI;
import aa.plugin.system.Afk;
import aa.plugin.system.AutoRespawn;
import aa.plugin.system.Back;
import aa.plugin.system.GameModes;
import aa.plugin.system.God;
import aa.plugin.system.LoginQuitMessage;
import aa.plugin.system.SignEditorBySigtuna;
import aa.plugin.system.Spawn;
import aa.plugin.system.TradeChannel;
import aa.plugin.system.Weather;

public class RegisterListeners
{
	Main main = Main.plugin;
	
	PluginManager pm = main.getServer().getPluginManager();
	
	public RegisterListeners(Main plugin) 
	{
		
		//pm.registerEvents();
		
		pm.registerEvents(new GameModes(), plugin);
		pm.registerEvents(new Weather(), plugin);
		pm.registerEvents(new Spawn(), plugin);
		pm.registerEvents(new God(), plugin);
		pm.registerEvents(new SignEditorBySigtuna(), plugin);
		pm.registerEvents(new TradeChannel(), plugin);
		pm.registerEvents(new Afk(), plugin);
		pm.registerEvents(new AutoRespawn(), plugin);
		pm.registerEvents(new Back(), plugin);
		pm.registerEvents(new LoginQuitMessage(), plugin);
		
		//GUIs
		pm.registerEvents(new MainGUI(), plugin);
		pm.registerEvents(new MainAdminGUI(), plugin);
		pm.registerEvents(new TeleportGUI(), plugin);
		pm.registerEvents(new TimeGUI(), plugin);
		pm.registerEvents(new GamemodeGUI(), plugin);
		pm.registerEvents(new TpaGUI(), plugin);
	}
}