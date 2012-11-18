package me.shock.boatspeed;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

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
		return;
	}
	
	@EventHandler
	public void shoot(ProjectileHitEvent event)
	{
		LivingEntity shooter = event.getEntity().getShooter();
		Location loc = event.getEntity().getLocation();
		EntityType entity = event.getEntityType();
		Player player = (Player) shooter;
		ItemStack item = player.getItemInHand();
		int powerlevel = item.getEnchantmentLevel(Enchantment.ARROW_DAMAGE);
		int smitelevel = item.getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD);
		
		if (shooter instanceof Player && entity.equals(EntityType.ARROW))
		{

			loc.getWorld().createExplosion(loc, (powerlevel));
			
			while(smitelevel > 0)
			{
			loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
			loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
			smitelevel--;
			}
			
		}
		if (shooter instanceof Player && entity.equals(EntityType.SNOWBALL))
		{
			loc.getWorld().createExplosion(loc, (float) 7);
		}
		if (shooter instanceof Player && entity.equals(EntityType.ENDER_PEARL))
		{
			loc.getWorld().spawnEntity(loc.add(0, 20, 0), EntityType.SNOWMAN);
		}
		if (shooter instanceof Player && entity.equals(EntityType.EGG))
		{
			loc.getWorld().spawnEntity(loc.add(0, 50, 0), (EntityType.CHICKEN));
			loc.getWorld().spawnEntity(loc.add(0, 50, 0), (EntityType.CHICKEN));
			loc.getWorld().spawnEntity(loc.add(0, 50, 0), (EntityType.CHICKEN));
			loc.getWorld().spawnEntity(loc.add(0, 50, 0), (EntityType.CHICKEN));
			loc.getWorld().spawnEntity(loc.add(0, 50, 0), (EntityType.CHICKEN));
		}
		if (shooter instanceof Skeleton && entity.equals(EntityType.ARROW))
		{
			loc.getWorld().spawnEntity(loc.add(0, 10, 0), (EntityType.COW));
		}
	}
}

