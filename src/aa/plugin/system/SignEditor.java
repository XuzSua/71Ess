package aa.plugin.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import aa.plugin.main.MessageManager;

public class SignEditor implements Listener, CommandExecutor
{
	@EventHandler
	public void signColor(SignChangeEvent e)
	{
		for (int i = 0 ; i < e.getLines().length ; i++)
		{
			e.setLine( i , e.getLine(i).replaceAll( "&" , "§" ));
		}
	}
	
	static Map<Player, Sign> Sign1 = new HashMap<>();
	static Map<Player, Sign> Sign2 = new HashMap<>();
	
	@EventHandler
	public void EnterEditormode(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.hasPermission("71ess.signedit"))
		{
			if ((event.getAction() == Action.LEFT_CLICK_BLOCK) && (player.isSneaking()))
			{
				if (event.getClickedBlock().getState() instanceof Sign)
				{
					
					event.setCancelled(true);
					Sign sign = (Sign) event.getClickedBlock();
					
					if (!(Sign1.containsKey(player)))
					{
						
						Sign1.put(player, sign);
						player.sendMessage("選擇 1 號告示牌");
						return;
						
					}else if (Sign1.containsKey(player))
					{
						
						Sign2.put(player, sign);
						player.sendMessage("選擇 2 號告示牌");
						return;
						
					}else if (!(Sign1.containsKey(player) && (Sign2.containsKey(player))))
					{
						
						Sign2.remove(player, sign);
						player.sendMessage("發生錯誤 已重製選取");
						return;
						
					}
				}
			}
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("71ess.signedit"))
			{
				if (args.length > 0)
				{
					switch(args[0])
					{
						case "copy":
							
							if (!(Sign1.containsKey(player)))
							{
								player.sendMessage("找不到 1 號告示牌");
								return false;
							}else if (Sign1.containsKey(player))
							{
								if (Sign2.containsKey(player))
								{
									
									Sign target = Sign2.get(player);
									Sign sign = Sign1.get(player);
									
									String[] lines = sign.getLines();
									
									target.setLine(0, lines[0]);
									target.setLine(1, lines[1]);
									target.setLine(2, lines[2]);
									target.setLine(3, lines[3]);
									
									target.update();
									player.sendMessage(MessageManager.SIGNEDITOR_PASTING);
								}
							}
								
							break;
						
						default:
							
							player.sendMessage("=================================================================");
							player.sendMessage("");
							player.sendMessage("/signedit <下方指令>");
							player.sendMessage("- copy" + "     " + "將 1 號告示牌訊息複製到 2號告示牌");
							player.sendMessage("");
							player.sendMessage("=================================================================");
							
							break;
					}
				}
			}
		}
		
		return false;
	}
}
