package me.shock.boatspeed;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BowListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BowListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onShoot(ProjectileLaunchEvent event)
	{
		Entity entity = event.getEntity();
		if(entity instanceof Player)
		{
			
		}
	}
	
}
