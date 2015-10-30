package ch.trikeyyy.build.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import ch.trikeyyy.build.contents.ItemBuilder;
import ch.trikeyyy.build.contents.Methods;
import ch.trikeyyy.build.contents.Resources;

public class InventoryClickListener implements Listener {

	
	@EventHandler
	public void KitInv(InventoryClickEvent event) {
		
		if(event.getWhoClicked() instanceof Player) {
			
			final Player p = (Player) event.getWhoClicked();
				
			if(event.getCurrentItem() != null) {
					
				if(event.getInventory().getName().equals("§aKit")) {
					
					if(event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
						
						if(!(Resources.kitstandard.contains(p))) {
							
							Resources.kitstandard.add(p);
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.CAT_PURR, 5, -5);
							
							ItemStack sword = new ItemBuilder(Material.IRON_SWORD, 1, (byte)0, "§7Starter-Schwert").build();
							sword.addEnchantment(Enchantment.DAMAGE_ALL, 0);
							p.getInventory().addItem(sword);
							p.getInventory().addItem(new ItemBuilder(Material.COOKIE, 3, (byte)0, "§7Starter-Keks").build());
							p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF, 16, (byte)0, "§7Starter-Steak").build());
							p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_HELMET, 1, (byte)0, "§7Starter-Helm").build());
							p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, (byte)0, "§7Starter-Brustplatte").build());
							p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_LEGGINGS, 1, (byte)0, "§7Starter-Hose").build());
							p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_BOOTS, 1, (byte)0, "§7Starter-Schuhe").build());
							
							p.updateInventory();
							
							Bukkit.getScheduler().runTaskLater(Methods.getInstance(), new Runnable() {
								
								@Override
								public void run() {
									
									Resources.kitstandard.remove(p);
									
								}
							}, 20*60*10);
							
						} else {
							
							p.closeInventory();
							p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, -5);
							p.sendMessage(Resources.prefix + "§bDein Kit wird noch geschmiedet!");
							
						}
						
					}
					
					if(p.hasPermission("build.premium")) {
					
						if(event.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
							
							if(!(Resources.kitpremium.contains(p))) {
								
								Resources.kitpremium.add(p);
								
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.CAT_PURR, 5, -5);
								
								ItemStack sword = new ItemBuilder(Material.IRON_SWORD, 1, (byte)0, "§6Premium-Schwert").build();
								sword.addEnchantment(Enchantment.DAMAGE_ALL, 0);
								p.getInventory().addItem(sword);
								
								p.getInventory().addItem(new ItemBuilder(Material.COOKIE, 3, (byte)0, "§6Premium-Keks").build());
								p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF, 16, (byte)0, "§6Premium-Steak").build());
								
								ItemStack helmet = new ItemBuilder(Material.IRON_HELMET, 1, (byte)0, "§6Premium-Helm").build();
								helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
								p.getInventory().addItem(helmet);
								
								ItemStack chestplate = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, (byte)0, "§6Premium-Brustplatte").build();
								chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
								p.getInventory().addItem(chestplate);
								
								ItemStack leggings = new ItemBuilder(Material.IRON_LEGGINGS, 1, (byte)0, "§6Premium-Hose").build();
								leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
								p.getInventory().addItem(leggings);
								
								ItemStack boots = new ItemBuilder(Material.IRON_BOOTS, 1, (byte)0, "§6Premium-Schuhe").build();
								boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 0);
								p.getInventory().addItem(boots);

								p.getInventory().addItem(new ItemBuilder(Material.BOW, 1, (byte)0, "§6Premium-Bogen").build());
								p.getInventory().addItem(new ItemBuilder(Material.ARROW, 32, (byte)0, "§6Premium-Pfeil").build());
								
								p.updateInventory();
								
								Bukkit.getScheduler().runTaskLater(Methods.getInstance(), new Runnable() {
									
									@Override
									public void run() {
										
										Resources.kitpremium.remove(p);
										
									}
								}, 20*60*30);
								
							} else {
								
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, -5);
								p.sendMessage(Resources.prefix + "§bDein Kit wird noch geschmiedet!");
								
							}
							
						}
					
					}
					
					if(p.hasPermission("build.premium")) {
					
						if(event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
							
							if(!(Resources.kitpremiumplus.contains(p))) {
								
								Resources.kitpremiumplus.add(p);
								
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.CAT_PURR, 5, -5);
								
								ItemStack sword = new ItemBuilder(Material.IRON_SWORD, 1, (byte)0, "§3PremiumPlus-Schwert").build();
								sword.addEnchantment(Enchantment.DAMAGE_ALL, 0);
								p.getInventory().addItem(sword);
								
								p.getInventory().addItem(new ItemBuilder(Material.COOKIE, 3, (byte)0, "§3PremiumPlus-Keks").build());
								p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF, 16, (byte)0, "§3PremiumPlus-Steak").build());
								p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT, 10, (byte)0, "§3PremiumPlus-Karotte").build());
								
								ItemStack helmet = new ItemBuilder(Material.IRON_HELMET, 1, (byte)0, "§3PremiumPlus-Helm").build();
								helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								p.getInventory().addItem(helmet);
								
								ItemStack chestplate = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, (byte)0, "§3PremiumPlus-Brustplatte").build();
								chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								p.getInventory().addItem(chestplate);
								
								ItemStack leggings = new ItemBuilder(Material.IRON_LEGGINGS, 1, (byte)0, "§3PremiumPlus-Hose").build();
								leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								p.getInventory().addItem(leggings);
								
								ItemStack boots = new ItemBuilder(Material.IRON_BOOTS, 1, (byte)0, "§3PremiumPlus-Schuhe").build();
								boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
								p.getInventory().addItem(boots);
								
								ItemStack bow = new ItemBuilder(Material.BOW, 1, (byte)0, "§3PremiumPlus-Bogen").build();
								bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
								p.getInventory().addItem(bow);
								
								p.getInventory().addItem(new ItemBuilder(Material.ARROW, 32, (byte)0, "§3PremiumPlus-Pfeil").build());
								
								p.updateInventory();
								
								Bukkit.getScheduler().runTaskLater(Methods.getInstance(), new Runnable() {
									
									@Override
									public void run() {
										
										Resources.kitpremiumplus.remove(p);
										
									}
								}, 20*60*60);
								
							} else {
								
								p.closeInventory();
								p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, -5);
								p.sendMessage(Resources.prefix + "§bDein Kit wird noch geschmiedet!");
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
