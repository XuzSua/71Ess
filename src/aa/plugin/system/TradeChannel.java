package aa.plugin.system;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import aa.plugin.function.cooldown;
import aa.plugin.main.MessageManager;

public class TradeChannel implements Listener
{
	@EventHandler    
	public void tradeChannel(AsyncPlayerChatEvent e)
	{
		Player p = e.getPlayer();
		if (p.hasPermission("71ess.tardeChannel"))
		{
			if (!cooldown.CooldownCheck(p.getName() + "交易頻道"))
			{
				p.sendMessage("§f§l您的交易頻道發言正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
				e.setCancelled(true);
				return;
			}
				if (e.getMessage().startsWith("$"))
				{
					String msg = e.getMessage().substring(1);
					p.getServer().broadcastMessage("");
					p.getServer().broadcastMessage("§6§l交易頻道 §7§l>> [§a" + p.getDisplayName() + "§7§l] §f" + msg);
					p.getServer().broadcastMessage("");
					e.setCancelled(true);
					cooldown.CooldownSet(p.getName() + "_交易頻道", 5);
				}
		} else {
			
			p.sendMessage(MessageManager.HAVENOPERMISSION);
			
		}
	}
}
