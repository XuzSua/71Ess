package aa.plugin.main;

import aa.plugin.system.PingDetect;

public class RegisterThread {
	
	Main plugin = Main.plugin;
	
	public RegisterThread() {
		
		new PingDetect().runTaskTimer(plugin, 0, 20*60);
		
	}

}
