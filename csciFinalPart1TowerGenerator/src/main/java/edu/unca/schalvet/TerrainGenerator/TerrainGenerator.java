package edu.unca.schalvet.TerrainGenerator;

import java.util.logging.Logger;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class TerrainGenerator extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	
	//ClassListeners
	//private final TerrainGeneratorCommandExecutor commandExecutor = new TerrainGeneratorCommandExecutor(this);
	//private final TerrainGeneratorEventListener eventListener = new TerrainGeneratorEventListener(this);
	//ClassListeners

	
	
	public void onDisable() {
		this.logMessage("Disabled.");
		
	}

	public void onEnable() { 
		
		this.logMessage("Enabled.");

	//	PluginManager pm = this.getServer().getPluginManager();

		//getCommand("pluggin").setExecutor(commandExecutor);

//		pm.registerEvents(eventListener, this);
	
	}
	
	public void logMessage(String msg){
		PluginDescriptionFile pdFile= this.getDescription();
		this.log.info(pdFile.getName()+" "+ pdFile.getVersion()+ ": "+msg);
		
	}
	
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String uid){
		return new TerrainGeneratorGenerator(this);
		
	}
}
