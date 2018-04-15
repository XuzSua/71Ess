package aa.plugin.system;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import aa.plugin.main.GUIs.TpaGUI;

public class Tpa implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		if (sender instanceof Player)
		{
			
			Player player = (Player) sender;
			if (args.length == 0) TpaGUI.teleportGUI(player);
			
			
		}
		return false;
	}

}
