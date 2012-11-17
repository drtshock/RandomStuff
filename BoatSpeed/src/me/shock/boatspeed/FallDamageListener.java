package me.shock.boatspeed;

import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FallDamageListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public FallDamageListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void damage(EntityDamageEvent event)
	{
		if((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (event.getEntity() instanceof Player))
		{
			Entity entity = event.getEntity();
			Entity veh = entity.getVehicle();
			if(veh instanceof Boat)
			{
				event.setCancelled(true);
			}
		}
	}
}
