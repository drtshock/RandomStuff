package me.shock.boatspeed;

import org.bukkit.Material;
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
		pm.registerEvents(new BowListener(this), this);
		setupConfig();
		getLogger().info("BoatSpeed enabled");
	}
	
	public void onDisable()
	{
		getLogger().info("BoatSpeed disabled");
	}
	
	public void setupConfig()
	{
		this.getConfig().set("Disable Boat Fall Damage", true);
		this.getConfig().set("Flying Boat", true);
		this.getConfig().set("Disable Boat Damage on Land", true);
		this.getConfig().set("BowShoot", Material.ARROW);
	}
}
