package edu.unca.schalvet.TerrainGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class TerrainGeneratorPondPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk) {
		int x, y, z, height;
		Block waterBlock, sandBlock;
		
		for (y=40; y<53; ++y){
			for(x=0;x<16; ++x){
				for (z=0;z<16;++z){
					if (chunk.getBlock(x, y, z).getType()== Material.AIR){
					
						waterBlock = chunk.getBlock(x, y, z);
						waterBlock.setType(Material.WATER);
						
						for(height=y; height>0;--height){
							if (chunk.getBlock(x, height, z).getType()!= Material.WATER){
								sandBlock = chunk.getBlock(x, height, z);
								sandBlock.setType(Material.SAND);
							}
						}
					}
					
					
				}
			}

		}
	}

}
