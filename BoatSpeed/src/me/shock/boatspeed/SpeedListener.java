package me.shock.boatspeed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SpeedListener extends JavaPlugin implements Listener
{
	
	final Main plugin;
	public SpeedListener(Main instance)
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
	public void interact(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		ItemStack item = player.getItemInHand();
		Material mat = item.getType();
		Action action = event.getAction();
		Boolean inBoat = player.isInsideVehicle();
		if(action == Action.RIGHT_CLICK_AIR && inBoat == true && player.getVehicle() instanceof Boat && mat == Material.BLAZE_ROD)
		//if ((action == Action.LEFT_CLICK_AIR) && (mat == Material.BLAZE_ROD))
		{
		if ((player.getVehicle() instanceof Boat) && (mat == Material.BLAZE_ROD) && (inBoat == true))
		 {
			Boat b = (Boat) player.getVehicle();
			b.setVelocity(b.getVelocity().setY(0.8));
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Increased speed " + event.getPlayer().getName() + " blaze click"); // Confirmed event fired for player.
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Error 1");
		 }
		}
		else
		{
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "Error 2 (returning: FUCK YOU PLUGIN)"); // getting error here :(
			return;
		}
	}
}
