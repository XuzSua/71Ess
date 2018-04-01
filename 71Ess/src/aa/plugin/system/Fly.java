package aa.plugin.system;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import aa.plugin.main.MessageManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Fly implements CommandExecutor, Listener {

	static List<Player> playerFlyMods = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("71ess.fly")) {
			if (cmd.getName().equalsIgnoreCase("fly")) {
				if (!(playerFlyMods.contains(p))) {
					p.setAllowFlight(true);
					playerFlyMods.add(p);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.FLY_SET_TRUE));
				} else {
					p.setAllowFlight(false);
					playerFlyMods.remove(p);
					p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(MessageManager.FLY_SET_FALSE));
				}
			}
		} else {
			p.sendMessage(MessageManager.HAVENOPERMISSION);
		}
		return false;
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (playerFlyMods.contains(p)) {
				p.getWorld().spawnParticle(Particle.HEART, p.getLocation(), 30);
				// System.out.println("flying");
			}
		}
	}
}
