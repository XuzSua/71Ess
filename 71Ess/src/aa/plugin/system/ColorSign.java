package aa.plugin.system;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class ColorSign implements Listener
{
	@EventHandler
	public void signColor(SignChangeEvent e)
	{
		for (int i = 0 ; i < e.getLines().length ; i++)
		{
			e.setLine( i , e.getLine(i).replaceAll( "&" , "§" ));
		}
	}
}
