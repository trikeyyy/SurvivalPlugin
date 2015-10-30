package ch.trikeyyy.build.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.LocationManager;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			p.teleport(LocationManager.getLocation("spawnlocation"));
			
		}
		
		return true;
	}

}
