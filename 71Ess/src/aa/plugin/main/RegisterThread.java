package aa.plugin.main;

import aa.plugin.system.LifeTime;
import aa.plugin.system.PingDetect;

public class RegisterThread {
	
	Main plugin = Main.plugin;
	
	public RegisterThread() {
		
		new PingDetect().runTaskTimer(plugin, 0, 20*60);
		
		new LifeTime().runTaskTimer(plugin,0, 20);
		
	}

}
