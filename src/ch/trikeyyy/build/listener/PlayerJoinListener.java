package ch.trikeyyy.build.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ch.trikeyyy.build.contents.LocationManager;
import ch.trikeyyy.build.contents.Resources;
import ch.trikeyyy.build.mysql.StatsManager;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void WelcomePlayer(PlayerJoinEvent event) {
		
		Player p = event.getPlayer();
		
		p.sendMessage("\n" + 
					  Resources.prefix + "§aWillkommen zurück §6" + p.getName() + "§a!");
		
		
		event.setJoinMessage(null);
		
		if(!StatsManager.playerExists(p.getUniqueId().toString())) {
			
			StatsManager.createPlayer(p);
			p.teleport(LocationManager.getLocation("spawnlocation"));
			
		}
		
	}

}
