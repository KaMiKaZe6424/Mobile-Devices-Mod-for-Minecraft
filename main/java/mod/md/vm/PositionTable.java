package mod.md.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mod.md.src.RouterLink;
import net.minecraft.client.Minecraft;

import org.yaml.snakeyaml.Yaml;

public class PositionTable {
	
	List<RouterLink> links;
	Yaml yml;
	File save;
	File savep;
	
	public PositionTable() {
		links = new ArrayList<RouterLink>();
		yml = new Yaml();
		save = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "MD/links.yml");
		savep = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "MD");
	}
	
	public void update() {
		try {
			links = (List<RouterLink>) yml.load(new FileReader(save));
		} catch (FileNotFoundException e) {
			links.clear();
		}
	}
	
	public void addEntry(RouterLink link) {
		links.add(link);
		save();
	}
	
	public void deleteEntry(RouterLink link) {
		links.remove(link);
		save();
	}
	
	public void save() {
		try {
			if (!save.exists()) {
				savep.mkdirs();
				save.createNewFile();
			}
			System.out.println(links.toString());
			yml.dump((links != null) ? links : new ArrayList<RouterLink>(), new FileWriter(save));
			System.out.println(save.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}
