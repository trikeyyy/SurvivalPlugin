package ch.trikeyyy.build.contents;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ch.trikeyyy.build.executors.Clan;
import ch.trikeyyy.build.executors.ClearChat;
import ch.trikeyyy.build.executors.Gamemode;
import ch.trikeyyy.build.executors.GiveAll;
import ch.trikeyyy.build.executors.Kit;
import ch.trikeyyy.build.executors.SetSpawn;
import ch.trikeyyy.build.executors.Spawn;
import ch.trikeyyy.build.listener.EntityDamageListener;
import ch.trikeyyy.build.listener.InventoryClickListener;
import ch.trikeyyy.build.listener.PlayerDeathListener;
import ch.trikeyyy.build.listener.PlayerInteractListener;
import ch.trikeyyy.build.listener.PlayerJoinListener;
import ch.trikeyyy.build.listener.PlayerQuitListener;
import ch.trikeyyy.build.main.Build;
import ch.trikeyyy.build.mysql.MySQL;

public class Methods {

	public static void setUp() {

		Bukkit.getConsoleSender().sendMessage(Resources.prefix + "§aPlugin wurde geladen!");
		registerCommands();
		registerEvents();
		FileManager.setUp();
		MySQL mysql = new MySQL("db4free.net", "trikeyyy", "trikeyyy", "php01Man");
		mysql.connect();
		MySQL.createTable("Stats", "uuid varchar(100), playername varchar(100), kills varchar(100), deaths varchar(100), clan varchar(100)");
		MySQL.createTable("Clan", "leaderuuid varchar(100), leadername varchar(100), clan varchar(100)");
		
		Resources.removeAllItems = 0;
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if(Resources.removeAllItems == 0) {
					Resources.removeAllItems = 1;
				} else
				if(Resources.removeAllItems == 1) {
					Resources.removeAllItems = 2;
				} else
				if(Resources.removeAllItems == 2) {
					Resources.removeAllItems = 3;
				} else
				if(Resources.removeAllItems == 3) {
					Resources.removeAllItems = 4;
					Bukkit.broadcastMessage(Resources.prefix + "§cAlle Items werden in §6einer Minute §centfernt!");
				} else
				if(Resources.removeAllItems == 4) {
					Resources.removeAllItems = 0;
					Bukkit.broadcastMessage(Resources.prefix + "§cAlle Item wurden entfernt!");
					
					for(World w : Bukkit.getWorlds()) {
						
						for(Entity entities : w.getEntities()) {
							
							if(entities instanceof Item) {
								
								entities.remove();
								
							}
							
						}
						
					}
					
				}
			}
		}, 20*60, 20*60);
		
	}
	
	public static Build getInstance() {
		
		return Resources.instance;
		
	}
	
	public static void registerCommands() {
		
		getInstance().getCommand("setspawn").setExecutor(new SetSpawn());
		getInstance().getCommand("spawn").setExecutor(new Spawn());
		getInstance().getCommand("giveall").setExecutor(new GiveAll());
		getInstance().getCommand("gamemode").setExecutor(new Gamemode());
		getInstance().getCommand("clan").setExecutor(new Clan());
		getInstance().getCommand("kit").setExecutor(new Kit());
		getInstance().getCommand("clearchat").setExecutor(new ClearChat());
		
	}
	
	public static void registerEvents() {
		
		getInstance().getServer().getPluginManager().registerEvents(new PlayerJoinListener(), getInstance());
		getInstance().getServer().getPluginManager().registerEvents(new PlayerQuitListener(), getInstance());
		getInstance().getServer().getPluginManager().registerEvents(new PlayerInteractListener(), getInstance());
		getInstance().getServer().getPluginManager().registerEvents(new PlayerDeathListener(), getInstance());
		getInstance().getServer().getPluginManager().registerEvents(new EntityDamageListener(), getInstance());
		getInstance().getServer().getPluginManager().registerEvents(new InventoryClickListener(), getInstance());
		
	}
	
	public static void openKitInv(final Player p) {
		
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, -5);
		
		final ItemStack i0 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).build();
		final ItemStack i1 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)14).build();
		final ItemStack i2 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).build();
		final ItemStack i3 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)14).build();
		final ItemStack i4 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).build();
		final ItemStack i5 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)14).build();
		final ItemStack i6 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).build();
		final ItemStack i7 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)14).build();
		final ItemStack i8 = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).build();
		
		final Inventory inv = Bukkit.createInventory(null, 27, "§aKit");
		
		Resources.kitInteger.put(p, 0);
		
		Resources.kitInventory.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if(Resources.kitInteger.get(p) == 0) {
					
					inv.setItem(0, i0);
					inv.setItem(1, i1);
					inv.setItem(2, i2);
					inv.setItem(3, i3);
					inv.setItem(4, i4);
					inv.setItem(5, i5);
					inv.setItem(6, i6);
					inv.setItem(7, i7);
					inv.setItem(8, i8);
					
					p.updateInventory();
					
					Resources.kitInteger.put(p, 1);
					
				} else
				

				if(Resources.kitInteger.get(p) == 1) {
					
					inv.setItem(9, i0);
					inv.setItem(10, i1);
					inv.setItem(11, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1, (byte)0, "§7᚛ §aStandard", "§2§oAlle 10 Minuten").addGlow().build());
					inv.setItem(12, i3);
					inv.setItem(13, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1, (byte)0, "§7᚛ §6Premium", "§2§oAlle 30 Minuten").addGlow().build());
					inv.setItem(14, i5);
					inv.setItem(15, new ItemBuilder(Material.LEATHER_CHESTPLATE, 1, (byte)0, "§7᚛ §bPremium+", "§2§oAlle 60 Minuten").addGlow().build());
					inv.setItem(16, i7);
					inv.setItem(17, i8);
					
					p.updateInventory();

					Resources.kitInteger.put(p, 2);
					
				} else
				

				if(Resources.kitInteger.get(p) == 2) {
					
					
					inv.setItem(0, i0);
					inv.setItem(1, i1);
					inv.setItem(2, i2);
					inv.setItem(3, i3);
					inv.setItem(4, i4);
					inv.setItem(5, i5);
					inv.setItem(6, i6);
					inv.setItem(7, i7);
					inv.setItem(8, i8);
					
					p.updateInventory();
					
					Resources.kitInteger.remove(p);
					Bukkit.getScheduler().cancelTask(Resources.kitInventory.get(p));
					Resources.kitInventory.remove(p);
					
				}
				
			}
		}, 2, 5));
	
	}

}
