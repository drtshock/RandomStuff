package me.shock.boatspeed;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener 
{
	
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new SpeedListener(this), this);
		pm.registerEvents(new FallDamageListener(this), this);
		pm.registerEvents(new BowListener(this), this);
		pm.registerEvents(new BatWitchListener(this), this);
		pm.registerEvents(new BoatDamageListener(this), this);
		pm.registerEvents(new SwordListener(this), this);
		pm.registerEvents(new EnderPearlListener(this), this);
		pm.registerEvents(new EatingListener(this), this);
		getCommand("burn").setExecutor(new CommandHandler(this));
		getCommand("wipe").setExecutor(new CommandHandler(this));
		getCommand("boom").setExecutor(new CommandHandler(this));
		getCommand("effects").setExecutor(new CommandHandler(this));
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
		saveConfig();
		getLogger().info("BoatSpeed config saved");
		}
}
