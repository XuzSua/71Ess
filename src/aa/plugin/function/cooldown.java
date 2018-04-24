package aa.plugin.function;

import java.util.HashMap;

public class cooldown 
{
	static HashMap<String, Long> CooldownMap = new HashMap<String, Long>();
	
	 // 冷卻檢查
    public static Boolean CooldownCheck(String CooldownName) {
        // 判斷是否存在冷卻
        if (CooldownMap.containsKey(CooldownName)) {
            // 判斷冷卻時間是否已過
            if (CooldownMap.get(CooldownName) > System.currentTimeMillis()) {
                return false;
            } else {
                CooldownMap.remove(CooldownName);
            }
        }
        return true;
    }

    // 冷卻設定
    public static void CooldownSet(String CooldownName, Integer Sec) {
        // 判斷是否存在冷卻
        if (CooldownMap.containsKey(CooldownName)) {
            CooldownMap.replace(CooldownName, System.currentTimeMillis() + (Sec * 1000));
        } else {
            CooldownMap.put(CooldownName, System.currentTimeMillis() + (Sec * 1000));
        }
    }

    // 冷卻設定 
    public static void CooldownSetByMillisecond(String CooldownName, Integer Millisecond) {
        // 判斷是否存在冷卻
        if (CooldownMap.containsKey(CooldownName)) {
            CooldownMap.replace(CooldownName, System.currentTimeMillis() + Millisecond);
        } else {
            CooldownMap.put(CooldownName, System.currentTimeMillis() + Millisecond);
        }
    }
}
