package mod.mobiledevices.blocks;

import java.util.Date;

import mod.mobiledevices.blocks.src.RouterLocationLink;
import mod.mobiledevices.vm.LocationTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.sun.jmx.snmp.Timestamp;

public class BlockRouter extends Block {
	
	private String id;
	private RouterLocationLink link;
	private BlockPos pos;

	public BlockRouter() {
		super(Material.iron);
	}
	
	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer p) {
		{
			setID();
			link = new RouterLocationLink(this);
			new LocationTable().addEntry(link);
		}
	}
	
	public int getX() {
		return pos.getX();
	}
	
	public int getY() {
		return pos.getY();
	}
	
	public int getZ() {
		return pos.getZ();
	}
	
	private void setID() {
		Date date = new Date();
		id = new Timestamp(date.getTime()).toString();
	}
	
	public String getID() {
		return id;
	}
	
	public static String getName() {
		return "blockRouter";
	}
	
	

}
