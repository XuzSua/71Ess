package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 :§f";
	
	//就是不給你用
	public final static String HAVENOPERMISSION = Main.plugin.mc.getString("HAVENOPERMISSION", "不給你用");
	
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
	
	//重生點相關
	public final static String SPAWN_SET = Main.plugin.mc.getString("SPAWN_SET", title + "您將伺服器公共重生點設置於此");
	public final static String SPAWN_SET_COOLDOWN = Main.plugin.mc.getString("SPAWN_SET_COOLDOWN", "§f§l您的重生點§6設置§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String SPAWN_TP = Main.plugin.mc.getString("SPAWN_TP", title + "將您傳送至伺服器公共重生點");
	public final static String SPAWN_TP_COOLDOWN = Main.plugin.mc.getString("SPAWN_TP_COOLDOWN", "§f§l您的重生點§6傳送§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String SPAWN_LOGIN = Main.plugin.mc.getString("SPAWN_LOGIN", "登入此伺服器時系統設定玩家自動傳送回重生點! (避免玩家在一些奇奇怪怪的地方下線以至於上線時被圍毆之類的)");
	
	//家相關
	public final static String HOME_SET_HOME1 = Main.plugin.mc.getString("HOME_SET", "已設置您的 Home1 點");
	public final static String HOME_SET_HOME2 = Main.plugin.mc.getString("HOME_SET", "已設置您的 Home2 點");
	public final static String HOME_SET_HOME3 = Main.plugin.mc.getString("HOME_SET", "已設置您的 Home3 點");
	public final static String HOME_SET_COOLDOWN = Main.plugin.mc.getString("HOME_SET_COOLDOWN", "§f§l您的家§6設置§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String HOME_PUTNAME = Main.plugin.mc.getString("HOME_SET_PUTNAME", "請輸入指定Home點");
	public final static String HOME_TP_HOME1 = Main.plugin.mc.getString("HOME_TP", "已將您傳送至您的 home1");
	public final static String HOME_TP_HOME2 = Main.plugin.mc.getString("HOME_TP", "已將您傳送至您的 home2");
	public final static String HOME_TP_HOME3 = Main.plugin.mc.getString("HOME_TP", "已將您傳送至您的 home3");
	public final static String HOME_TP_COOLDOWN = Main.plugin.mc.getString("HOME_TP_COOLDOWN", "§f§l您的家§6傳送§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	
	//時間相關
	public final static String TIME_DAY = Main.plugin.mc.getString("TIME_DAY", title + "您將所在世界更改時間至 (早上)");
	public final static String TIME_NIGHT = Main.plugin.mc.getString("TIME_NIGHT", title + "您將所在世界更改時間至 (晚上)");
	
	//傳送相關
	public final static String TELEPORT_TOPLAYER = Main.plugin.mc.getString("TELEPORT_TOPLAYER", title + "已將您傳送至目標玩家");
	
	//Ping相關
	public final static String PINGNORMAL = Main.plugin.mc.getString("PINGNORMAL", title + "您的PING值目前正常§a (%d)§f，請安心遊玩!");
	public final static String PINGERROR = Main.plugin.mc.getString("PINGERROR", title + "您的PING值已經高達200以上§c (%d)§f，請檢察網路是否有問題!!");
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;
		
		//就是不給你用
		message.set("HAVENOPERMISSION", HAVENOPERMISSION);
		
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
		
		//重生點相關
		message.set("SPAWN_SET", SPAWN_SET);
		message.set("SPAWN_SET_COOLDOWN", SPAWN_SET_COOLDOWN);
		message.set("SPAWN_TP", SPAWN_TP);
		message.set("SPAWN_TP_COOLDOWN", SPAWN_TP_COOLDOWN);
		message.set("SPAWN_LOGIN", SPAWN_LOGIN);
		
		//家相關
		message.set("HOME_SET_HOME1", HOME_SET_HOME1);
		message.set("HOME_SET_HOME2", HOME_SET_HOME2);
		message.set("HOME_SET_HOME3", HOME_SET_HOME3);
		message.set("HOME_SET_COOLDOWN", HOME_SET_COOLDOWN);
		message.set("HOME_SET_PUTNAME", HOME_PUTNAME);
		message.set("HOME_TP_HOME1", HOME_TP_HOME1);
		message.set("HOME_TP_HOME2", HOME_TP_HOME2);
		message.set("HOME_TP_HOME3", HOME_TP_HOME3);
		message.set("HOME_TP_COOLDOWN", HOME_TP_COOLDOWN);
		
		//時間相關
		message.set("TIME_DAY", TIME_DAY);
		message.set("TIME_NIGHT", TIME_NIGHT);
		
		//傳送相關
		message.set("TELEPORT_TOPLAYER", TELEPORT_TOPLAYER);
		
		//Ping相關
		message.set("PINGNORMAL", PINGNORMAL);
		message.set("PINGERROR", PINGERROR);
		
		Main.plugin.SystemReLoad();
	}
}
