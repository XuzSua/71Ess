package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import aa.plugin.main.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PingDetect extends BukkitRunnable{

	Main plugin = Main.plugin;
	
	@Override
	public void run() {
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			
			int ping = ((CraftPlayer)player).getHandle().ping;
			
			if(ping > 200) {
				
				player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(ChatColor.RED + String.format("系統娘：你的PING值已經高達200以上(目前:%d)，請檢察網路是否有問題!!",ping)));
				
			}else {
				
				player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(ChatColor.GREEN + String.format("系統娘：你的PING值目前正常(目前:%d)，請安心遊玩!",ping)));
				
			}
			
		}
		
	}

}
