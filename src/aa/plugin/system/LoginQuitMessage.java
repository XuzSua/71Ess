package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class LoginQuitMessage implements Listener
{

	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		String playerID = String.valueOf("§6§l" + player.getName());
		if (player.isOp())
		{
			
			TextComponent OPJoin = new TextComponent("§7[§a§l+§7] ");
			
			TextComponent OPMessage = new TextComponent(playerID);		
			OPMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8*---*§f " + player.getName() + "§8 *---*\n§e身分組 : §b管理員\n§e所在世界 : §b" + player.getWorld().getName()).create()));
			
			OPJoin.addExtra(OPMessage);
			OPJoin.addExtra(" §7§l已經上線啦");
			
			event.setJoinMessage(" ");
			Bukkit.broadcast(OPJoin);
			
		} else {
			
			TextComponent OPJoin = new TextComponent("§7[§a§l+§7] ");
			
			TextComponent OPMessage = new TextComponent(playerID);		
			OPMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8*---*§f " + player.getName() + "§8 *---*\n§e身分組 : §b玩家\n§e所在世界 : §b" + player.getWorld().getName()).create()));
			
			OPJoin.addExtra(OPMessage);
			OPJoin.addExtra(" §7§l已經上線啦");
			
			event.setJoinMessage(" ");
			Bukkit.broadcast(OPJoin);
			
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent event)
	{
		
		Player player = event.getPlayer();
		event.setQuitMessage("§7[§c§l-§7] §6§l" + player.getName() + " §7§l已經下線囉");
		
	}
	
}
