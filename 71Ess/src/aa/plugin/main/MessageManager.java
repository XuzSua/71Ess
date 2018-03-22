package aa.plugin.main;

import org.bukkit.configuration.file.FileConfiguration;

public class MessageManager
{
	public static String title = "§d系統娘 :§f";
	
	public final static String GAMEMODE_SRUVIVAL = Main.plugin.mc.getString("GAMEMODE_SRUVIVAL", title + "已將您的遊戲模式更改為 (生存模式)");
	public final static String GAMEMODE_CREATIVE = Main.plugin.mc.getString("GAMEMODE_CREATIVE", title + "已將您的遊戲模式更改為 (創造模式)");
	public final static String GAMEMODE_ADVENTURE = Main.plugin.mc.getString("GAMEMODE_ADVENTURE", title + "已將您的遊戲模式更改為 (冒險模式)");
	public final static String GAMEMODE_SPECTATOR = Main.plugin.mc.getString("GAMEMODE_SPECTATOR", title + "已將您的遊戲模式更改為 (觀察模式)");
	
	public static void CreateFile()
	{		
		FileConfiguration message = Main.plugin.mc;

		//訊息設定
		message.set("GAMEMODE_SURVIVAL", GAMEMODE_SRUVIVAL);
		message.set("GAMEMODE_CREATIVE", title + "已將您的遊戲模式更改為 (創造模式)");
		message.set("GAMEMODE_ADVENTURE", title + "已將您的遊戲模式更改為 (冒險模式)");
		message.set("GAMEMODE_SPECTATOR", title + "已將您的遊戲模式更改為 (觀察模式)");
		Main.plugin.SystemReLoad();
	}
}
