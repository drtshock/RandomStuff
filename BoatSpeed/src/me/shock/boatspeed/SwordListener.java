package me.shock.boatspeed;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SwordListener extends JavaPlugin implements Listener
{

	
	final Main plugin;
	public SwordListener(Main instance)
	{
		plugin = instance;
	}
	
	// Some code to add for making swords / bows have potion effects?
	/*
	POISONED_DIAMOND_SWORD_I = new CraftItemStack(Material.DIAMOND_SWORD);
    POISONED_DIAMOND_SWORD_I.addUnsafeEnchantment(EnchantmentManager.POISON, 1);
    POISONED_DIAMOND_SWORD_I.getHandle().c("Poisoned Diamond Sword I");
    */
}
