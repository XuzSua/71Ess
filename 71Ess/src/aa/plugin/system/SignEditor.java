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
	
	@EventHandler
	public void copySign(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.hasPermission("71ess.signedit"))
		{
			Map<Player, String[]> coping = new HashMap<>();
			if ((event.getAction() == Action.LEFT_CLICK_BLOCK) && (player.isSneaking()))
			{
				if (event.getClickedBlock().getState() instanceof Sign)
				{
					event.setCancelled(true);
					Sign sign = (Sign) event.getClickedBlock();
					String[] lines = sign.getLines();					
					
					if (!(coping.containsKey(player)))
					{
									
						coping.put(player, lines);
						player.sendActionBar("將告示牌內容複製");
						
					}
					if (coping.containsKey(player))
					{
					
						sign.setLine(0, lines[0]);
						sign.setLine(1, lines[1]);
						sign.setLine(2, lines[2]);
						sign.setLine(3, lines[3]);
						
						coping.remove(player);
						player.sendActionBar("將告示牌內容貼上");
						
					}
				}
			}
		}
	}
}
