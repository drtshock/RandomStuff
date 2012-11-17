package me.shock.boatspeed;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BatWitchListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BatWitchListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event)
	{
		Entity entity = event.getEntity();
		if(entity instanceof Witch)
		{
			((Witch) entity).damage(100);
			Location loc = entity.getLocation();
			loc.getWorld().playEffect(loc, Effect.SMOKE, 700);
			loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 700);
			loc.getWorld().playEffect(loc, Effect.ZOMBIE_DESTROY_DOOR, 100);
			loc.getWorld().spawn(loc, Bat.class);
			//Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Got witch damage event"); // confirming event fired.
		}
		if (entity instanceof Bat)
		{
			((Bat) entity).damage(100);
			Location loc = entity.getLocation();
			loc.getWorld().playEffect(loc, Effect.SMOKE, 700);
			loc.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 700);
			loc.getWorld().playEffect(loc, Effect.ZOMBIE_CHEW_IRON_DOOR, 100);
			loc.getWorld().spawn(loc, Witch.class);
			//Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "Got Bat damage event"); // confirming event fired.
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent event)
	{
		Entity entity = event.getEntity();
		if (entity instanceof Witch)
		{
			List<ItemStack> item = event.getDrops();
			item.clear();
		}
	}
}
