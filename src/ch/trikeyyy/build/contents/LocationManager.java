package ch.trikeyyy.build.contents;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationManager {
	
	public static String prefix = "§8[§6LocationManager§8] §e";
	
	public static void setLocation(Player p, String path, Location loc) {
		
		FileManager.locations.set(path, loc);
		FileManager.saveYamls();
		p.sendMessage(prefix + "Location §c" + path + " §eerstellt!");
	}
	
	public static Location getLocation(String path) {
		return (Location) FileManager.locations.get(path);
	}

}
