package me.shock.boatspeed;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BatWitchListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BatWitchListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent event)
	{
		
	}
}
