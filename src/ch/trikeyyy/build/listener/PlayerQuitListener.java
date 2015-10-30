package ch.trikeyyy.build.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
	
	@EventHandler
	public void WelcomePlayer(PlayerQuitEvent event) {
		
//		Player p = event.getPlayer();		
		
		event.setQuitMessage(null);
		
	}

}
