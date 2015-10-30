package ch.trikeyyy.build.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class StatsManager {
	
	public static boolean playerExists(String uuid) {
		
		try {
			
			PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = ?");
			ps1.setString(1, uuid);
			ResultSet rs1 = ps1.executeQuery();
			
			return rs1.next();
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			return false;
			
		}
		
	}
	
	public static void createPlayer(Player p) {
		
		try {
			
			PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO JumpLeague (`uuid`, `playername`, `kills`, `deaths`, `wins`, `losts`) VALUES ('" + getUUID(p) + "', '" +p.getName()+ "', '0', '0', '0', '0')");
			ps.execute();
		
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
	}
	
	public static Integer getKills(String uuid) {
		
		try {

			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = '"+uuid+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return rs.getInt("kills");
				
			}
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
		return 0;
		
		
	}
	
	public static Integer getDeaths(String uuid) {
		
		try {

			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = '"+uuid+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return rs.getInt("deaths");
				
			}
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
		return 0;
		
		
	}
	
	public static Integer getWins(String uuid) {
		
		try {

			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = '"+uuid+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return rs.getInt("wins");
				
			}
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
		return 0;
		
		
	}
	
	public static Integer getLosts(String uuid) {
		
		try {
			
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = '"+uuid+"'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return rs.getInt("losts");
				
			}
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
		return 0;
		
		
	}
	
	public static void addKills(Player p, Integer amount) {
		
		PreparedStatement ps;
		try {
			
			ps = MySQL.getConnection().prepareStatement("UPDATE JumpLeague SET kills = ? WHERE uuid = '"+p.getUniqueId().toString()+"'");
			ps.setInt(1, getKills(getUUID(p)) + amount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
	}
	
	
	public static void addDeaths(Player p, Integer amount) {
		
		PreparedStatement ps;
		try {

			ps = MySQL.getConnection().prepareStatement("UPDATE JumpLeague SET deaths = ? WHERE uuid = '"+p.getUniqueId().toString()+"'");
			ps.setInt(1, getDeaths(getUUID(p)) + amount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
	}
	
	public static void addWins(Player p, Integer amount) {
		
		PreparedStatement ps;
		try {

			ps = MySQL.getConnection().prepareStatement("UPDATE JumpLeague SET wins = ? WHERE uuid = '"+p.getUniqueId().toString()+"'");
			ps.setInt(1, getWins(getUUID(p)) + amount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
	}
	
	public static void addLosts(Player p, Integer amount) {
		
		PreparedStatement ps;
		try {

			ps = MySQL.getConnection().prepareStatement("UPDATE JumpLeague SET losts = ? WHERE uuid = '"+p.getUniqueId().toString()+"'");
			ps.setInt(1, getLosts(getUUID(p)) + amount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
	}
	
	public static void updatePlayername(Player p) {
		
		PreparedStatement ps;
		
		try {
			
			ps = MySQL.getConnection().prepareStatement("SELECT * FROM JumpLeague WHERE uuid = '" + getUUID(p) + "'");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				if(rs.getString("playername") != p.getName()) {
					
					ps = MySQL.getConnection().prepareStatement("UPDATE JumpLeague SET playername = ? WHERE uuid = '"+getUUID(p)+"'");
					ps.setString(1, p.getName());
					ps.executeUpdate();
					
					
				}
				
			}
			
			
		} catch(SQLException e) {
			
			MySQL.infoStaff(e);
			
		}
		
		
	}
	
	
	
	
	
	
	
	public static String getUUID(Player p) {
		return p.getUniqueId().toString();
	}

}
