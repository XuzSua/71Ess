package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 :§f";
	
	//遊戲模式
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
	
	//重生點
	public final static String SPAWN_SET = Main.plugin.mc.getString("SPAWN_SET", title + "您將伺服器公共重生點設置於此");
	public final static String SPAWN_TP = Main.plugin.mc.getString("SPAWN_TP", title + "將您傳送至伺服器公共重生點");
	public final static String SPAWN_LOGIN = Main.plugin.mc.getString("SPAWN_LOGIN", "登入此伺服器時系統設定玩家自動傳送回重生點! (避免玩家在一些奇奇怪怪的地方下線以至於上線時被圍毆之類的)");
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;

		//遊戲模式
		message.set("GAMEMODE_SURVIVAL", GAMEMODE_SURVIVAL);
		message.set("GAMEMODE_CREATIVE", GAMEMODE_CREATIVE);
		message.set("GAMEMODE_ADVENTURE", GAMEMODE_ADVENTURE);
		message.set("GAMEMODE_SPECTATOR", GAMEMODE_SPECTATOR);
		message.set("GAMEMODE_SURVIVAL_TOPLAYER", GAMEMODE_SURVIVAL_TOPLAYER);
		message.set("GAMEMODE_CREATIVE_TOPLAYER", GAMEMODE_CREATIVE_TOPLAYER);
		message.set("GAMEMODE_ADVENTURE_TOPLAYER", GAMEMODE_ADVENTURE_TOPLAYER);
		message.set("GAMEMODE_SPECTATOR_TOPLAYER", GAMEMODE_SPECTATOR_TOPLAYER);
		message.set("GAMEMODE_SURVIVAL_HASBEENCHANGE", GAMEMODE_SURVIVAL_HASBEENCHANGE);
		message.set("GAMEMODE_CREATIVE_HASBEENCHANGE", GAMEMODE_CREATIVE_HASBEENCHANGE);
		message.set("GAMEMODE_ADVENTURE_HASBEENCHANGE", GAMEMODE_ADVENTURE_HASBEENCHANGE);
		message.set("GAMEMODE_SPECTATOR_HASBEENCHANGE", GAMEMODE_SPECTATOR_HASBEENCHANGE);
		
		message.set("SPAWN_SET", SPAWN_SET);
		message.set("SPAWN_TP", SPAWN_TP);
		message.set("SPAWN_LOGIN", SPAWN_LOGIN);
		Main.plugin.SystemReLoad();
	}
}
