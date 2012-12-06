package edu.unca.schalvet.TerrainGenerator;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.text.MessageFormat;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class TerrainGeneratorEventListener implements Listener {

	private final TerrainGenerator plugin;

	public TerrainGeneratorEventListener(TerrainGenerator plugin) {
		this.plugin = plugin;
	}
}
