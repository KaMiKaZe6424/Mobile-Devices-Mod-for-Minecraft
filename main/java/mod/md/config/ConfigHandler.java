package mod.md.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		
		//put config(id's,booleans,...) between these commands.(The item id's you get with .getblock... are shifthed by +256 (so you have to add " - 256" at the end of the saving of an id))
		config.save();
	}
	
}
