package mod.md.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
		Collection<RouterLink> del = new LinkedList<RouterLink>();
		for (RouterLink l : links) {
			if (link.getX() == l.getX() && link.getY() == l.getY() && link.getZ() == l.getZ() && link.getWorldName().equalsIgnoreCase(l.getWorldName())) {
				del.add(l);
			}
		}
		links.removeAll(del);
		save();
	}
	
	public void save() {
		try {
			if (!save.exists()) {
				savep.mkdirs();
				save.createNewFile();
			}
			yml.dump((links != null) ? links : new ArrayList<RouterLink>(), new FileWriter(save));
		} catch (Exception e) {
			try {
				yml.dump((links != null) ? links : new ArrayList<RouterLink>(), new FileWriter(save));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
