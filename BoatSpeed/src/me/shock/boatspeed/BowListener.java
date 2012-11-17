package me.shock.boatspeed;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class BowListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BowListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler (priority = EventPriority.LOWEST)
	public void onShoot(PlayerInteractEvent event)
	{
		return;
	}
	
	@EventHandler
	public void shoot(ProjectileHitEvent event)
	{
		LivingEntity shooter = event.getEntity().getShooter();
		Location loc = event.getEntity().getLocation();
		EntityType entity = event.getEntityType();
		if (shooter instanceof Player && entity.equals(EntityType.ARROW))
		{
			loc.getWorld().strikeLightningEffect(loc);
		}
		if (shooter instanceof Player && entity.equals(EntityType.SNOWBALL))
		{
			loc.getWorld().createExplosion(loc, (float) 0.1);
		}
		if (shooter instanceof Player && entity.equals(EntityType.ENDER_PEARL))
		{
			loc.getWorld().setStorm(true);
		}
	}
}

