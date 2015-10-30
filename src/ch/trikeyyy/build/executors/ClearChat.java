package ch.trikeyyy.build.executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.Resources;

public class ClearChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("build.cc")) {
				
				for(int i = 0; i < 100; i++) {
				
					for(Player all : Bukkit.getOnlinePlayers()) {
						
						if(!all.hasPermission("build.cc")) {
							
							all.sendMessage("");
							
						}
						
					}
					
				}
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					
					all.sendMessage(Resources.prefix + "§cDer Chat wurde geleert!");
					
				}
				
			}
			
		}
		
		return true;
	}

}
