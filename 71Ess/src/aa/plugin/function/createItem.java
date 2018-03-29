package aa.plugin.function;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class createItem
{
	
	public static ItemStack createItems(Material material, int subID, String displayname, String lore)
	{
		ItemStack itemS = new ItemStack(material, 1, (short) subID);
		ItemMeta itemM = itemS.getItemMeta();
		ArrayList<String> itemL = new ArrayList<String>();
		itemL.add(lore);
		itemM.setLore(itemL);
		itemM.setDisplayName(displayname);
		itemS.setItemMeta(itemM);
		
		return itemS;
	}
	
}
