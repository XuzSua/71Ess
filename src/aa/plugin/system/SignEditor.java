package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import aa.plugin.main.MessageManager;

public class SignEditor implements Listener
{
	@EventHandler
	public void signColor(SignChangeEvent e)
	{
		for (int i = 0 ; i < e.getLines().length ; i++)
		{
			e.setLine( i , e.getLine(i).replaceAll( "&" , "§" ));
		}
	}
	
	static Map<Player, String[]> coping = new HashMap<>();
	
	@EventHandler
	public void copySign(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.hasPermission("71ess.signedit"))
		{
			if ((event.getAction() == Action.LEFT_CLICK_BLOCK) && (player.isSneaking()))
			{
				if (event.getClickedBlock().getState() instanceof Sign)
				{
					event.setCancelled(true);
					Sign sign = (Sign) event.getClickedBlock().getState();
					String[] lines = sign.getLines();					
					
					if (!(coping.containsKey(player)))
					{
									
						coping.put(player, lines);
						player.sendMessage(MessageManager.SIGNEDITOR_COPYING);
						
					}else if (coping.containsKey(player))
					{
					
						String[] line = coping.get(player);
						
						sign.setLine(0, line[0]);
						sign.setLine(1, line[1]);
						sign.setLine(2, line[2]);
						sign.setLine(3, line[3]);
						
						sign.update();
						
						coping.remove(player);
						player.sendMessage(MessageManager.SIGNEDITOR_PASTING);
						
					}
				}
			}
		}
	}
}
