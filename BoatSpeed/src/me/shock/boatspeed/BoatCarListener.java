package me.shock.boatspeed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BoatCarListener extends JavaPlugin implements Listener
{

	final Main plugin;
	public BoatCarListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void login(PlayerLoginEvent event)
	{
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.GREEN + "BoatCarListener working");
	}
	
	@EventHandler
	public void onEnter(VehicleEnterEvent event)
	{
		if(event.getEntered() instanceof Player)
		{
			Player player = (Player) event.getEntered();
				if(player.hasPermission("boatcar.use"))
				{
					Vehicle v = event.getVehicle();
					if (v instanceof Boat)
					{
						Boat b = (Boat) v;
						b.setWorkOnLand(true);
						b.setMaxSpeed(5);
						Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Increased speed on land.");
					}
				}
		}
	}
	
	@EventHandler
	public void onDamage(VehicleDamageEvent event)
	{
		if (getConfig().getBoolean("Disable Boat Damage on Land") == true)
		{
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "Config works damage event");
		if(event.getVehicle() instanceof Boat && event.getVehicle().getPassenger() instanceof Player)
		 {
			Player player = (Player) event.getVehicle().getPassenger();
			if (player.hasPermission("boatcar.use"))
			{
				event.setCancelled(true);
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Boat damage canceled.");
			}
		 }
		}
	}
}
