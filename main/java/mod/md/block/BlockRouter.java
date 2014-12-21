package mod.md.block;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;

import mod.md.MDMod;
import mod.md.src.RouterLink;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class BlockRouter extends Block {

	protected BlockRouter(Material m) {
		super(Material.iron);
	}
	
	public static BlockRouter newInstance() {
		return new BlockRouter(null);
	}
	
	private RouterLink link;
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		link = new RouterLink(getLastId());
		link.setWorldName(world.getWorldInfo().getWorldName());
		link.setX(x);
		link.setY(y);
		link.setZ(z);
		
		MDMod.getPositionTable().addEntry(link);
		
		return 0;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta) {
		MDMod.getPositionTable().deleteEntry(link);
	}
	
	private long getLastId() {
		File f = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "MD");
		File f1 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "MD/ids.yml");
		List<Long> ids;
		Yaml yaml = new Yaml();
		if (f.exists()) {
			try {
				ids = (List<Long>) yaml.load(new FileReader(f1));
				Long last = Long.valueOf(String.valueOf(ids.get(ids.size()-1)));
				ids.add(last + 1);
				yaml.dump(ids, new FileWriter(f1));
				return last;
			} catch (FileNotFoundException e) {
				ids = new ArrayList<Long>();
				ids.add(0L);
				try {
					f.mkdirs();
					f1.createNewFile();
					yaml.dump(ids, new FileWriter(f1));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 0;
		} else{ 
			ids = new ArrayList<Long>();
			ids.add(0L);
			try {
				f.mkdirs();
				f1.createNewFile();
				yaml.dump(ids, new FileWriter(f1));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 0;
		}
	}

}
