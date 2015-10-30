package ch.trikeyyy.build.contents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.main.Build;

public class Resources {
	
	/*
	 * Instanzen
	 */
	public static Build instance;
	
	
	/*
	 * Strings
	 */
	public static String prefix = "§6Build §7᚛ ";
	
	
	/*
	 * HashMaps
	 */
	public static HashMap<Player, Integer> kitInventory = new HashMap<>();
	public static HashMap<Player, Integer> kitInteger = new HashMap<>();
	
	
	/*
	 * Lists
	 */
	public static List<Player> kitstandard = new ArrayList<>();
	public static List<Player> kitpremium = new ArrayList<>();
	public static List<Player> kitpremiumplus = new ArrayList<>();
	
	
	/*
	 * Integer
	 */
	public static Integer removeAllItems;

}
