package edu.unca.schalvet.TerrainGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TerrainGeneratorTreePopulator extends BlockPopulator{

	public void populate(World world, Random random, Chunk chunk) {
		if (random.nextInt(100)<=30){ 
			
			int x=6+random.nextInt(4),
				z=6+random.nextInt(4),
				y=150;
			while(chunk.getBlock(x, y, z).getType()== Material.AIR) 
				--y;

			world.generateTree(chunk.getBlock(x, y+1, z).getLocation(), TreeType.BIG_TREE);

			//mv create hills5 normal -g TerrainGenerator
		}
	}
	

}
