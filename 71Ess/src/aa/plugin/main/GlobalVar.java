package aa.plugin.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

public class GlobalVar
{
	//冷卻
	public static HashMap<String, Long> CooldownMap = new HashMap<String, Long>();
	//FLYCHECK
	public static List<Player> playerFlyMods = new ArrayList<>();
}
