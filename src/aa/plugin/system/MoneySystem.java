package aa.plugin.system;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.MessageManager;
import ess.classes.EcoData;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class MoneySystem implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			
			Player player = (Player) sender;
			if (player.hasPermission("71ess.money"))
			{
				
				EcoData ed = new EcoData(player);
				
				if (args.length == 0)
				{
					help(player);
					return false;
				}
				
				if (args.length > 0)
				{
					
					switch(args[0])
					{
						case "show":
							
							if (player.hasPermission("71ess.money.show"))
							{
								int money = ed.getMoney();
								
								player.sendMessage("您目前有 " + money + " 元");
								
								if (args.length == 2)
								{
									
									Player SHOWtarget = Bukkit.getServer().getPlayer(args[1]);
									
									EcoData targetED = new EcoData(SHOWtarget);
									
									int targetmoney = targetED.getMoney();
									
									player.sendMessage(SHOWtarget.getName() + " 的金錢為 " + targetmoney);
									
								}
								
							} else {
								
								player.sendMessage(MessageManager.HAVENOPERMISSION);
							}
							
							
							break;
						
						case "give":
							
							if (player.hasPermission("71ess.money.give"))
							{
								int amount = Integer.parseInt(args[1]);
								
								if (args[1] == null)
								{
									
									player.sendMessage("請輸入一個值");
									return false;
									
								}
								if (args.length == 3)
								{
									
									Player GIVEtarget = Bukkit.getServer().getPlayer(args[2]);
									
									EcoData GtargetED = new EcoData(GIVEtarget);
									
									EcoData.giveMoney(GIVEtarget, amount);
									GIVEtarget.sendMessage("您被給予 " + amount + " 元 " + "目前擁有 " + (int) GtargetED.getMoney());
									player.sendMessage("您給予對方 " + amount + " 元");
									return false;
								}
								EcoData.giveMoney(player, amount);
								
								player.sendMessage("您被給予 " + amount + " 元 " + "目前擁有 " + (int) ed.getMoney());
							} else {
								
								player.sendMessage(MessageManager.HAVENOPERMISSION);
							}
							
							break;
							
						case "set":
							
							if (player.hasPermission("71ess.money.set"))
							{
								int setmoney = Integer.parseInt(args[1]);
								
								if (args[1] == null)
								{
									
									player.sendMessage("請輸入一個值");
									return false;
									
								}
								if (args.length == 3)
								{
									
									Player SETtarget = Bukkit.getServer().getPlayer(args[2]);
									
									EcoData.setMoney(SETtarget, setmoney);
									
									SETtarget.sendMessage("您的財富已被設置為 " + setmoney + " 元");
									player.sendMessage("您將對方的金錢設置為 " + setmoney + " 元");
									return false;
									
								}
								EcoData.setMoney(player, setmoney);
								
								player.sendMessage("您的財富已被設置為 " + setmoney + " 元");
								
							} else {
								
								player.sendMessage(MessageManager.HAVENOPERMISSION);
							}
							
							break;
							
						default:
							
							help(player);
							break;
					}
					
				}
				
			}
			
		}
		return false;
	}
	
	public void help (Player player)
	{
		
		TextComponent show = new TextComponent("- show");
		
		show.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/money show").create()));
		show.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/money show"));
		show.addExtra("     " + "顯示自己所擁有財富");
		
		TextComponent give = new TextComponent("- give");
		
		give.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/money give <數字>").create()));
		give.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/money give <數字>"));
		give.addExtra("     " + "給予指定數字的財富");
		
		player.sendMessage("=================================================================");
		player.sendMessage("");
		player.sendMessage("/money 透過鼠標移動到下方指令並點選 §a§l自動輸入指令!");
		player.sendMessage("若要對其他人進行動作 請在指令最後方加上對方ID");
		player.sendMessage("");
		player.sendMessage(show);
		player.sendMessage(give);
		player.sendMessage("");
		player.sendMessage("=================================================================");
		
	}

}
