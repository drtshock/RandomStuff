package me.shock.boatspeed;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BatWitchListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BatWitchListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onDeath(EntityDamageEvent event)
	{
		Entity entity = event.getEntity();
		if(entity instanceof Witch)
		{
			Location loc = entity.getLocation();
			loc.getWorld().spawn(arg0, arg1);
		}
	}
}
