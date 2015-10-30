package ch.trikeyyy.build.contents;

import java.util.Arrays;
import java.util.List;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
	
	private ItemStack is;
	private List<String> lore;
	
	public ItemBuilder(Integer id, Integer amount, Byte subid) {
		this.is = new ItemStack(id, amount, subid);
	}
	
	public ItemBuilder(Material m) {
		this.is = new ItemStack(m);
	}
	
	public ItemBuilder(Material m, Integer amount) {
		this.is = new ItemStack(m, amount);
	}
	
	public ItemBuilder(Material m, Integer amount, Byte data) {
		this.is = new ItemStack(m, amount, data);
	}
	
	public ItemBuilder(Material m, Integer amount, Byte data, String displayname) {
		
		displayname = ChatColor.translateAlternateColorCodes('&', displayname);
		
		this.is = new ItemStack(m, amount, data);
		ItemMeta meta = is.getItemMeta();
		meta.setDisplayName(displayname);
		is.setItemMeta(meta);
	}
	
	public ItemBuilder(Material m, Integer amount, Byte data, String displayname, String... lore) {
		
		displayname = ChatColor.translateAlternateColorCodes('&', displayname);
		
		this.is = new ItemStack(m, amount, data);
		ItemMeta meta = is.getItemMeta();
		meta.setDisplayName(displayname);
		meta.setLore(Arrays.asList(lore));
		is.setItemMeta(meta);
	}	
	
	public ItemBuilder setSkullMeta(String owner) {
		SkullMeta meta = (SkullMeta) is.getItemMeta();
		meta.setOwner(owner);
		is.setItemMeta(meta);
		return this;
	}
	
	public ItemBuilder addGlow() {
		net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(is);
		NBTTagCompound tag = null;
		
		if(!nmsStack.hasTag()) {
			tag = new NBTTagCompound();
			nmsStack.setTag(tag);
		}
		
		if(tag == null) tag = nmsStack.getTag();
		
		NBTTagList ench = new NBTTagList();
		tag.set("ench", ench);
		nmsStack.setTag(tag);
		
		is = CraftItemStack.asBukkitCopy(nmsStack);
		return this;
	}
	
	public ItemStack build() {
		return is;
	}

}
