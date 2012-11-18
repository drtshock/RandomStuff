package me.shock.boatspeed;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EatingListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public EatingListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onEat(FoodLevelChangeEvent event)
	{
		Player player = (Player) event.getEntity();
		int foodlevel = player.getFoodLevel();
		
		if (foodlevel < 5)
		{
			Location loc = player.getLocation();
			loc.getWorld().createExplosion(loc, 5);
		}
	}
	
	@EventHandler
	public void onCowDeath(EntityDamageByEntityEvent event)
	{
		EntityType type = event.getEntityType();
		Entity damager = event.getDamager();
		Location loc = damager.getLocation();
		if(type.equals(EntityType.COW))
		{
			damager.getLocation().getWorld().createExplosion(loc, 2);
		}
	}
	
}
