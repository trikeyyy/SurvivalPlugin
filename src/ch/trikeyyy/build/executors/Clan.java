package ch.trikeyyy.build.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clan implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length >= 1) {
				
				
				
			} else {
				
				p.sendMessage("§7᚛  §6Clans");
				p.sendMessage("§a/clan erstellen <Clanname>");
				p.sendMessage("§a/clan kick <Spieler>");
				p.sendMessage("§a/clan base");
				p.sendMessage("§a/clan info");
				p.sendMessage("§a/clan setbase");
				p.sendMessage("§a/clan verlassen");
				p.sendMessage("§a/clan löschen");
				
			}
			
		}
		
		return true;
	}

}
