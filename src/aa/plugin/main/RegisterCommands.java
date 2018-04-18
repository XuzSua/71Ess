package aa.plugin.main;

import aa.plugin.system.Fly;
import aa.plugin.system.GameModes;
import aa.plugin.system.God;
import aa.plugin.system.Home;
import aa.plugin.system.PingDetect;
import aa.plugin.system.PrivateMessage;
import aa.plugin.system.Spawn;
import aa.plugin.system.Teleport;
import aa.plugin.system.Time;
import aa.plugin.system.Tpa;
import aa.plugin.system.Tpall;
import aa.plugin.system.Weather;

public class RegisterCommands
{
	Main plugin = Main.plugin;
	
	public RegisterCommands()
	{
		//plugin.getCommand("").setExecutor(new (plugin));
		plugin.getCommand("gamemode").setExecutor(new GameModes());
		plugin.getCommand("gm").setExecutor(new GameModes());
		plugin.getCommand("weather").setExecutor(new Weather());
		plugin.getCommand("spawn").setExecutor(new Spawn());
		plugin.getCommand("time").setExecutor(new Time());
		plugin.getCommand("tp").setExecutor(new Teleport());
		plugin.getCommand("tpa").setExecutor(new Tpa());
		plugin.getCommand("home").setExecutor(new Home());
		plugin.getCommand("fly").setExecutor(new Fly());
		plugin.getCommand("god").setExecutor(new God());
		plugin.getCommand("ping").setExecutor(new PingDetect());
		plugin.getCommand("msg").setExecutor(new PrivateMessage());
		plugin.getCommand("msgr").setExecutor(new PrivateMessage());
		plugin.getCommand("tpall").setExecutor(new Tpall());
	}
}
