package ch.trikeyyy.build.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ch.trikeyyy.build.contents.Methods;
import ch.trikeyyy.build.contents.Resources;

public class Build extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		
		Resources.instance = this;
		Methods.setUp();
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
