package edu.unca.schalvet.TerrainGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class TerrainGeneratorGenerator extends ChunkGenerator{
	
	private TerrainGenerator plugin;
	
	public TerrainGeneratorGenerator(TerrainGenerator instance){
		this.plugin= instance;
		
	}
	
	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		populators.add(new TerrainGeneratorGrassPopulator());
		populators.add(new TerrainGeneratorTowerPopulator());
		populators.add(new TerrainGeneratorPondPopulator());
		populators.add(new TerrainGeneratorTreePopulator());
		return populators;
	}
	
	public Location getFixedSpawnLocation (World world, Random random){
		return new Location(world, 0, 5, 0);
	}
	
	private int coordsToInt(int x, int y, int z){
		return (x * 16 + z) * 128 + y;
	}
	
	
	public byte[] generate(World world, Random random, int chunkX, int chunkZ){
		byte[] blocks = new byte[32768];
		int x, y, z;
		
		Random rand = new Random(world.getSeed());
		
		SimplexOctaveGenerator octave = new SimplexOctaveGenerator(rand, 16);
		
		octave.setScale(1/128.0);
		
		for(x=0;x<16;++x){
			for(z=0;z<16;++z){
				blocks[this.coordsToInt(x, 0, z)]= (byte) Material.BEDROCK.getId();
				
				double noise = octave.noise(x + chunkX*16, z + chunkZ*16, 0.5, 0.5)*9;//octave.noise(x, y, frequency, amplitude)
				
				for(y=1;y<60+noise;++y){
					blocks[this.coordsToInt(x, y, z)]= (byte) Material.DIRT.getId();
				}
				
				//if(y>65)
				//	blocks[this.coordsToInt(x, y, z)]= (byte) Material.SNOW.getId();
				//else
					blocks[this.coordsToInt(x, y, z)]= (byte) Material.GRASS.getId();
			}
		} //mv create world normal -g TerrainGenerator
		
		return blocks;
	}

}
