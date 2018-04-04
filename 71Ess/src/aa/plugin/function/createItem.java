package aa.plugin.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class createItem
{
	
	public static ItemStack createItemsForICON(Material material, int subID, int amount, String displayname, List<String> itemLore)
	{
		ItemStack itemS = new ItemStack(material, amount, (short) subID);
		ItemMeta itemM = itemS.getItemMeta();
		ArrayList<String> itemL = new ArrayList<String>();
		itemM.setDisplayName(displayname);
		
		if (itemLore != null)
		{
			for (int loreLine = 0 ; loreLine < itemLore.size(); loreLine++)
			{
				itemL.add(loreLine, itemLore.get(loreLine));
			}
		}
		itemM.setLore(Arrays.asList(itemL.toArray(new String[itemL.size()])));
		itemS.setItemMeta(itemM);
		
		return itemS;
	}

	public static ItemStack createItemsForGUI(Material material, int subID, String displayname, String itemLore)
	{
		ItemStack itemS = new ItemStack(material, 1, (short) subID);
		ItemMeta itemM = itemS.getItemMeta();
		ArrayList<String> itemL = new ArrayList<String>();
		itemM.setDisplayName(displayname);
		itemM.setLore(itemL);
		itemS.setItemMeta(itemM);

		return itemS;
	}
	
}
