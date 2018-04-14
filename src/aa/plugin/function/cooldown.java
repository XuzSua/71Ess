package aa.plugin.function;

import aa.plugin.main.GlobalVar;

public class cooldown 
{
	 // 冷卻檢查
    public static Boolean CooldownCheck(String CooldownName) {
        // 判斷是否存在冷卻
        if (GlobalVar.CooldownMap.containsKey(CooldownName)) {
            // 判斷冷卻時間是否已過
            if (GlobalVar.CooldownMap.get(CooldownName) > System.currentTimeMillis()) {
                return false;
            } else {
                GlobalVar.CooldownMap.remove(CooldownName);
            }
        }
        return true;
    }

    // 冷卻設定
    public static void CooldownSet(String CooldownName, Integer Sec) {
        // 判斷是否存在冷卻
        if (GlobalVar.CooldownMap.containsKey(CooldownName)) {
            GlobalVar.CooldownMap.replace(CooldownName, System.currentTimeMillis() + (Sec * 1000));
        } else {
            GlobalVar.CooldownMap.put(CooldownName, System.currentTimeMillis() + (Sec * 1000));
        }
    }

    // 冷卻設定
    public static void CooldownSetByMillisecond(String CooldownName, Integer Millisecond) {
        // 判斷是否存在冷卻
        if (GlobalVar.CooldownMap.containsKey(CooldownName)) {
            GlobalVar.CooldownMap.replace(CooldownName, System.currentTimeMillis() + Millisecond);
        } else {
            GlobalVar.CooldownMap.put(CooldownName, System.currentTimeMillis() + Millisecond);
        }
    }
}
