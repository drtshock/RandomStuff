/*package me.shock.boatspeed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

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
		Player player = event.getPlayer();
		//Action action = event.getAction();
		Boolean inBoat = player.isInsideVehicle();
		ItemStack item = player.getItemInHand();
		Material mat = item.getType();
		ItemStack items = player.getInventory().getItem(262);
		if((inBoat == true) && (mat == Material.BOW) && (items != null))
		{
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Erorr in bow listener");
			return;
		}
	}
	
	@EventHandler
	public void lock(ProjectileLaunchEvent event)
	{
		// Lock on projectiles here somehow.
	}
	
}
*/
