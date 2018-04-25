package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 : §f";
	
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
	public final static String TELEPORT_TARGETNOTFOUND = Main.plugin.mc.getString("TELEPORT_TARGETNOTFOUND", title + "該玩家並不在線上 §6§l%s");
	public final static String TELEPORT_PLAYERTOPLAYER = Main.plugin.mc.getString("TELEPORT_PLAYERTOPLAYER", title + "已將指定玩家傳送至 §6§l%s");
	public final static String TELEPORT_PLAYERHASBEENTP = Main.plugin.mc.getString("TELEPORT_PLAYERHASBEENTP", title + "您已被傳送到目標玩家 §6§%s");
	
	public final static String TPC_TARGETNOTFOUND = Main.plugin.mc.getString("TPC_TARGETNOTFOUND", title + "找不到該玩家 §6§l%s");
	public final static String TPC_ERRORCOMMAND = Main.plugin.mc.getString("TPC_ERRORCOMMAND", title + "請輸入正確的指令 /tpc <Player> <X> <Y> <Z>");
	public final static String TPC_TELEPORTDONE = Main.plugin.mc.getString("TPC_TELEPORTDONE", title + "將您傳送至 X: %.3f Y: %.3f Z: %.3f");
	public final static String TPA_INVITE_COOLDOWN = Main.plugin.mc.getString("TPA_INVITE_COOLDOWN", title + "§f§l您的§a傳送邀請§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	
	//Ping相關
	public final static String PINGNORMAL = Main.plugin.mc.getString("PINGNORMAL", title + "PING值目前正常§a (%d)§f，請安心遊玩!");
	public final static String PINGERROR = Main.plugin.mc.getString("PINGERROR", title + "PING值已經高達200以上§c (%d)§f，請檢察網路是否有問題!!");
	
	//FLY
	public final static String FLY_SET_TRUE = Main.plugin.mc.getString("FLY_SET_TRUE", title + "您的飛行模式已被§a開啟");
	public final static String FLY_SET_FALSE = Main.plugin.mc.getString("FLY_SET_TRUE", title + "您的飛行模式已被§c關閉");
	
	//私訊
	public final static String TELL_ERRORCOMMAND = Main.plugin.mc.getString("TELL_ERRORCOMMAND", title + "/msg <玩家> <訊息>");
	public final static String TELL_PLAYERNULL = Main.plugin.mc.getString("TELL_PLAYERNULL", title + "找不到目標玩家!");
	
	//告示牌編輯
	public final static String SIGNEDITOR_COPYING = Main.plugin.mc.getString("SIGNEDITOR_COPYING", title + "§f§l您複製一個告示牌 §a蹲下 + 左鍵 §f§l其他告示牌完成貼上");
	public final static String SIGNEDITOR_PASTING = Main.plugin.mc.getString("SIGNEDITOR_PASTING", title + "§f§l您完成 §a貼上 §f動作");
	
	//回血
	public final static String HEAL_PLAYER = Main.plugin.mc.getString("HEAL_PLAYERNOTFOUND", title + "§f§l已將該玩家的狀態回滿 §6§l%s");
	public final static String HEAL_PLAYERNOTFOUND = Main.plugin.mc.getString("TELEPORT_TARGETNOTFOUND", title + "該玩家並不在線上 §6§l%s");
	
	//Afk
	public final static String AFK_COOLDOWN = Main.plugin.mc.getString("AFK_COOLDOWN", title + "§f§l您的§a掛機§f§l指令正於冷卻當中 (冷卻時間為 5 秒鐘一次)");
	public final static String AFK_ENABLE = Main.plugin.mc.getString("AFK_ENABLE", title + "您已§a進入§f掛機模式 無法受到任何傷害!");
	public final static String AFK_DISABLE = Main.plugin.mc.getString("AFK_DISABLE", title + "您已§c離開§f掛機模式");
	
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;
		
		//就是不給你用
		message.set("HAVENOPERMISSION", HAVENOPERMISSION);
		
		//遊戲模式
		message.set("GAMEMODE_TOPLAYER", GAMEMODE_TOPLAYER);
		message.set("GAMEMODE_HASBEENCHANGE", GAMEMODE_HASBEENCHANGE);
		message.set("GAMEMODE_CHANGE ", GAMEMODE_CHANGE);
	
		//重生點相關
		message.set("SPAWN_SET", SPAWN_SET);
		message.set("SPAWN_SET_COOLDOWN", SPAWN_SET_COOLDOWN);
		message.set("SPAWN_TP", SPAWN_TP);
		message.set("SPAWN_TP_COOLDOWN", SPAWN_TP_COOLDOWN);
		message.set("SPAWN_LOGIN", SPAWN_LOGIN);
		
		//家相關
		message.set("HOME_SET_HOME1", HOME_SET_HOME);
		message.set("HOME_SET_COOLDOWN", HOME_SET_COOLDOWN);
		message.set("HOME_SET_PUTNAME", HOME_PUTNAME);
		message.set("HOME_TP_HOME1", HOME_TP_HOME);
		message.set("HOME_TP_COOLDOWN", HOME_TP_COOLDOWN);
		message.set("HOME_TP_POINT_NOT_EXIST", HOME_TP_POINT_NOT_EXIST);
		
		//時間相關
		message.set("TIME_DAY", TIME_DAY);
		message.set("TIME_NIGHT", TIME_NIGHT);
		
		//傳送相關
		message.set("TELEPORT_TOPLAYER", TELEPORT_TOPLAYER);
		message.set("TELEPORT_TARGETNOTFOUND", TELEPORT_TARGETNOTFOUND);
		message.set("TELEPORT_PLAYERTOPLAYER", TELEPORT_PLAYERTOPLAYER);
		message.set("TELEPORT_PLAYERHASBEENTP", TELEPORT_PLAYERHASBEENTP);
		message.set("TPC_TARGETNOTFOUND", TPC_TARGETNOTFOUND);
		message.set("TPC_ERRORCOMMAND", TPC_ERRORCOMMAND);
		message.set("TPC_TELEPORTDONE", TPC_TELEPORTDONE);
		message.set("TPA_INVITE_COOLDOWN", TPA_INVITE_COOLDOWN);
		
		//Ping相關
		message.set("PINGNORMAL", PINGNORMAL);
		message.set("PINGERROR", PINGERROR);
		
		//FLY
		message.set("FLY_SET_TRUE", FLY_SET_TRUE);
		message.set("FLY_SET_FALSE", FLY_SET_FALSE);
		
		//私訊
		message.set("TELL_PLAYERNULL", TELL_PLAYERNULL);
		message.set("TELL_ERRORCOMMAND", TELL_ERRORCOMMAND);
		
		//告示牌編輯
		message.set("SIGNEDITOR_COPYING", SIGNEDITOR_COPYING);
		message.set("SIGNEDITOR_PASTING", SIGNEDITOR_PASTING);
		
		//回血
		message.set("HEAL_PLAYERNOTFOUND", HEAL_PLAYERNOTFOUND);
		
		//Afk
		message.set("AFK_COOLDOWN", AFK_COOLDOWN);
		message.set("AFK_ENABLE", AFK_ENABLE);
		message.set("AFK_DISABLE", AFK_DISABLE);
		Main.plugin.SystemReLoad();
	}
}
