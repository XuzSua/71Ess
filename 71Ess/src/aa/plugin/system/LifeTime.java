package aa.plugin.system;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class LifeTime extends BukkitRunnable{

	@Override
	public void run() {
		
		Calendar c = Calendar.getInstance();
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int seconds = c.get(Calendar.SECOND);
		
		int total = hour * 3600 + minute * 60 + seconds;
		
		double persent = (double)total / 86400;
		
		for(World world : Bukkit.getWorlds()) {
			
			world.setTime((long)(18000 * persent));
			
		}
		
	}

}
