package aa.plugin.main;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import aa.plugin.main.RegisterCommands;
import aa.plugin.main.RegisterListener;
import aa.plugin.main.Main;

public class Main extends JavaPlugin
{
	public static Main plugin;
	
	public File message, spawn, home;
	public FileConfiguration mc, sc, hc;
	
	public void onEnable()
	{
		plugin = this;
		FileConfig();
		new RegisterCommands();
		new RegisterListener(this);
		new RegisterThread();
	}
	
	public void FileConfig()
	{
		message = new File(this.getDataFolder() + "/Message.yml");
		mc = YamlConfiguration.loadConfiguration(message);
		
		spawn = new File(this.getDataFolder() + "/spawn.yml");
		sc = YamlConfiguration.loadConfiguration(spawn);
		
		home = new File(this.getDataFolder() + "/home.yml");
		hc = YamlConfiguration.loadConfiguration(home);
	}
	public void SystemReLoad() {
		try {
			mc.save(message);
			sc.save(spawn);
			hc.save(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
