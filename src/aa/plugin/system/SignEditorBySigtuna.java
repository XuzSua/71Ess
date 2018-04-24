package aa.plugin.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

class SignData{
	
	Player creator;
	String[] info;
	
}

class SignSet{
	
	Player creator;
	SignData sd;
	Location main_location;
	List<Location> list = new ArrayList<Location>();
	List<Location> unclick = new ArrayList<Location>();
	
}

public class SignEditorBySigtuna implements Listener,CommandExecutor{

	static Map<Player,SignSet> map = new HashMap<Player,SignSet>();
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		//Action
		if(e.getAction() != Action.LEFT_CLICK_BLOCK || !e.getPlayer().isSneaking()) {
			
			return;
			
		}
		
		e.setCancelled(true);
		
		//Check click block is a sign.
		if(!(e.getClickedBlock().getState() instanceof Sign)) {
			
			return;
			
		}
		
		Sign sign = (Sign)e.getClickedBlock().getState();
		Player player = e.getPlayer();
		
		if(map.get(player) == null) {
			
			SignSet set = new SignSet();	
			SignData sd = new SignData();
			
			sd.creator = player;
			sd.info = sign.getLines();
			
			set.sd = sd;
			set.main_location = e.getClickedBlock().getLocation();
			
			map.put(player,set);
			
			player.sendMessage("新增主告示牌");
			
		} else {
			
			Location loc = e.getClickedBlock().getLocation();
			
			SignSet set = map.get(player);
			
			if(set.unclick.contains(loc)) {
				
				set.unclick.remove(loc);
				
				set.list.remove(loc);
				
				player.sendMessage("反向選擇告示牌");
				
			}else {
				
				if(set.main_location.equals(loc)) {
					
					player.sendMessage("與主告示牌座標重疊，無意義行為。");
					
				}
				
				SignData sd = new SignData();
				
				sd.creator = player;
				sd.info = sign.getLines();
				
				set.unclick.add(loc);
				
				set.list.add(loc);
				
				player.sendMessage("新增告示牌" + set.list.size());
				
			}
			
			map.put(player, set);
			
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage("你不是玩家，無法使用這個功能");
			return false;
			
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("71ess.signedit")) {
			
			sender.sendMessage(MessageManager.HAVENOPERMISSION);
			return false;
			
		}
		if (args.length == 0)
		{
			help(player);
			return false;
		}
		
		if (args.length > 0)
		{		
			switch(args[0])
			{
			
				case "copy":
			
					copy(player);
					break;
			
				case "reset":
				
					map.remove(player);
					player.sendMessage("清除成功。");
					break;
			
				default:
			
					help(player);
					break;
			
			}
			
		}
		
		
		return false;
	}
	
	public void help(Player player)
	{
		
		TextComponent copy = new TextComponent("- copy");
		
		copy.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/signedit copy").create()));
		copy.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/signedit copy"));	
		copy.addExtra("     " + "§7將主告示牌訊息複製到 所有記錄的告示牌上");
		
		TextComponent reset = new TextComponent("- reset");	
		
		reset.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/signedit reset").create()));
		reset.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/signedit reset"));
		reset.addExtra("    " + "§7清除所有告示牌點選紀錄 (包含主告示牌)");
		
		player.sendMessage("=================================================================");
		player.sendMessage("");
		player.sendMessage("/signedit 透過鼠標移動到下方指令並點選 §a§l自動輸入指令!");
		player.sendMessage("");
		player.sendMessage(copy);
		player.sendMessage(reset);
		player.sendMessage("");
		player.sendMessage("=================================================================");
		
	}
	
	public void copy(Player player) {
		
		if(map.get(player) == null) {
			
			player.sendMessage("沒有儲存任何告示牌。");
			return;
			
		}
		
		SignSet set = map.get(player);
		
		List<Location> data = set.list;
		SignData sd = set.sd;
		
		for(int i = 0; i < data.size(); i++) {
			
			Location loc = (Location) data.get(i);
			
			if(!(loc.getBlock().getState() instanceof Sign)) {
				
				player.sendMessage("在 " + loc.getBlockX() + " , " + loc.getBlockY() + " , " + loc.getBlockZ() + " 的告示牌已被拆除，已忽略。");
				continue;
				
			}
			
			Sign sign = (Sign) loc.getBlock().getState();
			
			for(int j = 0; j < sd.info.length; j++) {
				
				sign.setLine(j, sd.info[j]);
				
			}
			
			sign.update();
			
		}
		
		map.remove(player);
		
		player.sendMessage("設置完成。");
		
	}

}
