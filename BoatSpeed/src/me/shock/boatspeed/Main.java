package me.shock.boatspeed;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener 
{
	
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BoatCarListener(this), this);
		pm.registerEvents(new SpeedListener(this), this);
		pm.registerEvents(new FallDamageListener(this), this);
		getLogger().info("BoatSpeed enabled");
	}
	
	public void onDisable()
	{
		getLogger().info("BoatSpeed disabled");
	}
	
}
