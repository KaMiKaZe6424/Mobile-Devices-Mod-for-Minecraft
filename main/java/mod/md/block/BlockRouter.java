package mod.md.block;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;

import mod.md.src.RouterLink;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class BlockRouter extends Block {

	protected BlockRouter(Material m) {
		super(Material.iron);
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		link = new RouterLink(getLastId());
		link.setWorldName(world.getWorldInfo().getWorldName());
		link.setX(x);
		link.setY(y);
		link.setZ(z);
		
		return 0;
	}
	
	private long getLastId() {
		File f = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/MD/ids.txt");
		List<Long> ids;
		Yaml yaml = new Yaml();
		if (f.exists()) {
			try {
				ids = (List<Long>) yaml.load(new FileReader(f));
				return ids.get(ids.size()-1);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return 0;
		} else{ 
			ids = new ArrayList<Long>();
			ids.add(0L);
			try {
				yaml.dump(ids, new FileWriter(f));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
	
	private RouterLink link;

}
