package ch.trikeyyy.build.contents;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
	
	public static File locationFile;
	public static FileConfiguration locations;
	public static File clanFile;
	public static FileConfiguration clans;
	
	public static void createFile() {
		if(!locationFile.exists()){
			try {
				locationFile.createNewFile();
			} catch (IOException e) {
				System.out.println("" + e.getLocalizedMessage());
			}
	    }
		
		if(!clanFile.exists()){
			try {
				clanFile.createNewFile();
			} catch (IOException e) {
				System.out.println("" + e.getLocalizedMessage());
			}
	    }
	}
	
	public static void setUp() {
		FileManager.locationFile = new File(Methods.getInstance().getDataFolder(), "locations.yml");
		try {
			FileManager.createFile();
			locations = new YamlConfiguration();
			loadYamls();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileManager.clanFile = new File(Methods.getInstance().getDataFolder(), "clans.yml");
		try {
			FileManager.createFile();
			clans = new YamlConfiguration();
			loadYamls();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void saveYamls() {
	    try {
	        locations.save(locationFile);
	    } catch (IOException e) {
	    	Bukkit.broadcastMessage("§8[§cERROR§8] §c" + e.getLocalizedMessage());
	        e.printStackTrace();
	    }
	    
	    try {
	        clans.save(clanFile);
	    } catch (IOException e) {
	    	Bukkit.broadcastMessage("§8[§cERROR§8] §c" + e.getLocalizedMessage());
	        e.printStackTrace();
	    }
	    
	}
	public static void loadYamls() {
	    try {
	        locations.load(locationFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    try {
	        clans.load(clanFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
	
}
