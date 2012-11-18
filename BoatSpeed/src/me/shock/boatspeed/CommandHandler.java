package me.shock.boatspeed;

import java.util.Collection;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin implements Listener
{
	
	final Main plugin;
	public CommandHandler(Main instance)
	{
		plugin = instance;
	}



	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		 if (((sender instanceof Player)) && 
			      (cmd.getName().equalsIgnoreCase("wipe"))) 
		 {
			 Player player = (Player) sender;
			// List<Entity> = player.getWorld().getEntities();
			 
		 }
		  return false;
	  }
}
