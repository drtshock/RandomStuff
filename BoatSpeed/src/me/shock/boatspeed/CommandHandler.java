package me.shock.boatspeed;

import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin implements CommandExecutor
{
	final Main plugin;
	public CommandHandler(Main instance)
	{
		plugin = instance;
	}



	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		
		// Burns all entities around you for 10 seconds
		 if (((sender instanceof Player)) && (cmd.getName().equalsIgnoreCase("burn"))) 
		 {
			 Player player = (Player) sender;
			 Iterator<?> iter = player.getWorld().getEntities().iterator();
			 int count = 0;
			 while (iter.hasNext())
			 {
				 Entity ent = (Entity) iter.next();
				 ent.setFireTicks(200);
				 iter.remove();
				 count++;
			 }
			 player.sendMessage(ChatColor.RED + "" + count + " entities burned.");
		  }
		 
		 // clears entities. currently crashes server :(
		 if (((sender instanceof Player)) && (cmd.getName().equalsIgnoreCase("wipe"))) 
		 {
			 Player player = (Player) sender;
			 Iterator<?> iter = player.getWorld().getEntities().iterator();
			 int count = 0;
			 while (iter.hasNext())
			 {
				 Entity ent = (Entity) iter.next();
				 ent.remove();
				 iter.remove();
				 count++;
			 }
			 player.sendMessage(ChatColor.RED + "" + count + " entities wiped.");
		 }
		 
		 // blows up entities around you :P
		 if (((sender instanceof Player)) && (cmd.getName().equalsIgnoreCase("boom"))) 
		 {
			 Player player = (Player) sender;
			 Iterator<?> iter = player.getWorld().getEntities().iterator();
			 int count = 0;
			 while (iter.hasNext())
			 {
				 Entity ent = (Entity) iter.next();
				 ent.getLocation().getWorld().createExplosion(ent.getLocation(), 5);
				 iter.remove();
				 count++;
			 }
			 player.sendMessage(ChatColor.RED + "" + count + " entities blown up.");
		 }
		 
		 // command to which players have potion effects
		 if (((sender instanceof Player)) && (cmd.getName().equalsIgnoreCase("effects"))) 
		 {
			 Player player = (Player) sender;
			 List<Player> players = player.getWorld().getPlayers();
			 int count = 1;
			 Iterator<?> iter = players.iterator();
			 while (iter.hasNext())
			 {
				 int size = players.size();
				 count++;
			 }
			 player.sendMessage(ChatColor.RED + "" + count + " players with effects");
		 }
		 
		 
		return false;
	  }
}
