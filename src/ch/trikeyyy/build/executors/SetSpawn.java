package ch.trikeyyy.build.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.LocationManager;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("build.setspawn")) {
				
				LocationManager.setLocation(p, "spawnlocation", p.getLocation());
				
			}
			
		}
		
		return true;
	}

}
