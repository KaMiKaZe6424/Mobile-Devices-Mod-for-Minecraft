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
	
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		String name = world.getWorldInfo().getWorldName();
		if (!name.equalsIgnoreCase("mpserver")) {
			RouterLink link = new RouterLink();
			link.setWorldName(name);
			link.setX(x);
			link.setY(y);
			link.setZ(z);
			
			MDMod.getPositionTable().addEntry(link);
			
		}
		return 0;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		String name = world.getWorldInfo().getWorldName();
			RouterLink link = new RouterLink();
			link.setWorldName(name);
			link.setX(x);
			link.setY(y);
			link.setZ(z);
			
			MDMod.getPositionTable().deleteEntry(link);
			
		
	}

}
