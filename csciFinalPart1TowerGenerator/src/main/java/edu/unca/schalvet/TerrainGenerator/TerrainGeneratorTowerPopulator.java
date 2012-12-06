package edu.unca.schalvet.TerrainGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.plugin.PluginLogger;

public class TerrainGeneratorTowerPopulator extends BlockPopulator {
	
	 /*   private TerrainGenerator plugin;

	    public TerrainGeneratorTowerPopulator(TerrainGenerator plugin) {
	        this.plugin = plugin;
	    }*/

	public int lowestBlock(Chunk chunk){
		
		int x, y, z, lowest=200;

		
		for(x=0;x<16; ++x){
			for (z=0;z<16;++z){
					for (y=200; chunk.getBlock(x, y, z).getType()== Material.AIR; --y);
					
					  if(lowest>y)
						lowest=y;
				}
			}
		
		return lowest;
	}
	
	
	public void populate(World world, Random random, Chunk chunk) {
		
		if(random.nextInt(100)<=2){
			
			int y = lowestBlock(chunk); //gets the lowest block in the chunk to start building
			
			Material[] blockType ={ Material.NETHER_BRICK,Material.COBBLESTONE,
									Material.BRICK,Material.MOSSY_COBBLESTONE,
									Material.STONE,Material.OBSIDIAN,
									Material.BEDROCK,Material.SANDSTONE};
			
			int x, z;
			int randBlock = random.nextInt(8);
			int randTower = random.nextInt(2);
			int firstLevelHeight = y+random.nextInt(30)+20;
			int secondLevelHeight = firstLevelHeight+random.nextInt(20)+10;
			int thirdLevelHeight = secondLevelHeight+random.nextInt(10)+15;
			
			if(randTower==1){
				
				/*First level round tower*/
				
						for (z=6;z<9;++z){
							for (int i=0; (y+i)<firstLevelHeight; ++i){
								chunk.getBlock(0, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(14, y+i, z).setType(blockType[randBlock]);
							}
						}


						for (z=4;z<11;++z){
							for (int i=0; (y+i)<firstLevelHeight; ++i){
								chunk.getBlock(1, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(13, y+i, z).setType(blockType[randBlock]);
							}
						}


						for(x=2;x<4; ++x){
							for (z=2;z<13;++z){
								for (int i=0; (y+i)<firstLevelHeight; ++i){
									chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
									chunk.getBlock(x+9, y+i, z).setType(blockType[randBlock]);
									}
								}
							}//end x for loop


						for (z=1;z<14;++z){
							for (int i=0; (y+i)<firstLevelHeight; ++i){
								chunk.getBlock(4, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(10, y+i, z).setType(blockType[randBlock]);
							}
						}
			

						for(x=5;x<10; ++x){
							for (z=0;z<15;++z){
								for (int i=0; (y+i)<firstLevelHeight; ++i)
									chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
								}
							if((x==5 && z==0) || (x==9 && z==0) || (x==9 && z==14) || (x==5 && z==14)|| (x==7 && z==0)|| (x==7 && z==14) ){
								chunk.getBlock(x, firstLevelHeight, z).setType(blockType[randBlock]);
								chunk.getBlock(x, firstLevelHeight+1, z).setType(Material.TORCH);
							}
							}//end x for loop
						
						chunk.getBlock(14, firstLevelHeight, 6).setType(blockType[randBlock]);
						chunk.getBlock(14, firstLevelHeight+1, 6).setType(Material.TORCH);
						
						chunk.getBlock(14, firstLevelHeight, 8).setType(blockType[randBlock]);
						chunk.getBlock(14, firstLevelHeight+1, 8).setType(Material.TORCH);
						
						chunk.getBlock(0, firstLevelHeight, 6).setType(blockType[randBlock]);
						chunk.getBlock(0, firstLevelHeight+1, 6).setType(Material.TORCH);
						
						chunk.getBlock(0, firstLevelHeight, 8).setType(blockType[randBlock]);
						chunk.getBlock(0, firstLevelHeight+1, 8).setType(Material.TORCH);
						
						chunk.getBlock(13, firstLevelHeight, 4).setType(blockType[randBlock]);
						chunk.getBlock(13, firstLevelHeight+1, 4).setType(Material.TORCH);
						
						chunk.getBlock(13, firstLevelHeight, 10).setType(blockType[randBlock]);
						chunk.getBlock(13, firstLevelHeight+1, 10).setType(Material.TORCH);
						
						chunk.getBlock(1, firstLevelHeight, 4).setType(blockType[randBlock]);
						chunk.getBlock(1, firstLevelHeight+1, 4).setType(Material.TORCH);
						
						chunk.getBlock(1, firstLevelHeight, 10).setType(blockType[randBlock]);
						chunk.getBlock(1, firstLevelHeight+1, 10).setType(Material.TORCH);
						
						chunk.getBlock(12, firstLevelHeight, 2).setType(blockType[randBlock]);
						chunk.getBlock(12, firstLevelHeight+1, 2).setType(Material.TORCH);
						
						chunk.getBlock(12, firstLevelHeight, 12).setType(blockType[randBlock]);
						chunk.getBlock(12, firstLevelHeight+1, 12).setType(Material.TORCH);
						
						chunk.getBlock(2, firstLevelHeight, 2).setType(blockType[randBlock]);
						chunk.getBlock(2, firstLevelHeight+1, 2).setType(Material.TORCH);
						
						chunk.getBlock(2, firstLevelHeight, 12).setType(blockType[randBlock]);
						chunk.getBlock(2, firstLevelHeight+1, 12).setType(Material.TORCH);
						
						chunk.getBlock(10, firstLevelHeight, 1).setType(blockType[randBlock]);
						chunk.getBlock(10, firstLevelHeight+1, 1).setType(Material.TORCH);
						
						chunk.getBlock(10, firstLevelHeight, 13).setType(blockType[randBlock]);
						chunk.getBlock(10, firstLevelHeight+1, 13).setType(Material.TORCH);
						
						chunk.getBlock(4, firstLevelHeight, 1).setType(blockType[randBlock]);
						chunk.getBlock(4, firstLevelHeight+1, 1).setType(Material.TORCH);
						
						chunk.getBlock(4, firstLevelHeight, 13).setType(blockType[randBlock]);
						chunk.getBlock(4, firstLevelHeight+1, 13).setType(Material.TORCH);
						
						
						
						chunk.getBlock(9, firstLevelHeight, 0).setType(blockType[randBlock]);
						chunk.getBlock(9, firstLevelHeight+1, 0).setType(Material.TORCH);
						
						chunk.getBlock(9, firstLevelHeight, 14).setType(blockType[randBlock]);
						chunk.getBlock(9, firstLevelHeight+1, 14).setType(Material.TORCH);
						
						chunk.getBlock(7, firstLevelHeight, 0).setType(blockType[randBlock]);
						chunk.getBlock(7, firstLevelHeight+1, 0).setType(Material.TORCH);
						
						chunk.getBlock(7, firstLevelHeight, 14).setType(blockType[randBlock]);
						chunk.getBlock(7, firstLevelHeight+1, 14).setType(Material.TORCH);
						
						chunk.getBlock(5, firstLevelHeight, 0).setType(blockType[randBlock]);
						chunk.getBlock(5, firstLevelHeight+1, 0).setType(Material.TORCH);
						
						chunk.getBlock(5, firstLevelHeight, 14).setType(blockType[randBlock]);
						chunk.getBlock(5, firstLevelHeight+1, 14).setType(Material.TORCH);
						
						/*second level round tower*/

						
						for (z=5;z<10;++z){
							for (int i=0; (y+i)<secondLevelHeight; ++i){
								chunk.getBlock(3, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(11, y+i, z).setType(blockType[randBlock]);
							}
						}


						for (z=4;z<11;++z){
							for (int i=0; (y+i)<secondLevelHeight; ++i){
								chunk.getBlock(4, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(10, y+i, z).setType(blockType[randBlock]);
							}
						}
						
						for (z=3;z<12;++z){
							for (int i=0; (y+i)<secondLevelHeight; ++i){
								chunk.getBlock(5, y+i, z).setType(blockType[randBlock]);
								chunk.getBlock(9, y+i, z).setType(blockType[randBlock]);
							}
						}


						for(x=6;x<9; ++x){
							for (z=2;z<13;++z){
								for (int i=0; (y+i)<secondLevelHeight; ++i){
									chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
									}
								}
							}//end x for loop
						
						chunk.getBlock(11, secondLevelHeight, 5).setType(blockType[randBlock]);
						chunk.getBlock(11, secondLevelHeight+1, 5).setType(Material.TORCH);
						
						chunk.getBlock(11, secondLevelHeight, 7).setType(blockType[randBlock]);
						chunk.getBlock(11, secondLevelHeight+1, 7).setType(Material.TORCH);
						
						chunk.getBlock(11, secondLevelHeight, 9).setType(blockType[randBlock]);
						chunk.getBlock(11, secondLevelHeight+1, 9).setType(Material.TORCH);
						
						chunk.getBlock(3, secondLevelHeight, 5).setType(blockType[randBlock]);
						chunk.getBlock(3, secondLevelHeight+1, 5).setType(Material.TORCH);
						
						chunk.getBlock(3, secondLevelHeight, 7).setType(blockType[randBlock]);
						chunk.getBlock(3, secondLevelHeight+1, 7).setType(Material.TORCH);
						
						chunk.getBlock(3, secondLevelHeight, 9).setType(blockType[randBlock]);
						chunk.getBlock(3, secondLevelHeight+1, 9).setType(Material.TORCH);
						
						
						chunk.getBlock(9, secondLevelHeight, 3).setType(blockType[randBlock]);
						chunk.getBlock(9, secondLevelHeight+1, 3).setType(Material.TORCH);
						
						chunk.getBlock(9, secondLevelHeight, 11).setType(blockType[randBlock]);
						chunk.getBlock(9, secondLevelHeight+1, 11).setType(Material.TORCH);
						
						chunk.getBlock(5, secondLevelHeight, 3).setType(blockType[randBlock]);
						chunk.getBlock(5, secondLevelHeight+1, 3).setType(Material.TORCH);
						
						chunk.getBlock(5, secondLevelHeight, 11).setType(blockType[randBlock]);
						chunk.getBlock(5, secondLevelHeight+1, 11).setType(Material.TORCH);
						
						chunk.getBlock(7, secondLevelHeight, 2).setType(blockType[randBlock]);
						chunk.getBlock(7, secondLevelHeight+1, 2).setType(Material.TORCH);
						
						chunk.getBlock(7, secondLevelHeight, 12).setType(blockType[randBlock]);
						chunk.getBlock(7, secondLevelHeight+1, 12).setType(Material.TORCH);
						
						/*third level round tower*/

						
						for(x=5;x<10; ++x){
							for (z=6;z<9;++z){
								for (int i=0; (y+i)<thirdLevelHeight; ++i){
									chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
									
									}
								if((x==5 && z==6) || (x==9 && z==6) || (x==9 && z==8) || (x==5 && z==8) ){
										chunk.getBlock(x, thirdLevelHeight, z).setType(blockType[randBlock]);
										chunk.getBlock(x, thirdLevelHeight+1, z).setType(Material.TORCH);
									}
								}
							}//end x for loop


						for(x=6;x<9; ++x){
							for (z=4;z<6;++z){
								for (int i=0; (y+i)<thirdLevelHeight; ++i){
									if( !(x==6 && z==4) && !(x==8 && z==4) ){
										chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
										chunk.getBlock(x, y+i, z+4).setType(blockType[randBlock]);
									}
									if(x==7 && z==5)
										chunk.getBlock(x, y+i, z+5).setType(blockType[randBlock]);
									}
								}
							}//end x for loop
						
						chunk.getBlock(7, thirdLevelHeight, 4).setType(blockType[randBlock]);
						chunk.getBlock(7, thirdLevelHeight+1, 4).setType(Material.TORCH);
						chunk.getBlock(7, thirdLevelHeight, 10).setType(blockType[randBlock]);
						chunk.getBlock(7, thirdLevelHeight+1, 10).setType(Material.TORCH);

					
				
			}
			else if (randTower==0){
				/*first level generator for square tower*/			
				for(x=0;x<15; ++x){
					for (z=0;z<15;++z){
						for (int i=0; (y+i)<firstLevelHeight; ++i)
							chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
						}
					}//end x for loop
				
				/*crenelation algorithm for square tower*/
				for(x=0;x<15; ++x){
					if(x%2 == 0)
					for (z=0;z<15;++z){
						if(((z%2 == 0) && (x==0 || x==14)) || ((z==0||z==14)  && (x%2==0)) ){
							chunk.getBlock(x, firstLevelHeight, z).setType(blockType[randBlock]);
							chunk.getBlock(x, firstLevelHeight+1, z).setType(Material.TORCH);
							}	
						}
					}//end x for loop
				
				/*second level generator for square tower*/			
				for(x=3;x<12; ++x){
					for (z=3;z<12;++z){
						for (int i=0; (y+i)<secondLevelHeight; ++i)
							chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);
							//plugin.getLogger().info("Creating a block at x="+x+", z="+z+", y="+y+" ");
						}
					}//end x for loop
				
				/*second level 4 balcony generators for square tower*/			
	
				for(x=1;x<6; ++x){
					for (z=1;z<6;++z){
							chunk.getBlock(x, secondLevelHeight-1, z).setType(blockType[randBlock]);
						}
					}
				for(x=1;x<6; ++x){
					for (z=9;z<14;++z){
							chunk.getBlock(x, secondLevelHeight-1, z).setType(blockType[randBlock]);
						}
					}
				for(x=9;x<14; ++x){
					for (z=9;z<14;++z){
							chunk.getBlock(x, secondLevelHeight-1, z).setType(blockType[randBlock]);
						}
					}
				for(x=9;x<14; ++x){
					for (z=1;z<6;++z){
							chunk.getBlock(x, secondLevelHeight-1, z).setType(blockType[randBlock]);
						}
					}
				
				/*crenelation algorithm for level 2 square tower*/
				for(x=1;x<14; ++x){ // this part does the outside of the balcony 
					if(x%2 == 1)
					for (z=1;z<14;++z){
						if(((z%2 == 1) && (x==1 || x==13)) || ((z==1||z==13)  && (x%2==1)) ){
							chunk.getBlock(x, secondLevelHeight, z).setType(blockType[randBlock]);
							chunk.getBlock(x, secondLevelHeight+1, z).setType(Material.TORCH);
							}	
						}
					}//end x for loop
				
				chunk.getBlock(7, secondLevelHeight, 3).setType(blockType[randBlock]);
				chunk.getBlock(7, secondLevelHeight, 1).setType(Material.AIR);
				chunk.getBlock(7, secondLevelHeight+1, 3).setType(Material.TORCH);
				
				chunk.getBlock(11, secondLevelHeight, 7).setType(blockType[randBlock]);
				chunk.getBlock(13, secondLevelHeight, 7).setType(Material.AIR);
				chunk.getBlock(11, secondLevelHeight+1, 7).setType(Material.TORCH);
				
				chunk.getBlock(7, secondLevelHeight, 11).setType(blockType[randBlock]);
				chunk.getBlock(7, secondLevelHeight, 13).setType(Material.AIR);
				chunk.getBlock(7, secondLevelHeight+1, 11).setType(Material.TORCH);
				
				chunk.getBlock(3, secondLevelHeight, 7).setType(blockType[randBlock]);
				chunk.getBlock(1, secondLevelHeight, 7).setType(Material.AIR);
				chunk.getBlock(3, secondLevelHeight+1, 7).setType(Material.TORCH);
		
				
				/*third level generator for square tower*/			
				for(x=5;x<10; ++x){
					for (z=6;z<9;++z){
						for (int i=0; (y+i)<thirdLevelHeight; ++i)
							chunk.getBlock(x, y+i, z).setType(blockType[randBlock]);		
						}
					}//end x for loop
				for (int i=0; (y+i)<thirdLevelHeight; ++i){
					chunk.getBlock(7, y+i+1, 9).setType(blockType[randBlock]);
					chunk.getBlock(7, y+i+1, 5).setType(blockType[randBlock]);
				}
				chunk.getBlock(7, thirdLevelHeight+1, 9).setType(Material.TORCH);
				chunk.getBlock(7, thirdLevelHeight+1, 5).setType(Material.TORCH);
				
				chunk.getBlock(5, thirdLevelHeight, 6).setType(blockType[randBlock]);
				chunk.getBlock(5, thirdLevelHeight+1, 6).setType(Material.TORCH);
				
				chunk.getBlock(9, thirdLevelHeight, 6).setType(blockType[randBlock]);
				chunk.getBlock(9, thirdLevelHeight+1, 6).setType(Material.TORCH);
				
				chunk.getBlock(9, thirdLevelHeight, 8).setType(blockType[randBlock]);
				chunk.getBlock(9, thirdLevelHeight+1, 8).setType(Material.TORCH);
				
				chunk.getBlock(5, thirdLevelHeight, 8).setType(blockType[randBlock]);
				chunk.getBlock(5, thirdLevelHeight+1, 8).setType(Material.TORCH);
				
			
				}
		}//end else
	}

}			//mv create hill normal -g TerrainGenerator

