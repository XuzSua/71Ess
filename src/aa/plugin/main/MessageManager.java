package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 :§f";
	
	//就是不給你用
	public final static String HAVENOPERMISSION = Main.plugin.mc.getString("HAVENOPERMISSION", "不給你用");
	
	//遊戲模式
	public final static String GAMEMODE_TOPLAYER = Main.plugin.mc.getString("GAMEMODE_TOPLAYER", title + "已將目標玩家的遊戲模式更改為 (%s)");
	public final static String GAMEMODE_HASBEENCHANGE = Main.plugin.mc.getString("GAMEMODE_HASBEENCHANGE", title + "您的遊戲模式被管理員更改為 (%s)");
	public final static String GAMEMODE_CHANGE = Main.plugin.mc.getString("GAMEMODE_CHANGE", title + "已將您的遊戲模式更改為 (%s)");
	
	//無敵模式
	public final static String GOD_ENABLE = Main.plugin.mc.getString("GOD_ENABLE", title + "已將您的無敵模式§a啟用");
	public final static String GOD_DISABLE = Main.plugin.mc.getString("GOD_DISABLE", title + "已將您的無敵模式§c關閉");
	
	//重生點相關
	public final static String SPAWN_SET = Main.plugin.mc.getString("SPAWN_SET", title + "您將伺服器公共重生點設置於此");
	public final static String SPAWN_SET_COOLDOWN = Main.plugin.mc.getString("SPAWN_SET_COOLDOWN", "§f§l您的重生點§6設置§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String SPAWN_TP = Main.plugin.mc.getString("SPAWN_TP", title + "將您傳送至伺服器公共重生點");
	public final static String SPAWN_TP_COOLDOWN = Main.plugin.mc.getString("SPAWN_TP_COOLDOWN", "§f§l您的重生點§6傳送§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String SPAWN_LOGIN = Main.plugin.mc.getString("SPAWN_LOGIN", "登入此伺服器時系統設定玩家自動傳送回重生點! (避免玩家在一些奇奇怪怪的地方下線以至於上線時被圍毆之類的)");
	
	//家相關
	public final static String HOME_SET_HOME = Main.plugin.mc.getString("HOME_SET", "已設置您的 %s 點");
	public final static String HOME_SET_COOLDOWN = Main.plugin.mc.getString("HOME_SET_COOLDOWN", "§f§l您的家§6設置§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String HOME_PUTNAME = Main.plugin.mc.getString("HOME_SET_PUTNAME", "請輸入指定Home點");
	public final static String HOME_TP_HOME = Main.plugin.mc.getString("HOME_TP", "已將您傳送至您的 %s 點");
	public final static String HOME_TP_COOLDOWN = Main.plugin.mc.getString("HOME_TP_COOLDOWN", "§f§l您的家§6傳送§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String HOME_TP_POINT_NOT_EXIST = Main.plugin.mc.getString("HOME_TP_POINT_NOT_EXIST","點 %d 尚未設置，所以無法傳送");
	
	//時間相關
	public final static String TIME_DAY = Main.plugin.mc.getString("TIME_DAY", title + "您將所在世界更改時間至 (早上)");
	public final static String TIME_NIGHT = Main.plugin.mc.getString("TIME_NIGHT", title + "您將所在世界更改時間至 (晚上)");
	
	//傳送相關
	public final static String TELEPORT_TOPLAYER = Main.plugin.mc.getString("TELEPORT_TOPLAYER", title + "已將您傳送至 %s");
	public final static String TELEPORT_TARGETNOTFOUND = Main.plugin.mc.getString("TELEPORT_TARGETNOTFOUND", title + "該玩家並不在線上 %s");
	
	//Ping相關
	public final static String PINGNORMAL = Main.plugin.mc.getString("PINGNORMAL", title + "PING值目前正常§a (%d)§f，請安心遊玩!");
	public final static String PINGERROR = Main.plugin.mc.getString("PINGERROR", title + "PING值已經高達200以上§c (%d)§f，請檢察網路是否有問題!!");
	
	//FLY
	public final static String FLY_SET_TRUE = Main.plugin.mc.getString("FLY_SET_TRUE", title + "您的飛行模式已被§a開啟");
	public final static String FLY_SET_FALSE = Main.plugin.mc.getString("FLY_SET_TRUE", title + "您的飛行模式已被§c關閉");
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;
		
		//就是不給你用
		message.get("HAVENOPERMISSION", HAVENOPERMISSION);
		
		//遊戲模式
		message.get("GAMEMODE_TOPLAYER", GAMEMODE_TOPLAYER);
		message.get("GAMEMODE_HASBEENCHANGE", GAMEMODE_HASBEENCHANGE);
		message.get("GAMEMODE_CHANGE ", GAMEMODE_CHANGE);
	
		//重生點相關
		message.get("SPAWN_SET", SPAWN_SET);
		message.get("SPAWN_SET_COOLDOWN", SPAWN_SET_COOLDOWN);
		message.get("SPAWN_TP", SPAWN_TP);
		message.get("SPAWN_TP_COOLDOWN", SPAWN_TP_COOLDOWN);
		message.get("SPAWN_LOGIN", SPAWN_LOGIN);
		
		//家相關
		message.get("HOME_SET_HOME1", HOME_SET_HOME);
		message.get("HOME_SET_COOLDOWN", HOME_SET_COOLDOWN);
		message.get("HOME_SET_PUTNAME", HOME_PUTNAME);
		message.get("HOME_TP_HOME1", HOME_TP_HOME);
		message.get("HOME_TP_COOLDOWN", HOME_TP_COOLDOWN);
		message.get("HOME_TP_POINT_NOT_EXIST", HOME_TP_POINT_NOT_EXIST);
		
		//時間相關
		message.get("TIME_DAY", TIME_DAY);
		message.get("TIME_NIGHT", TIME_NIGHT);
		
		//傳送相關
		message.get("TELEPORT_TOPLAYER", TELEPORT_TOPLAYER);
		message.get("TELEPORT_TARGETNOTFOUND", TELEPORT_TARGETNOTFOUND);
		
		//Ping相關
		message.get("PINGNORMAL", PINGNORMAL);
		message.get("PINGERROR", PINGERROR);
		
		//FLY
		message.get("FLY_SET_TRUE", FLY_SET_TRUE);
		message.get("FLY_SET_FALSE", FLY_SET_FALSE);
		
		Main.plugin.SystemReLoad();
	}
}