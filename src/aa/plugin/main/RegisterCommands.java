package aa.plugin.main;

import aa.plugin.system.Afk;
import aa.plugin.system.Back;
import aa.plugin.system.Broadcast;
import aa.plugin.system.ChatManager;
import aa.plugin.system.Fly;
import aa.plugin.system.GameModes;
import aa.plugin.system.God;
import aa.plugin.system.Heal;
import aa.plugin.system.Home;
import aa.plugin.system.MoneySystem;
import aa.plugin.system.PingDetect;
import aa.plugin.system.PrivateMessage;
import aa.plugin.system.SignEditorBySigtuna;
import aa.plugin.system.Spawn;
import aa.plugin.system.Teleport;
import aa.plugin.system.Time;
import aa.plugin.system.Tpa;
import aa.plugin.system.Tpall;
import aa.plugin.system.Tphere;
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
		plugin.getCommand("tpc").setExecutor(new Teleport());
		
		plugin.getCommand("tpa").setExecutor(new Tpa());
		plugin.getCommand("tphere").setExecutor(new Tphere());
		
		plugin.getCommand("fly").setExecutor(new Fly());
		
		plugin.getCommand("god").setExecutor(new God());
		
		plugin.getCommand("ping").setExecutor(new PingDetect());
		
		plugin.getCommand("msg").setExecutor(new PrivateMessage());
		plugin.getCommand("msgr").setExecutor(new PrivateMessage());
		
		plugin.getCommand("tpall").setExecutor(new Tpall());
		
		plugin.getCommand("signedit").setExecutor(new SignEditorBySigtuna());
		
		plugin.getCommand("heal").setExecutor(new Heal());
		
		plugin.getCommand("afk").setExecutor(new Afk());
		
		plugin.getCommand("back").setExecutor(new Back());
		
		plugin.getCommand("broadcast").setExecutor(new Broadcast());
		plugin.getCommand("bc").setExecutor(new Broadcast());
		
		plugin.getCommand("chat").setExecutor(new ChatManager());
		
		plugin.getCommand("money").setExecutor(new MoneySystem());
		
		plugin.getCommand("home").setExecutor(new Home());
		plugin.getCommand("sethome").setExecutor(new Home());
		plugin.getCommand("delhome").setExecutor(new Home());
	}
}
