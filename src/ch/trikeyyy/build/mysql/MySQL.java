package ch.trikeyyy.build.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import com.mysql.jdbc.Connection;

public class MySQL {
	
	public static String HOST = "";
	public static String DATABASE = "";
	public static String USER = "";
	public static String PASSWORD = "";
	public static Connection con;
	
	public MySQL(String hostname, String database, String user, String password) {
		this.HOST = hostname;
		this.DATABASE = database;
		this.USER = user;
		this.PASSWORD = password;
	}
	
	public MySQL connect() {
		
		try {
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoConnect=true", USER, PASSWORD);
			
			Bukkit.getConsoleSender().sendMessage("§8[§6MySQL§8] §aDie Verbindung zur MySQL wurde hergestellt!");
			
		} catch (SQLException e) {

			infoStaff(e);
			
		}
		
		return this;
	}
	
	public static Connection getConnection() {
		
		return con;
		
	}
	
	public static void createTable(String table, String values) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS " + table + " (" + values + ")");
			ps.execute();
			
		} catch (SQLException e) {
			
			infoStaff(e);
			
		}
	}
	
	public static void infoStaff(Exception e) {
		Bukkit.broadcastMessage("§8[§cERROR§8] §c" + e.getLocalizedMessage());
	}

}
