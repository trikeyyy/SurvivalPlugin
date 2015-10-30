package ch.trikeyyy.build.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import ch.trikeyyy.build.contents.FileManager;
import ch.trikeyyy.build.contents.Resources;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder;
import net.minecraft.server.v1_8_R3.WorldBorder;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder.EnumWorldBorderAction;

public class ClanManager {
	
	public static boolean doesExist(String clanname) {
		
		try {
			
			PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT * FROM Clan WHERE clan = ?");
			ps1.setString(1, clanname);
			ResultSet rs1 = ps1.executeQuery();
			
			return rs1.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	public static void createClan(String clanname, Player leader) {
		
		if(!doesExist(clanname)) {
			
			PreparedStatement ps;
			
			try {
				
				ps = MySQL.getConnection().prepareStatement("INSERT INTO Clan (leaderuuid varchar(100), leadername varchar(100), clan varchar(100)) VALUES ?, ?, ?");
				ps.setString(1, leader.getUniqueId().toString());
				ps.setString(2, leader.getName());
				ps.setString(3, clanname);
				ps.execute();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static boolean isLeader(String clanname, Player leader) {
		
		try {
			
			PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT * FROM Clan WHERE clan = ?");
			ps1.setString(1, clanname);
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				
				if(rs1.getString("leaderuuid") == leader.getUniqueId().toString()) {
					
					return true;
					
				}
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	public static String getClanName(Player p) {
		
		try {
			
			PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT * FROM Stats WHERE uuid = ?");
			ps1.setString(1, p.getUniqueId().toString());
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				
				return rs1.getString("clan");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return "Du bist in keinem Clan!";
		
	}
	
	public static void setClanBase(Player leader, String clanname) {
		
		if(isLeader(clanname, leader)) {
			
			Location loc = leader.getLocation();
			
			String w = loc.getWorld().getName();
			double x = loc.getX();
			double y = loc.getY();
			double z = loc.getZ();
			double yaw = loc.getYaw();
			double pitch = loc.getPitch();

			FileManager.clans.set(clanname + ".World", w);
			FileManager.clans.set(clanname + ".PosX", x);
			FileManager.clans.set(clanname + ".PosY", y);
			FileManager.clans.set(clanname + ".PosZ", z);
			FileManager.clans.set(clanname + ".Yaw", yaw);
			FileManager.clans.set(clanname + ".Pitch", pitch);
			
			leader.sendMessage(Resources.prefix + "§aClan Base erfolgreich erstellt!");
			
		}
		
	}
	
	public static void teleportToClanBase(String clanname, Player p) {
		
		if(doesExist(clanname)) {
		
			String w = FileManager.clans.getString(clanname + ".World");
			double x = FileManager.clans.getDouble(clanname + ".PosX");
			double y = FileManager.clans.getDouble(clanname + ".PosY");
			double z = FileManager.clans.getDouble(clanname + ".PosZ");
			double yaw = FileManager.clans.getDouble(clanname + ".Yaw");
			double pitch = FileManager.clans.getDouble(clanname + ".Pitch");
			
			Location loc = new Location(Bukkit.getWorld(w), x, y, z);
			loc.setYaw((float) yaw);
			loc.setPitch((float) pitch);
			
			p.teleport(loc);
			
		} else {
			
			p.sendMessage(Resources.prefix + "§cDein Clan hat keine Base!");
			
		}
	}

}
