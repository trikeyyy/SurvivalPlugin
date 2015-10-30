package ch.trikeyyy.build.executors;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.Resources;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("build.gamemode")) {
				
				if(args.length == 1) {
				
					if(args[0].equalsIgnoreCase("0")
					|| args[0].equalsIgnoreCase("survival")) {
	
						p.setGameMode(GameMode.SURVIVAL);
						
					}
					
					if(args[0].equalsIgnoreCase("1")
					|| args[0].equalsIgnoreCase("creative")) {
	
						p.setGameMode(GameMode.CREATIVE);
						
					}
					
					if(args[0].equalsIgnoreCase("2")
					|| args[0].equalsIgnoreCase("adventure")) {
	
						p.setGameMode(GameMode.ADVENTURE);
						
					}
					
					if(args[0].equalsIgnoreCase("3")
					|| args[0].equalsIgnoreCase("spectator")) {
						
						p.setGameMode(GameMode.SPECTATOR);
						
					}
					
				} else
					
					
					if(args.length == 2) {
						
						if(Bukkit.getPlayer(args[1]).isOnline()) {
							
							Player target = Bukkit.getPlayer(args[1]);
						
							if(args[0].equalsIgnoreCase("0")
							|| args[0].equalsIgnoreCase("survival")) {
			
								target.setGameMode(GameMode.SURVIVAL);
								
							}
							
							if(args[0].equalsIgnoreCase("1")
							|| args[0].equalsIgnoreCase("creative")) {
			
								target.setGameMode(GameMode.CREATIVE);
								
							}
							
							if(args[0].equalsIgnoreCase("2")
							|| args[0].equalsIgnoreCase("adventure")) {
			
								target.setGameMode(GameMode.ADVENTURE);
								
							}
							
							if(args[0].equalsIgnoreCase("3")
							|| args[0].equalsIgnoreCase("spectator")) {
								
								target.setGameMode(GameMode.SPECTATOR);
								
							}
							
						} else {
							
							p.sendMessage(Resources.prefix + "§cSpieler ist nicht online!");
							
						}
					
				} else {
					
					p.sendMessage(Resources.prefix + "§c/gamemode <0,1,2,3> (Player)");
					
				}
				
			}
			
		}
		
		return true;
	}

}
