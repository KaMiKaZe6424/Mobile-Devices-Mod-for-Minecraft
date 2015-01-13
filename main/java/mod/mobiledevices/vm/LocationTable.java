package mod.mobiledevices.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import mod.mobiledevices.blocks.src.RouterLocationLink;
import net.minecraft.client.Minecraft;

import org.yaml.snakeyaml.Yaml;

public class LocationTable {
	
	private static HashMap<String, RouterLocationLink> table;
	Yaml yml;
	File save;
	
	public LocationTable() {
		table = new HashMap();
		yml = new Yaml();
		save = new File(Minecraft.getMinecraft().theWorld.getSaveHandler().getWorldDirectory().getAbsolutePath() + "/RouterLocationLinks.yml");
	}
	
	public void addEntry(RouterLocationLink l) {
		table.put(l.getID(), l);
	}
	
	private void load() {
		try {
			table = (HashMap<String, RouterLocationLink>) yml.load(new FileReader(save));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void save() {
		try {
			yml.dump(table, new FileWriter(save));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
