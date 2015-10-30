package ch.trikeyyy.build.executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.ItemBuilder;
import ch.trikeyyy.build.contents.Resources;

public class GiveAll implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(p.hasPermission("build.giveall")) {
				
				if(args.length == 2) {
				
					int id = 1;
					byte subid = 0;
					int amount = 1;
					
					String[] idstring = args[0].split(":");
					
					try {
						
						id = Integer.parseInt(idstring[0]);
						
						amount = Integer.parseInt(args[1]);
						
						if(args[0].contains(":")) {
							
							subid = Byte.parseByte(idstring[1]);
							
						}
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							
							all.getInventory().addItem(new ItemBuilder(id, amount, subid).build());
							
						}
						
					} catch(NumberFormatException e) {
						
						p.sendMessage(Resources.prefix + "§cUngültige Zahlen!");
						
					}
					
				} else {
					
					p.sendMessage(Resources.prefix + "§c/giveall <id:subid> <amount>");
					
				}
				
			}
			
		}
		
		return true;
	}

}
