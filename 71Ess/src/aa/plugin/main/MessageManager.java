package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 :§f";
	
	public final static String GAMEMODE_SURVIVAL = Main.plugin.mc.getString("GAMEMODE_SURVIVAL", title + "已將您的遊戲模式更改為 (生存模式)");
	public final static String GAMEMODE_CREATIVE = Main.plugin.mc.getString("GAMEMODE_CREATIVE", title + "已將您的遊戲模式更改為 (創造模式)");
	public final static String GAMEMODE_ADVENTURE = Main.plugin.mc.getString("GAMEMODE_ADVENTURE", title + "已將您的遊戲模式更改為 (冒險模式)");
	public final static String GAMEMODE_SPECTATOR = Main.plugin.mc.getString("GAMEMODE_SPECTATOR", title + "已將您的遊戲模式更改為 (觀察模式)");
	public final static String GAMEMODE_SURVIVAL_TOPLAYER = Main.plugin.mc.getString("GAMEMODE_SURVIVAL_TOPLAYER", title + "已將目標玩家的遊戲模式更改為 (生存模式)");
	public final static String GAMEMODE_CREATIVE_TOPLAYER = Main.plugin.mc.getString("GAMEMODE_CREATIVE_TOPLAYER", title + "已將目標玩家的遊戲模式更改為 (創造模式)");
	public final static String GAMEMODE_ADVENTURE_TOPLAYER = Main.plugin.mc.getString("GAMEMODE_ADVENTURE_TOPLAYER", title + "已將目標玩家的遊戲模式更改為 (冒險模式)");
	public final static String GAMEMODE_SPECTATOR_TOPLAYER = Main.plugin.mc.getString("GAMEMODE_SPECTATOR_TOPLAYER", title + "已將目標玩家的遊戲模式更改為 (觀察模式)");
	public final static String GAMEMODE_SURVIVAL_HASBEENCHANGE = Main.plugin.mc.getString("GAMEMODE_SURVIVAL_HASBEENCHANGE", title + "您的遊戲模式被管理員更改為 (生存模式)");
	public final static String GAMEMODE_CREATIVE_HASBEENCHANGE = Main.plugin.mc.getString("GAMEMODE_CREATIVE_HASBEENCHANGE", title + "您的遊戲模式被管理員更改為 (創造模式)");
	public final static String GAMEMODE_ADVENTURE_HASBEENCHANGE = Main.plugin.mc.getString("GAMEMODE_ADVENTURE_HASBEENCHANGE", title + "您的遊戲模式被管理員更改為(冒險模式)");
	public final static String GAMEMODE_SPECTATOR_HASBEENCHANGE = Main.plugin.mc.getString("GAMEMODE_SPECTATOR_HASBEENCHANGE", title + "您的遊戲模式被管理員更改為 (觀察模式)");
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;

		//訊息設定
		message.set("GAMEMODE_SURVIVAL", GAMEMODE_SURVIVAL);
		message.set("GAMEMODE_CREATIVE", GAMEMODE_CREATIVE);
		message.set("GAMEMODE_ADVENTURE", GAMEMODE_ADVENTURE);
		message.set("GAMEMODE_SPECTATOR", GAMEMODE_SPECTATOR);
		message.set("GAMEMODE_SURVIVAL_TOPLAYER", GAMEMODE_SURVIVAL_TOPLAYER);
		message.set("GAMEMODE_CREATIVE_TOPLAYER", GAMEMODE_CREATIVE_TOPLAYER);
		message.set("GAMEMODE_ADVENTURE_TOPLAYER", GAMEMODE_ADVENTURE_TOPLAYER);
		message.set("GAMEMODE_SPECTATOR_TOPLAYER", GAMEMODE_SPECTATOR_TOPLAYER);
		message.set("GAMEMODE_SURVIVAL_TOPLAYER", GAMEMODE_SURVIVAL_HASBEENCHANGE);
		message.set("GAMEMODE_CREATIVE_TOPLAYER", GAMEMODE_CREATIVE_HASBEENCHANGE);
		message.set("GAMEMODE_ADVENTURE_TOPLAYER", GAMEMODE_ADVENTURE_HASBEENCHANGE);
		message.set("GAMEMODE_SPECTATOR_TOPLAYER", GAMEMODE_SPECTATOR_HASBEENCHANGE);
		Main.plugin.SystemReLoad();
	}
}
