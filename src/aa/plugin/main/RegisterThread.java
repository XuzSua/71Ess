package aa.plugin.main;

import aa.plugin.system.PingDetect;

public class RegisterThread {
	
	Main plugin = Main.plugin;
	
	public RegisterThread() {
		
		//執行Ping檢查  20 * 秒數
		new PingDetect().runTaskTimer(plugin, 0, 20 * 20);
		
		//現實時間同步
		//new LifeTime().runTaskTimer(plugin,0, 20);
	}
 
}
