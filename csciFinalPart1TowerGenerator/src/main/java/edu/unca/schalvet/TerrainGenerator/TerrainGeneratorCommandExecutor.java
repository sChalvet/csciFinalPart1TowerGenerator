package edu.unca.schalvet.TerrainGenerator;


import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.base.Joiner;

public class TerrainGeneratorCommandExecutor implements CommandExecutor {

    private TerrainGenerator plugin;

    public TerrainGeneratorCommandExecutor(TerrainGenerator plugin) {
        this.plugin = plugin;
    }

    //@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.getLogger().info("onCommand Reached in samsPluggin");

       return true;
    }
    
}
