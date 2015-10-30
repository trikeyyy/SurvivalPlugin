package ch.trikeyyy.build.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
	
	@EventHandler
	public void setDeathMessage(PlayerDeathEvent event) {
		
		Player p = event.getEntity();
		
		event.setDeathMessage(null);
	}

}
